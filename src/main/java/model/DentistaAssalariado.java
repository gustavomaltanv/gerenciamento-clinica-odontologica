package main.java.model;

public class DentistaAssalariado extends Dentista {
    public DentistaAssalariado(String nome, String email, boolean sexo, String cro, double salario) {
        super(nome, email, sexo, cro);
        super.salario = salario;
    }

    public DentistaAssalariado(String nome, String email, boolean sexo, String cro, double salario, String id) {
        super(nome, email, sexo, cro, id);
        super.salario = salario;
    }

    public DentistaAssalariado(Dentista dentista) {
        super(dentista);
        this.setSalario(salario);
    }

    public void setSalario(double salario) {
        super.salario = salario;
    }

    @Override
    public double getSalario() {
        return super.salario;
    }

    @Override
    public Dentista getDentista() {
        return new DentistaAssalariado(this.nome, this.email, this.sexo, this.cro, this.salario, this.id);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getTipoDentista() {
        return "Dentista Assalariado";
    }
}
