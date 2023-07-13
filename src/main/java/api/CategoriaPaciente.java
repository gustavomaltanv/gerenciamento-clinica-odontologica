package main.java.api;

import main.java.model.Paciente;

import java.util.HashMap;

public class CategoriaPaciente {
    public static HashMap<Paciente, String> categoriaDoPaciente = new HashMap<>();

    public static void categorizarPaciente(Paciente paciente) {
        if (paciente.calcularGastos() <= 10000) {
            categoriaDoPaciente.put(paciente, "C");
        } else if (paciente.calcularGastos() <= 30000) {
            categoriaDoPaciente.put(paciente, "B");
        } else {
            categoriaDoPaciente.put(paciente, "A");
        }
    }
    public String getCategoria(Paciente paciente) {
        return categoriaDoPaciente.get(paciente);
    }
}
