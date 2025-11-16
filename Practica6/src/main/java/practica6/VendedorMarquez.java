package practica6;

public class VendedorMarquez extends EmpleadoMM implements Bonificable9, EvaluableMayo, Promovible3887
{
    private double bono;
    private float calificacion;

    public VendedorMarquez(String nombreCompleto, int id, double salarioB)
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
        bono = salarioB * 0.05;
        return bono;
    }
 
    @Override
    public void evaluarDesempeno(int ventasHechas)
    {
        this.calificacion = ventasHechas % 2;
        System.out.println("ID: " + id + "| " + nombreCompleto + " evaluado con: " + calificacion + "/10");
    }
 
    @Override
    public boolean esPromovible()
    {
        return calificacion >= 9;
    }
}
