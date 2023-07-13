package main.java.api;

import main.java.model.*;

import java.util.Comparator;

public class OrdenaDentista implements Comparator<Consulta> {
    public int compare(Consulta consulta1, Consulta consulta2){
        String nomeDentista1 = consulta1.getDentista().getNome();
        String nomeDentista2 = consulta2.getDentista().getNome();
        return nomeDentista2.compareTo(nomeDentista1);
    }
}