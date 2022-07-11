package br.univille.dacs2022.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(value = TemporalType.DATE)
    private Date data;
    private String status;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Patient patient;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Consulta_ID")
    private List<ProcedimentoRealizado> listProcedimentos
        = new ArrayList<>();
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Medico medicoResponsavel;

    
    public List<ProcedimentoRealizado> getListaProcedimentos() {
        return listProcedimentos;
    }
    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }
    public void setMedicoResponsavel(Medico medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }
    public void setListaProcedimentos(List<ProcedimentoRealizado> listProcedimentos) {
        this.listProcedimentos = listProcedimentos;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    
}
