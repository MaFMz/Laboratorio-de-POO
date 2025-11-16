package practica3;

public class Practica3
{
    public static void main(String[] args)
    {
        CuentaBancaria0905 cuenta1 = new CuentaBancaria0905("1234567890123456783887",
                "0011223344556677883887",
                "Ahorro",
                "María Fernanda Márquez Silva",
                1000.0,
                500.0f
        );
        System.out.println(cuenta1.toString());
    }
}