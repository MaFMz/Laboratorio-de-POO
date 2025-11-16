package practica4;

public class AutoMarquez extends VehiculoBaseM
{
    private int numeroPuertas;

    public AutoMarquez(String marca, String modelo, int año, int numeroPuertas)
    {
        super(marca, modelo, año);
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public void encender()
    {
        System.out.println("El auto se ha encendido con llave.");
    }

    @Override
    public void apagar()
    {
        System.out.println("El auto se ha apagado.");
    }

    @Override
    public void mostrarInfo()
    {
        super.mostrarInfo();
        System.out.println("Número de puertas: " + numeroPuertas);
    }
    
}
