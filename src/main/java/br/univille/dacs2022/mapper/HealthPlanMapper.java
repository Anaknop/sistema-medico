package br.univille.dacs2022.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.dacs2022.dto.HealthPlanDTO;
import br.univille.dacs2022.entity.HealthPlan;

@Mapper
public interface HealthPlanMapper {
    List<HealthPlanDTO> mapListHealthPlan(List<HealthPlan> planoDeSaude);
    List<HealthPlan> mapListHealthPlanDTO(List<HealthPlanDTO> planoDeSaude);

    HealthPlanDTO mapHealthPlan(HealthPlan planoDeSaude);
    HealthPlan mapHealthPlanDTO(HealthPlanDTO planoDeSaude);
}
