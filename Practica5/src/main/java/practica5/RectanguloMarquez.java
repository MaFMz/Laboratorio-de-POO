package practica5;


public class RectanguloMarquez extends Figura9
{

    private double base, altura;

    public RectanguloMarquez(double base, double altura)
    {
        super("Rectángulo");
        this.base = base;
        this.altura = altura;
    }

    public void setDimensiones(double base, double altura)
    {
        this.base = base;
        this.altura = altura;
    }

    public void setDimensiones(int base, int altura)
    {
        this.base = base;
        this.altura = altura;
    }

    public void setDimensiones(String base, String altura)
    {
        this.base = Double.parseDouble(base);
        this.altura = Double.parseDouble(altura);
    }

    @Override
    public double calcularArea()
    {
        return base * altura;
    }

    @Override
    public double calcularPerimetro()
    {
        return 2 * (base + altura);
    }

    @Override
    public void mostrarInformacion()
    {
        System.out.println("Figura: " + getNombre() + " | Base: " + base + " | Altura: " + altura);
    }
}
