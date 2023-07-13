package test.java.model;

import main.java.model.Procedimento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProcedimentoTest {
    @Test
    public void checkDescription() {
        Procedimento po1 = new Procedimento("Limpeza", 1200);
        Assertions.assertEquals("Limpeza - R$ 1200.0", po1.toString());
    }
}
