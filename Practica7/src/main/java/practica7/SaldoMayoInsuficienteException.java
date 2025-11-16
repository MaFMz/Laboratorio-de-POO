package practica7;

public class SaldoMayoInsuficienteException extends ExceptionMarquezBase
{
    public SaldoMayoInsuficienteException(double saldoActual, double monto)
    {
        super("Saldo insuficiente. Saldo actual: " + saldoActual + ", intento de retiro: " + monto);
    }
}