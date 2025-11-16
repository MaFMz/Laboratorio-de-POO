package practica7;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.*;
 
public class SistemaBancoMM
{
    private static final Logger logger = Logger.getLogger(SistemaBancoMM.class.getName());
    private HashMap<String, Double> cuentas = new HashMap<>();
 
    public SistemaBancoMM()
    {
        configurarLogger();
        cuentas.put("USR3887", 4500.0);
    }
 
    private void configurarLogger()
    {
        try
        {
            FileHandler fh = new FileHandler("log_SistemaBancoMM.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        }
        catch (IOException e)
        {
            System.err.println("No se pudo inicializar el logger.");
        }
    }
 
    public void validarMatricula(String matricula) throws Matricula9InvalidaException
    {
        if (matricula == null || matricula.length() < 5)
        {
            logger.warning("Matrícula inválida detectada: " + matricula);
            throw new Matricula9InvalidaException(matricula);
        }
    }
 
    public double consultarSaldo(String id) throws Usuario3887NoEncontradoException
    {
        if (!cuentas.containsKey(id))
        {
            logger.severe("Usuario no encontrado: " + id);
            throw new Usuario3887NoEncontradoException(id);
        }
        return cuentas.get(id);
    }
 
    public void retirar(String id, double monto)
            throws Usuario3887NoEncontradoException, SaldoMayoInsuficienteException
    {
 
        if (!cuentas.containsKey(id))
        {
            throw new Usuario3887NoEncontradoException(id);
        }
 
        double saldo = cuentas.get(id);
 
        if (monto > saldo)
        {
            logger.warning("Intento de retiro con saldo insuficiente para usuario " + id);
            throw new SaldoMayoInsuficienteException(saldo, monto);
        }
 
        cuentas.put(id, saldo - monto);
    }
 
    // ----- TRY WITH RESOURCES -----
    public void guardarOperacionEnArchivo(String operacion)
    {
        try (FileWriter fw = new FileWriter("operaciones_MM.txt", true))
        {
            fw.write(operacion + "\n");
        }
        catch (IOException e)
        {
            logger.warning("Error al escribir operación: " + e.getMessage());
        }
    }
}
