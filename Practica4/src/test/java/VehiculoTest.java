import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import practica4.AutoMarquez;
import practica4.CamionMarquez;
import practica4.MotocicletaMarquez;

public class VehiculoTest
{
    @Test
    public void testAutoMostrarInfo()
    {
        AutoMarquez auto = new AutoMarquez("Honda", "Civic", 2021, 4);
        assertEquals("Honda", auto.getMarca());
        assertEquals("Civic", auto.getModelo());
        assertEquals(2021, auto.getAño());
    }

    @Test
    public void testMotocicletaTieneCasco()
    {
        MotocicletaMarquez moto = new MotocicletaMarquez("Suzuki", "Gixxer", 2023, true);
        assertTrue(moto.tieneCasco());
    }

    @Test
    public void testCamionCapacidad()
    {
        CamionMarquez camion = new CamionMarquez("MAN", "TGX", 2019, 12.0);
        assertEquals(12.0, camion.getCapacidadCarga());
    }
}
