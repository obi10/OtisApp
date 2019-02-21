package com.junicode.otisapp.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class TrabajoLab {
    private static TrabajoLab sTrabajoLab;
    private List<Trabajo> listaTrabajos;

    public static TrabajoLab get(Context context) {
        if (sTrabajoLab == null) {
            sTrabajoLab = new TrabajoLab(context);
        }
        return sTrabajoLab;
    }

    private TrabajoLab(Context context) {
        listaTrabajos = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Trabajo trabajo = new Trabajo("T" + (i+1));
            trabajo.setNombre("Trabajo #" + (i+1));
            trabajo.setTipoTrabajo('c');
            listaTrabajos.add(trabajo);
        }

        for (int i = 15; i < 90; i++) {
            Trabajo trabajo = new Trabajo("T" + (i+1));
            trabajo.setNombre("Trabajo #" + (i+1));
            trabajo.setTipoTrabajo('p');
            listaTrabajos.add(trabajo);
        }
    }

    public List<Trabajo> getTrabajos() {
        return listaTrabajos;
    }

    public Trabajo getTrabajo(String id) {
        for (Trabajo trabajo : listaTrabajos) {
            if (trabajo.getIdTrabajo().equals(id)) return trabajo;
        }
        return null;
    }

    public List<Trabajo> getTrabajosXTipo(char tipo) {
        List<Trabajo> listaTrabajosXTipo = new ArrayList<>();
        for (Trabajo trabajo : listaTrabajos) {
            if (trabajo.getTipoTrabajo() == tipo) listaTrabajosXTipo.add(trabajo);
        }
        return listaTrabajosXTipo;
    }
}
