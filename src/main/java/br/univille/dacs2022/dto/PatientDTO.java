package br.univille.dacs2022.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import br.univille.dacs2022.entity.HealthPlan;

public class PatientDTO {
    private long id;
    @NotBlank(message = "O campo name não pode ser deixado em branco")
    @NotNull
    private String name;
    @Pattern(regexp = "Masculino|Feminino", 
             flags = Pattern.Flag.CANON_EQ,
             message = "Valor inválido, utilize Masculino ou Feminino")
    private String gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private long cityId;
    private CityDTO city;
    private List<HealthPlanDTO> listPlans = new ArrayList<>();
    private long planId;
    
    public long getPlanId() {
        return planId;
    }
    public void setPlanId(long planId) {
        this.planId = planId;
    }
    public List<HealthPlanDTO> getListPlans() {
        return listPlans;
    }
    public void setListPlans(List<HealthPlanDTO> listPlans) {
        this.listPlans = listPlans;
    }
    public long getCityId() {
        return cityId;
    }
    public void setCityId(long cityId) {
        this.cityId = cityId;
    }
    

    public CityDTO getCity() {
        return city;
    }
    public void setCity(CityDTO city) {
        this.city = city;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    
}
