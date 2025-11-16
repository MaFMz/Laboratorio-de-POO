package practica5;


public class CalculadoraGeometrica3887
{
    public void mostrarCalculos(Figura9 figura)
    {
        figura.mostrarInformacion();
        System.out.println("Área: " + figura.calcularArea());
        System.out.println("Perímetro: " + figura.calcularPerimetro());
        System.out.println("------------------------------");
    }
}