package main.java.api;

import main.java.model.Consulta;

import java.util.Comparator;

public class OrdenaPaciente  implements Comparator<Consulta> {
    public int compare(Consulta consulta1, Consulta consulta2){
        String nomePaciente1 = consulta1.getPaciente().getNome();
        String nomePaciente2 = consulta2.getPaciente().getNome();
        return nomePaciente1.compareTo(nomePaciente2);
    }
}