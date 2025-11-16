package practica5;

public class TrianguloMarquez extends Figura9
{
    private double lado1, lado2, lado3;

    public TrianguloMarquez(double lado1, double lado2, double lado3)
    {
        super("Triángulo");
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    // --- Sobrecargas ---
    public void setLados(double l1, double l2, double l3)
    {
        this.lado1 = l1;
        this.lado2 = l2;
        this.lado3 = l3;
    }

    public void setLados(int l1, int l2, int l3)
    {
        this.lado1 = l1;
        this.lado2 = l2;
        this.lado3 = l3;
    }

    public void setLados(String l1, String l2, String l3)
    {
        this.lado1 = Double.parseDouble(l1);
        this.lado2 = Double.parseDouble(l2);
        this.lado3 = Double.parseDouble(l3);
    }

    @Override
    public double calcularArea()
    {
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    @Override
    public double calcularPerimetro()
    {
        return lado1 + lado2 + lado3;
    }

    @Override
    public void mostrarInformacion()
    {
        System.out.println("Figura: " + getNombre() + " | Lados: " + lado1 + ", " + lado2 + ", " + lado3);
    }
}

