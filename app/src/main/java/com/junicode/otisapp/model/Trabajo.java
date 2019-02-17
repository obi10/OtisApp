package com.junicode.otisapp.model;

import java.util.Date;

public class Trabajo {

    private String idTrabajo;
    private String nombre;
    private AreaTrabajo objAreaTrabajo;
    private Maquina objMaquina;
    private Tecnico objTecnico;
    private Date fechaInicio;
    private Date fechaLimite;
    private Date fechaTermino;
    private char estado;
    private String descripcion;
    private String observacion;

    public Trabajo(String idTrabajo, String nombre, AreaTrabajo objAreaTrabajo, Maquina objMaquina, Tecnico objTecnico, Date fechaInicio, Date fechaLimite, Date fechaTermino, char estado, String descripcion, String observacion) {
        this.idTrabajo = idTrabajo;
        this.nombre = nombre;
        this.objAreaTrabajo = objAreaTrabajo;
        this.objMaquina = objMaquina;
        this.objTecnico = objTecnico;
        this.fechaInicio = fechaInicio;
        this.fechaLimite = fechaLimite;
        this.fechaTermino = fechaTermino;
        this.estado = estado;
        this.descripcion = descripcion;
        this.observacion = observacion;
    }

    public String getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(String idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public AreaTrabajo getObjAreaTrabajo() {
        return objAreaTrabajo;
    }

    public void setObjAreaTrabajo(AreaTrabajo objAreaTrabajo) {
        this.objAreaTrabajo = objAreaTrabajo;
    }

    public Maquina getObjMaquina() {
        return objMaquina;
    }

    public void setObjMaquina(Maquina objMaquina) {
        this.objMaquina = objMaquina;
    }

    public Tecnico getObjTecnico() {
        return objTecnico;
    }

    public void setObjTecnico(Tecnico objTecnico) {
        this.objTecnico = objTecnico;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
