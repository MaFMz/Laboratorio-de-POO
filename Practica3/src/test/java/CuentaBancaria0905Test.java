import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import practica3.CuentaBancaria0905;

public class CuentaBancaria0905Test
{
    @Test
    public void testEncapsulamientoSetGetCorrecto()
    {
        CuentaBancaria0905 cuenta = new CuentaBancaria0905(
                "1234567890123456783887",
                "0011223344556677883887",
                "Ahorro",
                "Fernanda Márquez",
                1000.0,
                500.0f
        );

        assertEquals("1234567890123456783887", cuenta.getClabeInterbancaria());
        assertEquals("0011223344556677883887", cuenta.getNumeroCuenta());
        assertEquals("Ahorro", cuenta.getTipoDeCuenta());
        assertEquals("Fernanda Márquez", cuenta.getTitular());
        assertEquals(1000.0, cuenta.getSaldo());
        assertEquals(500.0f, cuenta.getLimiteMaxdeRetiro());
    }

    @Test
    public void testSetClabeInvalidaLanzaExcepcion()
    {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
        {
            new CuentaBancaria0905("0000000000000000001234", "0011223344556677883887", "Ahorro", "María", 1000.0, 300.0f);
        });
        assertTrue(ex.getMessage().contains("CLABE"));
    }

    @Test
    public void testSetSaldoNegativoLanzaExcepcion()
    {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
        {
            new CuentaBancaria0905("1234567890123456783887", "0011223344556677883887", "Ahorro", "María", -50.0, 300.0f);
        });
        assertTrue(ex.getMessage().contains("saldo"));
    }

    @Test
    public void testToStringContieneTitularYNumeroCuenta()
    {
        CuentaBancaria0905 cuenta = new CuentaBancaria0905(
                "1234567890123456783887",
                "0011223344556677883887",
                "Ahorro",
                "María Fernanda Márquez",
                1200.0,
                400.0f
        );

        String salida = cuenta.toString();
        assertTrue(salida.contains("María Fernanda Márquez"));
        assertTrue(salida.contains("0011223344556677883887"));
    }
}
