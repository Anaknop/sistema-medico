package br.univille.dacs2022.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//POJO - Plain Old Java Object
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 500)
    private String name;
    private String gender;
    @Temporal(value = TemporalType.DATE)
    private Date birthday;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private City city;
    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private List<HealthPlan> listPlans = new ArrayList<>();

    public List<HealthPlan> getListPlans() {
        return listPlans;
    }
    public void setListaPlans(List<HealthPlan> listPlans) {
        this.listPlans = listPlans;
    }
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }
    public long getId() {
        return id;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

}
