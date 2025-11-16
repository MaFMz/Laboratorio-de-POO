package practica7;

public class Usuario3887NoEncontradoException extends ExceptionMarquezBase
{
    public Usuario3887NoEncontradoException(String id)
    {
        super("El usuario con ID '" + id + "' no fue encontrado.");
    }
}
