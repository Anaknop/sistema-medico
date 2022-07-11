package br.univille.dacs2022.service;

import java.util.List;

import br.univille.dacs2022.dto.HealthPlanDTO;


public interface HealthPlanService {
    public List<HealthPlanDTO> getAll();
    public HealthPlanDTO getById(long id);
}
