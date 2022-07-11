package br.univille.dacs2022.service.impl;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.dacs2022.dto.PatientDTO;
import br.univille.dacs2022.entity.Patient;
import br.univille.dacs2022.mapper.PatientMapper;
import br.univille.dacs2022.repository.PatientRepository;
import br.univille.dacs2022.service.PatientService;

@Service
public class PatientServiceImpl 
    implements PatientService{
    
    @Autowired
    private PatientRepository repository;
    
    private PatientMapper mapper 
        = Mappers.getMapper(PatientMapper.class);

    
    @Override
    public List<PatientDTO> getAll() {
        return mapper.mapListPatient(repository.findAll());
    }


    @Override
    public PatientDTO save(PatientDTO patient) {
        Patient patientEntity = mapper.mapPatientDTO(patient);
        patientEntity = repository.save(patientEntity);
        return mapper.mapPatient(patientEntity);
    }


    @Override
    public PatientDTO findById(long id) {
        Optional<Patient> patientEntity = 
            repository.findById(id);

        if (patientEntity.isPresent()){
            return mapper.mapPatient(patientEntity.get());
        }

        return new PatientDTO();
    }


    @Override
    public PatientDTO delete(long id) {
        Optional<Patient> patientEntity = 
            repository.findById(id);

        if (patientEntity.isPresent()){
            Patient patient  = patientEntity.get();
            repository.delete(patient);
            return mapper.mapPatient(patient);
        }
        return null;
    }
    
}
