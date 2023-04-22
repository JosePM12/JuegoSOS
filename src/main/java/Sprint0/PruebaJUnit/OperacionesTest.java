package Sprint0.PruebaJUnit;

import Sprint0.PruebaSwing.Operaciones;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperacionesTest
{
    private Operaciones operacion;
    @BeforeEach
    public void init()
    {
        operacion = new Operaciones();
    }
    @AfterEach
    public void finish(){
        operacion = null;
    }
    @Test
    public void TestSuma() {
        Operaciones operacion = new Operaciones();
        assertEquals(2,operacion.suma(1,1));
    }
    @Test
    public void testResta() {
        Operaciones operacion = new Operaciones();
        assertEquals(3, operacion.resta(4, 1));
    }
    @Test
    public void testMultiplicacion() {
        Operaciones operacion = new Operaciones();
        assertEquals(6, operacion.multiplicacion(2, 3));
    }
    @Test
    public void testDivision() {
        Operaciones operacion = new Operaciones();
        assertEquals(5, operacion.division(10, 2));
    }
    @Test
    public void testDivisionByZero(){
        Operaciones operaciones = new Operaciones();
        assertEquals(-1,operacion.division(4,0));
    }
}
