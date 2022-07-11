package br.univille.dacs2022.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import br.univille.dacs2022.dto.PatientDTO;
import br.univille.dacs2022.entity.Patient;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    List<PatientDTO> mapListPatient(List<Patient> patient);
    List<Patient> mapListPatientDTO(List<PatientDTO> patient);

    PatientDTO mapPatient(Patient patient);
    Patient mapPatientDTO(PatientDTO patient);
}
