package test.java.model;

import main.java.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ConsultaTest {

    DentistaAssalariado d1;
    Paciente p1;
    Procedimento po1;
    Consulta c1;

    @BeforeEach
    public void init() {
        d1 = new DentistaAssalariado("Rafael da Silva", "rfsilva@email.com", true, "1234", 6000);
        p1 = new Paciente("Jose da Silva", "jssilva@email.com", true, LocalDate.of(1993, 06, 12));
        po1 = new Procedimento("Limpeza", 1200);
        c1 = new Consulta(po1, d1, p1);
    }
    @Test
    public void verificarDescricao() {
        Assertions.assertEquals("Limpeza - R$ 1200.0" + "\nDentista responsável: Dr. Rafael da Silva" + "\nPaciente: Senhor Silva", c1.toString());
    }
    @Test
    public void verificarCalculoConsulta() {
        Assertions.assertEquals(1200,c1.getValorConsulta());
    }

}
