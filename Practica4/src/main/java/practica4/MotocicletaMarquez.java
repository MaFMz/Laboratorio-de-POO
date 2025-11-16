package practica4;

public class MotocicletaMarquez extends VehiculoBaseM
{
    private boolean tieneCasco;

    public MotocicletaMarquez(String marca, String modelo, int año, boolean tieneCasco)
    {
        super(marca, modelo, año);
        this.tieneCasco = tieneCasco;
    }

    @Override
    public void encender()
    {
        System.out.println("La motocicleta se ha encendido con botón.");
    }

    @Override
    public void apagar()
    {
        System.out.println("La motocicleta se ha apagado.");
    }

    @Override
    public void mostrarInfo()
    {
        super.mostrarInfo();
        System.out.println("¿Tiene casco?: " + (tieneCasco ? "Sí" : "No"));
    }
    
    public boolean tieneCasco()
    {
        return tieneCasco;
    }
}
