package practica6;

public class DesarrolladorMarquez extends EmpleadoMM implements Bonificable9, EvaluableMayo, Promovible3887
{
    private double bono;
    private int calificacion;

    public DesarrolladorMarquez(String nombreCompleto, int id, double salarioB)
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
        bono = salarioB * 0.1;
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
        return calificacion >= 8;
    }
}
