import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import practica3.ClienteMarquez;
import practica3.CuentaBancaria0905;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ClienteMarquezTest
{
    private CuentaBancaria0905 cuenta;
    private ClienteMarquez cliente;

    @BeforeEach
    public void setUp()
    {
        cuenta = new CuentaBancaria0905(
                "1234567890123456783887",
                "0011223344556677883887",
                "Ahorro",
                "María Fernanda Márquez Silva",
                5000.0,
                1500.0f
        );

        cliente = new ClienteMarquez("María", "Márquez", cuenta);
    }

    @Test
    public void testAgregarCuentaBancaria()
    {
        CuentaBancaria0905 cuenta2 = new CuentaBancaria0905(
                "9999999999999999993887",
                "11112222333344443887",
                "Corriente",
                "María Márquez",
                2000.0,
                1000.0f
        );

        cliente.agregarCuentaBancaria(cuenta2);

        assertEquals(2, cliente.getNumCuentas());
        assertEquals(cuenta2, cliente.getCuentaBancaria()[1]);
    }

    @Test
    public void testModificarNombreCompleto()
    {
        cliente.modificarNombreCompleto("Fernanda", "María", "Silva", "Márquez");

        assertEquals("Fernanda", cliente.getPrimerNombre());
        assertEquals("María", cliente.getSegundoNombre());
        assertEquals("Silva", cliente.getApellidoPaterno());
        assertEquals("Márquez", cliente.getApellidoMaterno());
    }
    
    @Test
    public void testMostrarInfoClienteImprimeCorrectamente()
    {
        ByteArrayOutputStream salidaCapturada = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(salidaCapturada));

        cliente.mostrarInfoCliente();

        System.setOut(originalOut);

        String salida = salidaCapturada.toString();

        assertTrue(salida.contains("Cliente:"));
        assertTrue(salida.contains("María"));
        assertTrue(salida.contains("Cuenta Bancaria:"));
        assertTrue(salida.contains("0011223344556677883887"));
    }
    
    @Test
    public void testMostrarInfoClienteImprimeTodasLasCuentas()
    {
        CuentaBancaria0905 cuenta2 = new CuentaBancaria0905(
            "2222222222222222223887",
            "22223333444455553887",
            "Corriente",
            "María Márquez",
            3000.0,
            800.0f
        );

        CuentaBancaria0905 cuenta3 = new CuentaBancaria0905(
            "3333333333333333333887",
            "33334444555566663887",
            "Inversión",
            "María Márquez",
            10000.0,
            2000.0f
        );

        cliente.agregarCuentaBancaria(cuenta2);
        cliente.agregarCuentaBancaria(cuenta3);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        cliente.mostrarInfoCliente();

        String salida = outContent.toString();
        
        assertAll(
            () -> assertTrue(salida.contains("0011223344556677883887")),
            () -> assertTrue(salida.contains("22223333444455553887")),
            () -> assertTrue(salida.contains("33334444555566663887"))
        );
    }

}
