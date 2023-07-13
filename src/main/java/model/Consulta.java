package main.java.model;

import java.util.ArrayList;

public class Consulta {
    private Procedimento procedimento;
    private Dentista dentista;
    private Paciente paciente;

    public Consulta(Procedimento procedimento, Dentista dentista, Paciente paciente) {
        this.dentista = dentista;
        this.paciente = paciente;
        this.procedimento = procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public Procedimento getProcedimento() {
        return new Procedimento(this.procedimento);
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public Dentista getDentista() {
        return this.dentista.getDentista();
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Paciente getPaciente() {
        return new Paciente(this.paciente);
    }

    public double getValorConsulta() {
        return procedimento.getValor();
    }

    @Override
    public String toString() {
        return procedimento.toString() + "\nDentista responsável: " + dentista.getTratamento() + "\nPaciente: " + paciente.getTratamento();
    }
}
