package com.example.patri.appbolaoprojeto.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.dsl.Unique;

import java.io.Serializable;

/**
 * Created by patri on 24/03/2018.
 */
public class Derrota extends SugarRecord implements Serializable {

    //declaracao de atributos
    @Unique
    private String cdEquipe;

    @SerializedName("qtMandante")
    @Expose
    private Integer qtMandante;

    @SerializedName("qtTotal")
    @Expose
    private Integer qtTotal;

    @SerializedName("qtVisitante")
    @Expose
    private Integer qtVisitante;

    //declaracao de getter and setter
    public String getCdEquipe() {
        return cdEquipe;
    }

    public void setCdEquipe(String cdEquipe) {
        this.cdEquipe = cdEquipe;
    }

    public Integer getQtMandante() {
        return qtMandante;
    }

    public void setQtMandante(Integer qtMandante) {
        this.qtMandante = qtMandante;
    }

    public Integer getQtTotal() {
        return qtTotal;
    }

    public void setQtTotal(Integer qtTotal) {
        this.qtTotal = qtTotal;
    }

    public Integer getQtVisitante() {
        return qtVisitante;
    }

    public void setQtVisitante(Integer qtVisitante) {
        this.qtVisitante = qtVisitante;
    }

    //declaracao de construtores
    public Derrota(){}

    public Derrota(Integer qtMandante, Integer qtTotal, Integer qtVisitante) {
        this.qtMandante = qtMandante;
        this.qtTotal = qtTotal;
        this.qtVisitante = qtVisitante;
    }

    public Derrota(String cdEquipe, Integer qtMandante, Integer qtTotal, Integer qtVisitante) {

        this.cdEquipe = cdEquipe;
        this.qtMandante = qtMandante;
        this.qtTotal = qtTotal;
        this.qtVisitante = qtVisitante;
    }

}
