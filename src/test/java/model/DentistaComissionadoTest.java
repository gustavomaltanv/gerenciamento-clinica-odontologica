package test.java.model;

import main.java.exceptions.ErroComissao;
import main.java.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DentistaComissionadoTest {
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
    public void verificarDescricao() {
        Assertions.assertEquals("Dr. Rafael da Silva" + " - Email: rfsilva@email.com" + "\nCRO: 1234",d1.toString());
    }
    @Test
    public void verificarErroComissaoLimiteMax() throws ErroComissao {
        assertThrows(ErroComissao.class, ()->{d1.setPorcentagemComissao(0.51);});
    }
    @Test
    public void verificarErroComissaoLimiteMin() throws ErroComissao {
        assertThrows(ErroComissao.class, ()->{d1.setPorcentagemComissao(-0.1);});
    }
    @Test
    public void verificarPorcentagemComissao() throws ErroComissao{
        Assertions.assertEquals(true, d1.setPorcentagemComissao(0.4));
    }
    @Test
    public void verificarRetornoSalario() {
        Assertions.assertEquals(13500,d1.getSalario());
    }
}
