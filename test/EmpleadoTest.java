import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EmpleadoTest {

    @Test
    public void testCrearEmpleado() {
        Empleado emp = new Empleado(1, "Juan", "Ingeniero", 2000);
        assertEquals("Juan", emp.getNombre());
    }

    @Test
    public void testSalario() {
        Empleado emp = new Empleado(2, "Ana", "Diseñadora", 1500);
        assertEquals(1500, emp.getSalario());
    }
}
