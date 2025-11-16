package practica5;


public class Practica5
{
    public static void main(String[] args)
    {
        Figura9[] figuras = new Figura9[3];
        figuras[0] = new CirculoMarquez(5);
        figuras[1] = new RectanguloMarquez(4, 6);
        figuras[2] = new TrianguloMarquez(3, 4, 5);

        CalculadoraGeometrica3887 calculadora = new CalculadoraGeometrica3887();

        for (Figura9 figura : figuras) {
            calculadora.mostrarCalculos(figura);
            if (figura instanceof CirculoMarquez)
            {
                CirculoMarquez c = (CirculoMarquez) figura;
                System.out.println("Detectado: Círculo con radio = " + c.getRadio());
            }
            else if (figura instanceof RectanguloMarquez)
                System.out.println("Detectado: Rectángulo");
            else if (figura instanceof TrianguloMarquez)
                System.out.println("Detectado: Triángulo");
            
            System.out.println();
        }
    }
}
