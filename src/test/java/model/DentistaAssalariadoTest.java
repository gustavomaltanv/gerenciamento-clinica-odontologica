package test.java.model;

import main.java.model.Consulta;
import main.java.model.DentistaAssalariado;
import main.java.model.Paciente;
import main.java.model.Procedimento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DentistaAssalariadoTest {
    DentistaAssalariado d1;

    @BeforeEach
    public void init() {
        d1 = new DentistaAssalariado("Rafael da Silva", "rfsilva@email.com", true, "1234", 6000);
    }

    @Test
    public void verificarSalario() {
        Assertions.assertEquals(6000,d1.getSalario());
    }
    @Test
    public void verificarDescricao() {
        Assertions.assertEquals("Dr. Rafael da Silva" + " - Email: rfsilva@email.com" + "\nCRO: 1234",d1.toString());
    }
}
