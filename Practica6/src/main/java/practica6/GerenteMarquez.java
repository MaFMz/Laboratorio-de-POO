package practica6;

public class GerenteMarquez extends EmpleadoMM implements Bonificable9, EvaluableMayo, Promovible3887
{
    private double bono;
    private int calificacion;
 
    public GerenteMarquez(String nombreCompleto, int id, double salarioB)
    {
        super(nombreCompleto, id, salarioB);
    }
 
    @Override
    public double calcularPago()
    {
        return salarioB + calcularBono();
    }
 
    @Override
    public double calcularBono()
    {
        bono = salarioB * 0.25;
        return bono;
    }
 
    @Override
    public void evaluarDesempeno(int calificacion)
    {
        this.calificacion = calificacion;
        System.out.println("ID: " + id + "| " + nombreCompleto + " evaluado con: " + calificacion + "/10");
    }
 
    @Override
    public boolean esPromovible()
    {
        return calificacion >= 9;
    }
}
