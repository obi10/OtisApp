package com.junicode.otisapp.model;


public class AreaTrabajo {
    private String idAreaTrabajo;
    private String nombre;

    public AreaTrabajo(String idAreaTrabajo, String nombre){
        this.idAreaTrabajo = idAreaTrabajo;
        this.nombre = nombre;
    }

    public String getId() {
        return idAreaTrabajo;
    }

    public void setId(String idAreaTrabajo) {
        this.idAreaTrabajo = idAreaTrabajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
