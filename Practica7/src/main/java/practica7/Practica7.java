package practica7;

public class Practica7
{
    public static void main(String[] args)
    {   
        SistemaBancoMM banco = new SistemaBancoMM();
 
        System.out.println("==== DEMOSTRACIÓN DEL SISTEMA BANCO MM ====\n");
 
        try
        {
            System.out.println("Probando matrícula inválida...");
            banco.validarMatricula("A1");
        } catch (Matricula9InvalidaException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
 
        System.out.println("\n-----------------------------------------\n");
 
        
        try
        {
            System.out.println("Probando consulta de usuario no existente...");
            banco.consultarSaldo("ID_INEXISTENTE");
        }
        catch (Usuario3887NoEncontradoException e)
        {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
 
        System.out.println("\n-----------------------------------------\n");
 
        
        try
        {
            System.out.println("Probando retiro con saldo insuficiente...");
            banco.retirar("USR3887", 100000);  // monto mayor al saldo
        }
        catch (Usuario3887NoEncontradoException | SaldoMayoInsuficienteException e)
        {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
 
        System.out.println("\n-----------------------------------------\n");
 
        try
        {
            System.out.println("Probando retiro exitoso...");
            banco.retirar("USR3887", 1000);
            System.out.println("Nuevo saldo: " + banco.consultarSaldo("USR3887"));
        }
        catch (Exception e)
        {
            System.out.println("Error inesperado: " + e.getMessage());
        }
 
        System.out.println("\n-----------------------------------------\n");
 
        System.out.println("Probando escritura de operación en archivo...");
        banco.guardarOperacionEnArchivo("Operación de prueba ejecutada desde main()");
        System.out.println("Archivo actualizado correctamente.");
 
        System.out.println("\n==== FIN DE DEMOSTRACIÓN ====");
        
    }
}