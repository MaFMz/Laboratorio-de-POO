package practica3;

public class ClienteMarquez
{
    protected String primerNombre;
    protected String segundoNombre;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected int numCuentas;
    protected int maxCuentas = 25;
    protected CuentaBancaria0905[] cuentaBancaria;
    
    //Constructores:
    public ClienteMarquez(String primerNombre, String apellidoPaterno, CuentaBancaria0905 cuentaBancaria)
    {
        this.primerNombre = primerNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.numCuentas = 1;
        this.cuentaBancaria = new CuentaBancaria0905[maxCuentas];
        this.cuentaBancaria[numCuentas-1] = cuentaBancaria;
        
    }
    
    public ClienteMarquez(String primerNombre, String apellidoPaterno, String apellidoMaterno, CuentaBancaria0905 cuentaBancaria)
    {
        this.primerNombre = primerNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numCuentas = 1;
        this.cuentaBancaria = new CuentaBancaria0905[maxCuentas];
        this.cuentaBancaria[numCuentas-1] = cuentaBancaria;
        
    }
    
    public ClienteMarquez(String primerNombre, String segundoNombre, String apellidoPaterno, String apellidoMaterno, CuentaBancaria0905 cuentaBancaria)
    {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numCuentas = 1;
        this.cuentaBancaria = new CuentaBancaria0905[maxCuentas];
        this.cuentaBancaria[numCuentas-1] = cuentaBancaria;
    }
    
    //Metodos:
    public void agregarCuentaBancaria(CuentaBancaria0905 cuentaBancaria)
    {
        if(numCuentas < 25)
        {
            this.cuentaBancaria[numCuentas] = cuentaBancaria;
            this.numCuentas += 1;
        }
        else
            System.out.println("No se pudo agregar la nueva cuenta bancaria, ya"
                    + " que el cliente ya tiene el máximo de cuentas permitido.");
    }
    
    public void modificarNombreCompleto(String primerNombre, String segundoNombre, String apellidoPaterno, String apellidoMaterno)
    {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }
    
    public void mostrarInfoCliente()
    {
        int i;
        System.out.println("Cliente: " + primerNombre + " " +segundoNombre+ " " +
                apellidoPaterno + " " + apellidoMaterno);
        System.out.println("Cuentas Asociadas:");
        for (i = 0; i < numCuentas; i++)
            System.out.println(cuentaBancaria[i].toString());
    }
    
    //Getters:
    
    public String getPrimerNombre()
    {
        return primerNombre;
    }

    public String getSegundoNombre()
    {
        return segundoNombre;
    }

    public String getApellidoPaterno()
    {
        return apellidoPaterno;
    }

    public String getApellidoMaterno()
    {
        return apellidoMaterno;
    }

    public int getNumCuentas()
    {
        return numCuentas;
    }

    public CuentaBancaria0905[] getCuentaBancaria()
    {
        return cuentaBancaria;
    }
    
    //Setters:
    public void setPrimerNombre(String primerNombre)
    {
        this.primerNombre = primerNombre;
    }

    public void setSegundoNombre(String segundoNombre)
    {
        this.segundoNombre = segundoNombre;
    }

    public void setApellidoPaterno(String apellidoPaterno)
    {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno)
    {
        this.apellidoMaterno = apellidoMaterno;
    }
}