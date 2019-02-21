package com.junicode.otisapp.model;


public class Maquina {
    private String numMaquina;
    private Edificio objEdificio;
    private String nombre;
    private String marca;

    public Maquina(String numMaquina, Edificio objEdificio, String nombre, String marca){
        this.numMaquina = numMaquina;
        this.objEdificio = objEdificio;
        this.nombre = nombre;
        this.marca = marca;
    }

    public String getNumMaquina() {
        return numMaquina;
    }

    public void setNumMaquina(String numMaquina) {
        this.numMaquina = numMaquina;
    }

    public Edificio getObjEdificio() {
        return objEdificio;
    }

    public void setObjEdificio(Edificio objEdificio) {
        this.objEdificio = objEdificio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
