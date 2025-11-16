package practica7;


public class Matricula9InvalidaException extends ExceptionMarquezBase 
{
    public Matricula9InvalidaException(String matricula) 
    {
        super("La matrícula '" + matricula + "' es inválida.");
    }
}