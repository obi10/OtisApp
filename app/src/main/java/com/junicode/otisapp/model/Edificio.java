package com.junicode.otisapp.model;


public class Edificio {
    private String numContrato;
    private String nombre;
    private float ruc;
    private String direccion;
    private Contacto objContacto;

    public Edificio(String numContrato, String nombre, float ruc, String direccion, Contacto objContacto) {
        this.numContrato = numContrato;
        this.nombre = nombre;
        this.ruc = ruc;
        this.direccion = direccion;
        this.objContacto = objContacto;
    }

    public String getNumContrato() {
        return numContrato;
    }

    public void setNumContrato(String numContrato) {
        this.numContrato = numContrato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getRuc() {
        return ruc;
    }

    public void setRuc(float ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Contacto getObjContacto() {
        return objContacto;
    }

    public void setObjContacto(Contacto objContacto) {
        this.objContacto = objContacto;
    }
}
