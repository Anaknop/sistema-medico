package br.univille.dacs2022.service;

import java.util.List;

import br.univille.dacs2022.dto.CityDTO;

public interface CityService {
    public List<CityDTO> getAll();
    public CityDTO findById(long id);

}
