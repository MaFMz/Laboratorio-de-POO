package practica4;

public class CamionMarquez extends VehiculoBaseM
{
    private double capacidadCarga;

    public CamionMarquez(String marca, String modelo, int año, double capacidadCarga)
    {
        super(marca, modelo, año);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public void encender()
    {
        System.out.println("El camión se ha encendido con sistema de encendido pesado.");
    }

    @Override
    public void apagar()
    {
        System.out.println("El camión se ha apagado con freno de motor.");
    }

    @Override
    public void mostrarInfo()
    {
        super.mostrarInfo();
        System.out.println("Capacidad de carga: " + capacidadCarga + " toneladas");
    }
    
    public double getCapacidadCarga()
    {
        return capacidadCarga;
    }
}
