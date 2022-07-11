package br.univille.dacs2022.service.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.dacs2022.dto.HealthPlanDTO;
import br.univille.dacs2022.mapper.HealthPlanMapper;
import br.univille.dacs2022.repository.HealthPlanRepository;
import br.univille.dacs2022.service.HealthPlanService;

@Service
public class HealthPlanServiceImpl implements HealthPlanService{
    @Autowired
    private HealthPlanRepository repository;
    private HealthPlanMapper mapper 
        = Mappers.getMapper(HealthPlanMapper.class);

    @Override
    public List<HealthPlanDTO> getAll() {
        var listPlans = repository.findAll();
        return mapper.mapListHealthPlan(listPlans);
    }

    @Override
    public HealthPlanDTO getById(long id) {
        var plano = repository.findById(id);
        return mapper.mapHealthPlan(plano.get());
    }
    
}
