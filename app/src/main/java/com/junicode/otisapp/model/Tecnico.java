package com.junicode.otisapp.model;

import java.util.Date;

public class Tecnico extends Trabajador{
    private char estado;

    public Tecnico(String dni, String nombre, String apellidos, String email, String telefono, String direccion, Date fechaContratacion, char estado){
        super(dni, nombre, apellidos, email, telefono, direccion, fechaContratacion);
        this.estado = estado;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
}
