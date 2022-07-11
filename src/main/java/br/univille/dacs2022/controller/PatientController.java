package br.univille.dacs2022.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.dacs2022.dto.PatientDTO;
import br.univille.dacs2022.service.CityService;
import br.univille.dacs2022.service.PatientService;
import br.univille.dacs2022.service.HealthPlanService;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService service;
    @Autowired
    private CityService cityService;
    @Autowired
    private HealthPlanService healthPlanService;

    @GetMapping
    public ModelAndView index() {
        List<PatientDTO> listPatients = service.getAll();

        return new ModelAndView("patient/index",
                "listPatients", listPatients);
    }

    @GetMapping("/create")
    public ModelAndView create() {
        var patient = new PatientDTO();
        var listCitys = cityService.getAll();
        var listPlans = healthPlanService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("patient", patient);
        dados.put("listCitys", listCitys);
        dados.put("listPlans", listPlans);
        return new ModelAndView("patient/form", dados);
    }

    @PostMapping(params = "save")
    public ModelAndView save(@Valid @ModelAttribute("patient") PatientDTO patient,
            BindingResult bindingResult) {
        var cityDTO = cityService.findById(patient.getCityId());
        patient.setCity(cityDTO);
        if (bindingResult.hasErrors()) {
            var listCitys = cityService.getAll();
            HashMap<String, Object> dados = new HashMap<>();
            dados.put("listCitys", listCitys);
            return new ModelAndView("patient/form", dados);
        }
        service.save(patient);
        return new ModelAndView("redirect:/patient");
    }

    @PostMapping(params = "incplano")
    public ModelAndView incluirPlano(@Valid @ModelAttribute("patient") PatientDTO patient,
            BindingResult bindingResult) {
        var idPlanoSelect = patient.getPlanId();
        var planoSelect = healthPlanService.getById(idPlanoSelect);
        patient.getListPlans().add(planoSelect);

        var listCitys = cityService.getAll();
        var listPlans = healthPlanService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("patient", patient);
        dados.put("listCitys", listCitys);
        dados.put("listPlans", listPlans);

        return new ModelAndView("patient/form", dados);
    }

    @PostMapping(params = "removeitem")
    public ModelAndView removerPlano(@Valid @ModelAttribute("patient") PatientDTO patient,
            @RequestParam(name = "removeitem") int index,
            BindingResult bindingResult) {
        patient.getListPlans().remove(index);

        var listCitys = cityService.getAll();
        var listPlans = healthPlanService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("patient", patient);
        dados.put("listCitys", listCitys);
        dados.put("listPlans", listPlans);

        return new ModelAndView("patient/form", dados);
    }

    @GetMapping(path = "/update/{id}")
    public ModelAndView update(@PathVariable("id") long id) {
        PatientDTO patient = service.findById(id);
        var listPlans = healthPlanService.getAll();
        var listCitys = cityService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("patient", patient);
        dados.put("listCitys", listCitys);
        dados.put("listPlans", listPlans);

        return new ModelAndView("patient/form", dados);
    }

    @GetMapping(path = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        service.delete(id);
        return new ModelAndView("redirect:/patient");
    }

}
