package practica3;

public class CuentaBancaria0905
{
    private String clabeInterbancaria;
    private String numeroDeCuenta;
    private String tipoDeCuenta;
    private String titular;
    private double saldo;
    private float limiteMaxdeRetiro;
    
    //Constructor:
    public CuentaBancaria0905(String clabeInterbancaria, String numeroDeCuenta,
            String tipoDeCuenta, String titular, double saldo, float limiteMaxdeRetiro)
    {
        this.setClabeInterbancaria(clabeInterbancaria);
        this.setNumeroDeCuenta(numeroDeCuenta);
        this.setTipoDeCuenta(tipoDeCuenta);
        this.setTitular(titular);
        this.setSaldo(saldo);
        this.setLimiteMaxdeRetiro(limiteMaxdeRetiro);
    }
    
    //Setters:
    public void setClabeInterbancaria(String clabeInterbancaria)
    {
        if (clabeInterbancaria != null && clabeInterbancaria.endsWith("3887"))
            this.clabeInterbancaria = clabeInterbancaria;
        else
            throw new IllegalArgumentException("La CLABE interbancaria debe terminar en '3887'.");
    }
    
    public void setNumeroDeCuenta(String numeroDeCuenta)
    {
        if (numeroDeCuenta != null && numeroDeCuenta.endsWith("3887"))
            this.numeroDeCuenta = numeroDeCuenta;
        else
            throw new IllegalArgumentException("El número de cuenta debe terminar en '3887'.");
    }
    
    public void setTipoDeCuenta(String tipoDeCuenta)
    {
        if (tipoDeCuenta != null && !tipoDeCuenta.trim().isEmpty())
            this.tipoDeCuenta = tipoDeCuenta;
        else
            throw new IllegalArgumentException("El tipo de cuenta no puede estar vacío.");
    }
    
    public void setTitular(String titular)
    {
        if (titular != null && !titular.trim().isEmpty())
            this.titular = titular;
        else
            throw new IllegalArgumentException("Titular no puede estar vacío.");
    }
    
    public void setSaldo(double saldo)
    {
        if (saldo >= 0)
            this.saldo = saldo;
        else
            throw new IllegalArgumentException("El saldo no puede ser negativo.");
    }
    
    public void setLimiteMaxdeRetiro(float limiteMaxdeRetiro)
    {
        if (limiteMaxdeRetiro >= 0)
            this.limiteMaxdeRetiro = limiteMaxdeRetiro;
        else
            throw new IllegalArgumentException("El límite máximo de retiro permitido no puede ser negativo.");
    }

    //Getters:
    public String getClabeInterbancaria()
    {
        return clabeInterbancaria;
    }

    public String getNumeroCuenta()
    {
        return numeroDeCuenta;
    }

    public String getTipoDeCuenta()
    {
        return tipoDeCuenta;
    }
    
    public String getTitular()
    {
        return titular;
    }

    public double getSaldo()
    {
        return saldo;
    }
    
    public float getLimiteMaxdeRetiro()
    {
        return limiteMaxdeRetiro;
    }
    
    @Override
    public String toString()
    {
        return "Cuenta Bancaria:" +
                "titular='" + titular + '\'' +
                ", numeroCuenta='" + numeroDeCuenta + '\'' +
                ", saldo=" + saldo +'}';
    }
}
