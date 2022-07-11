package br.univille.dacs2022.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 500)
    private String name;
    private String CRM;
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private List<Procedimento> listProcedimentos = 
        new ArrayList<>();

    public List<Procedimento> getListaProcedimentos() {
        return listProcedimentos;
    }
    public void setListaProcedimentos(List<Procedimento> listProcedimentos) {
        this.listProcedimentos = listProcedimentos;
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
    public String getCRM() {
        return CRM;
    }
    public void setCRM(String cRM) {
        CRM = cRM;
    }

    

}
