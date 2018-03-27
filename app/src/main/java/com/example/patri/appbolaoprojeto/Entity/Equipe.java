package com.example.patri.appbolaoprojeto.Entity;

/**
 * Created by patri on 24/03/2018.
 */
import com.orm.SugarRecord;
import java.io.Serializable;
import com.orm.dsl.*;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Equipe extends SugarRecord implements Serializable{

    @Unique
    @SerializedName("cdEquipe")
    @Expose
    private String cdEquipe;

    @SerializedName("brEquipe")
    @Expose
    private String brEquipe;
    @SerializedName("corEquipe")
    @Expose
    private String corEquipe;
    @SerializedName("nmEquipe")
    @Expose
    private String nmEquipe;
    @SerializedName("nmComum")
    @Expose
    private String nmComum;

    public Equipe(String brEquipe, String corEquipe, String nmEquipe, String nmComum, String nmSlug, String sgEquipe, String tgEquipe, String tpEquipe, String uriEquipe) {
        this.brEquipe = brEquipe;
        this.corEquipe = corEquipe;
        this.nmEquipe = nmEquipe;
        this.nmComum = nmComum;
        this.nmSlug = nmSlug;
        this.sgEquipe = sgEquipe;
        this.tgEquipe = tgEquipe;
        this.tpEquipe = tpEquipe;
        this.uriEquipe = uriEquipe;
    }

    public Equipe(String cdEquipe, String brEquipe, String corEquipe, String nmEquipe, String nmComum, String nmSlug, String sgEquipe, String tgEquipe, String tpEquipe, String uriEquipe) {

        this.cdEquipe = cdEquipe;
        this.brEquipe = brEquipe;
        this.corEquipe = corEquipe;
        this.nmEquipe = nmEquipe;
        this.nmComum = nmComum;
        this.nmSlug = nmSlug;
        this.sgEquipe = sgEquipe;
        this.tgEquipe = tgEquipe;
        this.tpEquipe = tpEquipe;
        this.uriEquipe = uriEquipe;
    }

    @SerializedName("nmSlug")
    @Expose
    private String nmSlug;
    @SerializedName("sgEquipe")
    @Expose
    private String sgEquipe;
    @SerializedName("tgEquipe")
    @Expose
    private String tgEquipe;
    @SerializedName("tpEquipe")
    @Expose
    private String tpEquipe;
    @SerializedName("uriEquipe")
    @Expose
    private String uriEquipe;

    public Equipe() {}

    public String getCdEquipe() {
        return cdEquipe;
    }

    public void setCdEquipe(String cdEquipe) {
        this.cdEquipe = cdEquipe;
    }

    public String getBrEquipe() {
        return brEquipe;
    }

    public void setBrEquipe(String brEquipe) {
        this.brEquipe = brEquipe;
    }

    public String getCorEquipe() {
        return corEquipe;
    }

    public void setCorEquipe(String corEquipe) {
        this.corEquipe = corEquipe;
    }

    public String getNmEquipe() {
        return nmEquipe;
    }

    public void setNmEquipe(String nmEquipe) {
        this.nmEquipe = nmEquipe;
    }

    public String getNmComum() {
        return nmComum;
    }

    public void setNmComum(String nmComum) {
        this.nmComum = nmComum;
    }

    public String getNmSlug() {
        return nmSlug;
    }

    public void setNmSlug(String nmSlug) {
        this.nmSlug = nmSlug;
    }

    public String getSgEquipe() {
        return sgEquipe;
    }

    public void setSgEquipe(String sgEquipe) {
        this.sgEquipe = sgEquipe;
    }

    public String getTgEquipe() {
        return tgEquipe;
    }

    public void setTgEquipe(String tgEquipe) {
        this.tgEquipe = tgEquipe;
    }

    public String getTpEquipe() {
        return tpEquipe;
    }

    public void setTpEquipe(String tpEquipe) {
        this.tpEquipe = tpEquipe;
    }

    public String getUriEquipe() {
        return uriEquipe;
    }

    public void setUriEquipe(String uriEquipe) {
        this.uriEquipe = uriEquipe;
    }

}
