package practica5;


public class CirculoMarquez extends Figura9
{
    private double radio;

    public CirculoMarquez(double radio)
    {
        super("Círculo");
        this.radio = radio;
    }

    public double getRadio()
    {
        return radio;
    }

    public void setRadio(double radio)
    {
        this.radio = radio;
    }

    public void setRadio(int radio)
    {
        this.radio = (double) radio;
    }

    public void setRadio(String radio)
    {
        this.radio = Double.parseDouble(radio);
    }

    @Override
    public double calcularArea()
    {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro()
    {
        return 2 * Math.PI * radio;
    }

    @Override
    public void mostrarInformacion()
    {
        System.out.println("Figura: " + getNombre() + " | Radio: " + radio);
    }
}
