package test.java.model;

import main.java.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

public class AgendaTest {

    DentistaComissionado d1;
    Paciente p1;
    Procedimento po1;
    Consulta c1;
    Agenda a1;

    @BeforeEach
    public void init() {
        d1 = new DentistaComissionado("Rafael da Silva", "rfsilva@email.com", true, "1234", 0.3);
        p1 = new Paciente("Jose da Silva", "jssilva@email.com", true, LocalDate.of(1996, 06, 12));
        po1 = new Procedimento("Tratamento de Canal", 45000);
        c1 = new Consulta(po1, d1, p1);
        a1 = new Agenda();
        a1.adicionarConsulta(c1);
    }

    @Test
    public void verificarQuantidadeConsulta() {
        Assertions.assertEquals(1, a1.quantidadeDeConsultas());
    }

    @Test
    public void verificarCalcularFaturamento() {
        Assertions.assertEquals(45000.00, a1.calcularFaturamento());
    }

    @Test
    public void verificarExistenciaConsulta() {
        Assertions.assertEquals(true, a1.verificarConsulta(c1));
    }

    @Test
    public void verificarEsvaziaAgenda() {
        a1.esvaziarAgenda();
        Assertions.assertEquals(0, a1.quantidadeDeConsultas());
    }

    @Test
    public void verificarFaturamentoClinicaDentista() {
        Assertions.assertEquals(45000, a1.faturamentoClinicaDentista(d1));
    }

    @Test
    public void verificarValorAoPaciente() {
        Assertions.assertEquals(45000, a1.calculoDeGastosDoPaciente(p1));
    }

    @Test
    public void verificarConsultas() {
        a1.removerConsulta(c1);
        Assertions.assertEquals(false, a1.verificarConsulta(c1));
    }

    @Test
    public void verificarOrdenacaoPacienteAZ() {
        Paciente p2 = new Paciente("Amanda dos Santos", "amanda@email.com", false, LocalDate.of(1999, 03, 20));
        Paciente p3 = new Paciente("Tiago de Melo", "tiago@email.com", true, LocalDate.of(2002, 9, 01));
        Consulta c2 = new Consulta(po1, d1, p2);
        Consulta c3 = new Consulta(po1, d1, p3);
        a1.adicionarConsulta(c2);
        a1.adicionarConsulta(c3);
        Assertions.assertEquals("Amanda dos Santos" + "\nValor Dentista: 40500.0" +
                "\nValor Clinica: 94500.0" + "\nJose da Silva" + "\nValor Dentista: 40500.0" +
                "\nValor Clinica: 94500.0" + "\nTiago de Melo" + "\nValor Dentista: 40500.0" +
                "\nValor Clinica: 94500.0\n", a1.getOrdenacaoPaciente());
    }

    @Test
    public void verificarOrdenacaoDentistaZA() {
        DentistaComissionado d2 = new DentistaComissionado("Amanda", "amands@email.com", false, "1111", 0.3);
        DentistaComissionado d3 = new DentistaComissionado("Uriel", "urs@email.com", true, "1111", 0.3);
        Consulta c2 = new Consulta(po1, d2, p1);
        Consulta c3 = new Consulta(po1, d3, p1);
        a1.adicionarConsulta(c2);
        a1.adicionarConsulta(c3);
        Assertions.assertEquals("Dr. Uriel" + "\nValor Dentista: 13500.0" +
                "\nValor Clinica: 31500.0" + "\nDr. Rafael da Silva" + "\nValor Dentista: 13500.0" +
                "\nValor Clinica: 31500.0" + "\nDra. Amanda" + "\nValor Dentista: 13500.0" +
                "\nValor Clinica: 31500.0\n", a1.getOrdenacaoDentista());
    }

}