package main.java.model;

import main.java.exceptions.ErroComissao;

public class DentistaComissionado extends Dentista {
    private double porcentagemComissao;

    public DentistaComissionado(String nome, String email, boolean sexo, String cro, double porcentagemComissao) {
        super(nome, email, sexo, cro);
        try {
            setPorcentagemComissao(porcentagemComissao);
        } catch (ErroComissao e) {
            System.out.println(e.getMessage());
        }
    }

    public DentistaComissionado(String nome, String email, boolean sexo, String cro, double porcentagemComissao, String id) {
        super(nome, email, sexo, cro, id);
        try {
            setPorcentagemComissao(porcentagemComissao);
        } catch (ErroComissao e) {
            System.out.println(e.getMessage());
        }
    }

    public DentistaComissionado(DentistaComissionado dentista) {
        super(dentista.getNome(), dentista.getEmail(), dentista.sexo, dentista.getCro());
        this.porcentagemComissao = dentista.getPorcentagemComissao();
    }

    public boolean setPorcentagemComissao(double porcentagemComissao) throws ErroComissao {
        if (porcentagemComissao > 0.5 || porcentagemComissao < 0) {
            throw new ErroComissao("Porcentagem de comissao invalida!");
        }
        this.porcentagemComissao = porcentagemComissao;
        return true;
    }

    public double getPorcentagemComissao() {
        return this.porcentagemComissao;
    }

    @Override
    public double getSalario() {
        return Agenda.faturamentoClinicaDentista(this) * this.porcentagemComissao;
    }

    @Override
    public Dentista getDentista() {
        return new DentistaComissionado(this.nome, this.email, this.sexo, this.cro, this.porcentagemComissao, this.id);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getTipoDentista() {
        return "Dentista Comissionado";
    }
}
