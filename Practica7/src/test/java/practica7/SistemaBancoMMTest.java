package practica7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SistemaBancoMMTest
{
    private SistemaBancoMM banco;

    @BeforeEach
    void setup()
    {
        banco = new SistemaBancoMM();
    }
    
    
    @Test
    void testMatriculaInvalida() 
    {
        assertThrows(Matricula9InvalidaException.class, () -> {
            banco.validarMatricula("A1");
        });
    }

    @Test
    void testUsuarioNoEncontrado()
    {
        assertThrows(Usuario3887NoEncontradoException.class, () -> {
            banco.consultarSaldo("XYZ000");
        });
    }

    @Test
    void testSaldoInsuficiente()
    {
        assertThrows(SaldoMayoInsuficienteException.class, () -> {
            banco.retirar("USR3887", 99999);
        });
    }
    

    @Test
    void testEscrituraArchivo()
    {
        banco.guardarOperacionEnArchivo("Prueba: registro de operación");
    }
}