package main.java.model;

import main.java.intarfaces.TratamentoFormal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Paciente extends Registro implements TratamentoFormal {
    private static int sequencial;
    private LocalDate dataDeNascimento;
    private static final DateTimeFormatter formatacaoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Paciente(String nome, String email, boolean sexo, LocalDate dataDeNascimento) {
        super(nome, email, sexo);
        this.dataDeNascimento = dataDeNascimento;
        super.setId("PA" + ++this.sequencial);
    }

    public Paciente(Paciente paciente) {
        super(paciente.getNome(), paciente.getEmail(), paciente.sexo);
        super.setId(paciente.getId());
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    @Override
    public String toString() {
        return this.getTratamento() + " - Email: " + super.getEmail() + "\nNascimento: " + formatacaoData.format(this.getDataDeNascimento());
    }

    @Override
    public String getTratamento() {
        String[] sobreNome = getNome().split(" ");
        if (this.sexo) {
            return "Senhor " + sobreNome[sobreNome.length - 1];
        } else {
            return "Senhora " + sobreNome[sobreNome.length - 1];
        }
    }

    public double calcularGastos() {
        return Agenda.calculoDeGastosDoPaciente(this);
    }
}
