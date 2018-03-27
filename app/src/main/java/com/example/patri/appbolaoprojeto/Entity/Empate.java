package com.example.patri.appbolaoprojeto.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.dsl.Unique;

import java.io.Serializable;

/**
 * Created by patri on 24/03/2018.
 */
public class Empate extends SugarRecord implements Serializable {
    public Empate(Integer qtMandante, Integer qtTotal, Integer qtVisitante) {
        this.qtMandante = qtMandante;
        this.qtTotal = qtTotal;
        this.qtVisitante = qtVisitante;
    }

    public Empate(String cdEquipe, Integer qtMandante, Integer qtTotal, Integer qtVisitante) {

        this.cdEquipe = cdEquipe;
        this.qtMandante = qtMandante;
        this.qtTotal = qtTotal;
        this.qtVisitante = qtVisitante;
    }

    public Empate(){}
    @Unique
    private String cdEquipe;

    public String getCdEquipe() {
        return cdEquipe;
    }

    public void setCdEquipe(String cdEquipe) {
        this.cdEquipe = cdEquipe;
    }

    @SerializedName("qtMandante")
    @Expose
    private Integer qtMandante;
    @SerializedName("qtTotal")
    @Expose
    private Integer qtTotal;
    @SerializedName("qtVisitante")
    @Expose
    private Integer qtVisitante;

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

}
