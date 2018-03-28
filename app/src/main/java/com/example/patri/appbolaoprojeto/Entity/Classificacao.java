package com.example.patri.appbolaoprojeto.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.dsl.NotNull;
import com.orm.dsl.Unique;

import java.io.Serializable;
import java.util.List;

public class Classificacao extends SugarRecord implements Serializable{

    @Unique
    @SerializedName("cdEquipe")
    @Expose
    private String cdEquipe;

    @SerializedName("golsPro")
    @Expose
    private Integer golsPro;

    @SerializedName("golsContra")
    @Expose
    private Integer golsContra;

    @SerializedName("saldoGols")
    @Expose
    private Integer saldoGols;

    @SerializedName("pos")
    @Expose
    private String pos;

    @SerializedName("ganhoPos")
    @Expose
    private String ganhoPos;

    @SerializedName("pontosGanhos")
    @Expose
    private List<PontosGanhos> pontosGanhos;

    @SerializedName("jogos")
    @Expose
    private List<Jogos> jogos;

    @SerializedName("vitoria")
    @Expose
    private List<Vitoria> vitoria;

    @SerializedName("empate")
    @Expose
    private List<Empate> empate;

    @SerializedName("derrota")
    @Expose
    private List<Derrota> derrota;

    @SerializedName("aproveitamento")
    @Expose
    private Double aproveitamento;

    public Classificacao(){}

    public String getCdEquipe() {
        return cdEquipe;
    }

    public void setCdEquipe(String cdEquipe) {
        this.cdEquipe = cdEquipe;
    }

    public Integer getGolsPro() {
        return golsPro;
    }

    public void setGolsPro(Integer golsPro) {
        this.golsPro = golsPro;
    }

    public Integer getGolsContra() {
        return golsContra;
    }

    public void setGolsContra(Integer golsContra) {
        this.golsContra = golsContra;
    }

    public Integer getSaldoGols() {
        return saldoGols;
    }

    public void setSaldoGols(Integer saldoGols) {
        this.saldoGols = saldoGols;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getGanhoPos() {
        return ganhoPos;
    }

    public void setGanhoPos(String ganhoPos) {
        this.ganhoPos = ganhoPos;
    }

    public List<PontosGanhos> getPontosGanhos() {
        return pontosGanhos;
    }

    public void setPontosGanhos(List<PontosGanhos> pontosGanhos) {
        this.pontosGanhos = pontosGanhos;
    }

    public List<Jogos> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogos> jogos) {
        this.jogos = jogos;
    }

    public List<Vitoria> getVitoria() {
        return vitoria;
    }

    public void setVitoria(List<Vitoria> vitoria) {
        this.vitoria = vitoria;
    }

    public List<Empate> getEmpate() {
        return empate;
    }

    public void setEmpate(List<Empate> empate) {
        this.empate = empate;
    }

    public List<Derrota> getDerrota() {
        return derrota;
    }

    public void setDerrota(List<Derrota> derrota) {
        this.derrota = derrota;
    }

    public Double getAproveitamento() {
        return aproveitamento;
    }

    public void setAproveitamento(Double aproveitamento) {
        this.aproveitamento = aproveitamento;
    }

}