import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {
    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente("fran", "fran@email.com", "600111222", "11122223l");
    }

    @Test
    public void testGetNombre() {
        assertEquals("fran", cliente.getNombre());
    }

    @Test
    public void testGetEmail() {
        assertEquals("fran@email.com", cliente.getEmail());
    }

    @Test
    public void testGetTelefono() {
        assertEquals("600111222", cliente.getTelefono());
    }

    @Test
    public void testGetDni() {
        assertEquals("11122223l", cliente.getDni());
    }

    @Test
    public void testSetEmail() {
        cliente.setEmail("nuevoemail@email.com");
        assertEquals("nuevoemail@email.com", cliente.getEmail());
    }
}
