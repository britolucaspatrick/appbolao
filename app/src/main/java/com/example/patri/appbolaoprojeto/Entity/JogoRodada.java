package com.example.patri.appbolaoprojeto.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.io.Serializable;

public class JogoRodada extends SugarRecord implements Serializable {

    @SerializedName("cdJogo")
    @Expose
    private Integer cdJogo;
    @SerializedName("cdEquipe2")
    @Expose
    private String cdEquipe2;
    @SerializedName("cdEquipe1")
    @Expose
    private String cdEquipe1;
    @SerializedName("stClassificougolsfora")
    @Expose
    private Boolean stClassificougolsfora;
    @SerializedName("dtJogo")
    @Expose
    private String dtJogo;
    @SerializedName("dspTime1")
    @Expose
    private String dspTime1;
    @SerializedName("dspTime2")
    @Expose
    private String dspTime2;
    @SerializedName("stEliminoujogovolta")
    @Expose
    private Boolean stEliminoujogovolta;
    @SerializedName("dsEstadio")
    @Expose
    private String dsEstadio;
    @SerializedName("hrJogo")
    @Expose
    private String hrJogo;
    @SerializedName("dsLocal")
    @Expose
    private String dsLocal;
    @SerializedName("nrJogo")
    @Expose
    private String nrJogo;
    @SerializedName("psJogo")
    @Expose
    private String psJogo;
    @SerializedName("nrRodada")
    @Expose
    private String nrRodada;
    @SerializedName("urlPosjogo")
    @Expose
    private String urlPosjogo;
    @SerializedName("urlPrejogo")
    @Expose
    private String urlPrejogo;
    @SerializedName("urlVideo")
    @Expose
    private String urlVideo;

    private int vlPalpite1;
    private int vlPalpite2;

    public int getVlPalpite1() {
        return vlPalpite1;
    }

    public void setVlPalpite1(int vlPalpite1) {
        this.vlPalpite1 = vlPalpite1;
    }

    public int getVlPalpite2() {
        return vlPalpite2;
    }

    public void setVlPalpite2(int vlPalpite2) {
        this.vlPalpite2 = vlPalpite2;
    }

    public Integer getCdJogo() {
        return cdJogo;
    }

    public void setCdJogo(Integer cdJogo) {
        this.cdJogo = cdJogo;
    }

    public String getCdEquipe2() {
        return cdEquipe2;
    }

    public void setCdEquipe2(String cdEquipe2) {
        this.cdEquipe2 = cdEquipe2;
    }

    public String getCdEquipe1() {
        return cdEquipe1;
    }

    public void setCdEquipe1(String cdEquipe1) {
        this.cdEquipe1 = cdEquipe1;
    }

    public Boolean getStClassificougolsfora() {
        return stClassificougolsfora;
    }

    public void setStClassificougolsfora(Boolean stClassificougolsfora) {
        this.stClassificougolsfora = stClassificougolsfora;
    }

    public String getDtJogo() {
        return dtJogo;
    }

    public void setDtJogo(String dtJogo) {
        this.dtJogo = dtJogo;
    }

    public String getDspTime1() {
        return dspTime1;
    }

    public void setDspTime1(String dspTime1) {
        this.dspTime1 = dspTime1;
    }

    public String getDspTime2() {
        return dspTime2;
    }

    public void setDspTime2(String dspTime2) {
        this.dspTime2 = dspTime2;
    }

    public Boolean getStEliminoujogovolta() {
        return stEliminoujogovolta;
    }

    public void setStEliminoujogovolta(Boolean stEliminoujogovolta) {
        this.stEliminoujogovolta = stEliminoujogovolta;
    }

    public String getDsEstadio() {
        return dsEstadio;
    }

    public void setDsEstadio(String dsEstadio) {
        this.dsEstadio = dsEstadio;
    }

    public String getHrJogo() {
        return hrJogo;
    }

    public void setHrJogo(String hrJogo) {
        this.hrJogo = hrJogo;
    }

    public String getDsLocal() {
        return dsLocal;
    }

    public void setDsLocal(String dsLocal) {
        this.dsLocal = dsLocal;
    }

    public String getNrJogo() {
        return nrJogo;
    }

    public void setNrJogo(String nrJogo) {
        this.nrJogo = nrJogo;
    }

    public String getPsJogo() {
        return psJogo;
    }

    public void setPsJogo(String psJogo) {
        this.psJogo = psJogo;
    }

    public String getNrRodada() {
        return nrRodada;
    }

    public void setNrRodada(String nrRodada) {
        this.nrRodada = nrRodada;
    }

    public String getUrlPosjogo() {
        return urlPosjogo;
    }

    public void setUrlPosjogo(String urlPosjogo) {
        this.urlPosjogo = urlPosjogo;
    }

    public String getUrlPrejogo() {
        return urlPrejogo;
    }

    public void setUrlPrejogo(String urlPrejogo) {
        this.urlPrejogo = urlPrejogo;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

}
