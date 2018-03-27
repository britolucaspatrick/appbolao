package com.example.patri.appbolaoprojeto.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.dsl.NotNull;
import com.orm.dsl.Unique;

import java.io.Serializable;

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
    private PontosGanhos pontosGanhos;

    @SerializedName("jogos")
    @Expose
    private Jogos jogos;

    @SerializedName("vitoria")
    @Expose
    private Vitoria vitoria;

    public Classificacao(String cdEquipe, Integer golsPro, Integer golsContra, Integer saldoGols, String pos, String ganhoPos, PontosGanhos pontosGanhos, Jogos jogos, Vitoria vitoria, Empate empate, Derrota derrota, Double aproveitamento) {
        this.cdEquipe = cdEquipe;
        this.golsPro = golsPro;
        this.golsContra = golsContra;
        this.saldoGols = saldoGols;
        this.pos = pos;
        this.ganhoPos = ganhoPos;
        this.pontosGanhos = pontosGanhos;
        this.jogos = jogos;
        this.vitoria = vitoria;
        this.empate = empate;
        this.derrota = derrota;
        this.aproveitamento = aproveitamento;
    }

    @SerializedName("empate")
    @Expose
    private Empate empate;

    @SerializedName("derrota")
    @Expose
    private Derrota derrota;

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

    public PontosGanhos getPontosGanhos() {
        return pontosGanhos;
    }

    public void setPontosGanhos(PontosGanhos pontosGanhos) {
        this.pontosGanhos = pontosGanhos;
    }

    public Jogos getJogos() {
        return jogos;
    }

    public void setJogos(Jogos jogos) {
        this.jogos = jogos;
    }

    public Vitoria getVitoria() {
        return vitoria;
    }

    public void setVitoria(Vitoria vitoria) {
        this.vitoria = vitoria;
    }

    public Empate getEmpate() {
        return empate;
    }

    public void setEmpate(Empate empate) {
        this.empate = empate;
    }

    public Derrota getDerrota() {
        return derrota;
    }

    public void setDerrota(Derrota derrota) {
        this.derrota = derrota;
    }

    public Double getAproveitamento() {
        return aproveitamento;
    }

    public void setAproveitamento(Double aproveitamento) {
        this.aproveitamento = aproveitamento;
    }

}