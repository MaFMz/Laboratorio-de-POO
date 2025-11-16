package practica5;

public abstract class Figura9 implements CalculableM
{
    private String nombre;

    public Figura9(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return nombre;
    }

    public abstract void mostrarInformacion();
}
