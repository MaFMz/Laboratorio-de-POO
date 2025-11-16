package practica7;


public class ExceptionMarquezBase extends Exception
{
    public ExceptionMarquezBase(String message) 
    {
        super(message);
    }
 
    public ExceptionMarquezBase(String message, Throwable cause) 
    {
        super(message, cause);
    }
}