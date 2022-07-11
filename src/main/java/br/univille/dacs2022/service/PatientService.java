package br.univille.dacs2022.service;

import java.util.List;

import br.univille.dacs2022.dto.PatientDTO;

public interface PatientService {
    public List<PatientDTO> getAll();
    public PatientDTO save(PatientDTO patient);
    public PatientDTO findById(long id);
    public PatientDTO delete(long id);
}
