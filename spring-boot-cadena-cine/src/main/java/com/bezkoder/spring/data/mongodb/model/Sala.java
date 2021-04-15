package com.bezkoder.spring.data.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sala")
public class Sala {

    @Id
    private String id;

    private TipoSala tipoSala;    
    private String numeroFila;
    private String maximoSilla;
 
    private Sucursal sucursal;
    
    public Sala(TipoSala tipoSala, String numeroFila, String maximoSilla,Sucursal sucursal) {
        this.tipoSala = tipoSala;
        this.numeroFila = numeroFila;
        this.maximoSilla = maximoSilla;
        this.sucursal=sucursal;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    
    
    
    public Sala() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoSala getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(TipoSala tipoSala) {
        this.tipoSala = tipoSala;
    }

    public String getNumeroFila() {
        return numeroFila;
    }

    public void setNumeroFila(String numeroFila) {
        this.numeroFila = numeroFila;
    }

    public String getMaximoSilla() {
        return maximoSilla;
    }

    public void setMaximoSilla(String maximoSilla) {
        this.maximoSilla = maximoSilla;
    }

    @Override
    public String toString() {
        return "Sala [id=" + id + ", tipoSala=" + tipoSala + ", sucursal=" + sucursal + ", numeroFila=" + numeroFila + ", maximoSilla=" + maximoSilla + "]";
    }
}
