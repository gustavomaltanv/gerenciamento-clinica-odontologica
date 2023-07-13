package main.java.model;

import main.java.intarfaces.TratamentoFormal;

public abstract class Dentista extends Registro implements TratamentoFormal {
    protected static int sequencial;
    protected String cro;
    protected double salario;

    public Dentista() {
    }

    public Dentista(String nome, String email, boolean sexo, String cro) {
        super(nome, email, sexo);
        this.cro = cro;
        super.setId("DE" + ++this.sequencial);
    }

    public Dentista(String nome, String email, boolean sexo, String cro, String id) {
        super(nome, email, sexo);
        this.cro = cro;
        super.setId(id);
    }

    public Dentista(Dentista dentista) {
        super(dentista.getNome(), dentista.getEmail(), dentista.sexo);
        super.setId(dentista.getId());
        this.cro = dentista.cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public String getCro() {
        return cro;
    }

    public abstract Dentista getDentista();

    public abstract String getTipoDentista();

    public abstract double getSalario();

    public String toString() {
        return getTratamento() + " - Email: " + super.getEmail() + "\nCRO: " + this.getCro();
    }

    public String getTratamento() {
        if (this.sexo) {
            return "Dr. " + getNome();
        } else {
            return "Dra. " + getNome();
        }
    }
}
