package test.java.model;
import main.java.model.*;
import main.java.api.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PacienteTest {
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
    public void verificarTratamento() {
        Assertions.assertEquals("Senhor Silva",p1.getTratamento());
    }
    @Test
    public void verificarDescricao() {
        Assertions.assertEquals("Senhor Silva" + " - Email: jssilva@email.com" + "\nNascimento: 12/06/1993",p1.toString());
    }
    @Test
    public void verificarCategoriaPaciente() {
        CategoriaPaciente cp = new CategoriaPaciente();
        cp.categorizarPaciente(p1);
        Assertions.assertEquals("A", cp.getCategoria(p1));
    }
}
