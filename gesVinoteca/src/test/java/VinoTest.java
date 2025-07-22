import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VinoTest {
    private Vino vino;

    @BeforeEach
    public void setup (){
        vino = new Vino("Protos","tinto",5.5,14);
    }

    @Test
    public void testConstructorYGetters (){
        assertEquals("Protos",vino.getNombre());
        assertEquals("tinto",vino.getTipo());
        assertEquals(5.5,vino.getPrecio());
        assertEquals(14,vino.getStock());
    }
    @Test
    public void testSetters() {
        vino.setNombre("Crianza");
        vino.setTipo("Blanco");
        vino.setPrecio(12.0);
        vino.setStock(20);

        assertEquals("Crianza", vino.getNombre());
        assertEquals("Blanco", vino.getTipo());
        assertEquals(12.0, vino.getPrecio());
        assertEquals(20, vino.getStock());
    }

    @Test
    public void testDecrementarStockCantidadSuficiente() {
        vino.decrementarStock(5);
        assertEquals(5, vino.getStock());
    }
}