package main.java.model;

public class Procedimento {
    private static int sequencial;
    private String id;
    private String tratamento;
    private double valor;

    public Procedimento(String tratamento, double valor) {
        this.id = "PO" + ++this.sequencial;
        this.tratamento = tratamento;
        this.valor = valor;
    }

    public Procedimento(Procedimento procedimento) {
        this.id = procedimento.id;
        this.tratamento = procedimento.tratamento;
        this.valor = procedimento.valor;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return this.getTratamento() + " - R$ " + this.getValor();
    }
}
