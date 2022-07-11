package br.univille.dacs2022.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import br.univille.dacs2022.dto.CityDTO;
import br.univille.dacs2022.entity.City;

@Mapper(componentModel = "spring")
public interface CityMapper {
    List<CityDTO> mapListCity(List<City> city);
    List<City> mapListCityDTO(List<CityDTO> city);

    CityDTO mapCity(City city);
    City mapCityDTO(CityDTO city);
}
