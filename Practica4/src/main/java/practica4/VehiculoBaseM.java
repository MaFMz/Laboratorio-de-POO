package practica4;

public class VehiculoBaseM
{
    protected String marca;
    protected String modelo;
    protected int año;

    public VehiculoBaseM(String marca, String modelo, int año)
    {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }

    public void encender()
    {
        System.out.println("El vehículo se ha encendido.");
    }

    public void apagar()
    {
        System.out.println("El vehículo se ha apagado.");
    }

    public void mostrarInfo()
    {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Año: " + año);
    }
    
    public String getMarca()
    {
        return marca;
    }

    public String getModelo()
    {
        return modelo;
    }

    public int getAño()
    {
        return año;
    }
}
