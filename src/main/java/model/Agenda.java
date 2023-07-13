package main.java.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

import main.java.api.*;

public class Agenda {
    private static Agrupamento<Consulta> listaDeConsultas = new Agrupamento();

    public Agenda() {
        this.listaDeConsultas = new Agrupamento<Consulta>();
    }

    public boolean adicionarConsulta(Consulta consulta) {
        return listaDeConsultas.adicionar(consulta);
    }

    public boolean removerConsulta(Consulta consulta) {
        return listaDeConsultas.remover(consulta);
    }

    public boolean verificarConsulta(Consulta consulta) {
        return listaDeConsultas.contem(consulta);
    }

    public int quantidadeDeConsultas() {
        return this.listaDeConsultas.tamanho();
    }

    public double calcularFaturamento() {
        double recebido = 0;
        for (Consulta consulta : listaDeConsultas.getListagem()) {
            recebido += consulta.getValorConsulta();
        }
        return recebido;
    }

    public String toString() {
        String descritivo = new String();
        for (Consulta consulta : listaDeConsultas.getListagem()) {
            descritivo += consulta.toString() + "\n";
        }
        return "Lista de consultas:\n" + descritivo;
    }

    public String getOrdenacaoPaciente() {
        ArrayList<Consulta> lista = new ArrayList<>();
        lista = listaDeConsultas.getListagem();
        Collections.sort(lista, new OrdenaPaciente());
        String pacientesOrdenados = new String();
        for (Consulta consulta : lista) {
            pacientesOrdenados += consulta.getPaciente().getNome() + "\nValor Dentista: " + consulta.getDentista().getSalario()
                    + "\nValor Clinica: " + (faturamentoClinicaDentista(consulta.getDentista()) -
                    consulta.getDentista().getSalario()) + "\n";
        }
        return pacientesOrdenados;
    }

    public String getOrdenacaoDentista() {
        ArrayList<Consulta> lista = new ArrayList<>();
        lista = listaDeConsultas.getListagem();
        Collections.sort(lista, new OrdenaDentista());
        String dentistasOrdenados = new String();
        for (Consulta consulta : lista) {
            dentistasOrdenados += consulta.getDentista().getTratamento() + "\nValor Dentista: " + consulta.getDentista().getSalario()
                    + "\nValor Clinica: " + (faturamentoClinicaDentista(consulta.getDentista()) -
                    consulta.getDentista().getSalario()) + "\n";
        }
        return dentistasOrdenados;
    }

    public static double faturamentoClinicaDentista(Dentista dentista) {
        double valorDentista = 0;
        for (Consulta consulta : listaDeConsultas.getListagem()) {
            if (dentista.getNome().equals(consulta.getDentista().getNome())) {
                valorDentista += consulta.getValorConsulta();
            }
        }
        return valorDentista;
    }

    public static double calculoDeGastosDoPaciente(Paciente paciente) {
        double valorAoPaciente = 0;
        for (Consulta consulta : listaDeConsultas.getListagem()) {
            if (paciente.getId().equals(consulta.getPaciente().getId())) {
                valorAoPaciente += consulta.getValorConsulta();
            }
        }
        return valorAoPaciente;
    }

    public void esvaziarAgenda() {
        listaDeConsultas.esvaziarListagem();
    }
}
