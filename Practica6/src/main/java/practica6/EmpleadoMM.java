
package practica6;

public abstract class EmpleadoMM
{
    protected String nombreCompleto;
    protected int id;
    protected double salarioB;

    public EmpleadoMM(String nombreCompleto, int id, double salarioB)
    {
        this.nombreCompleto = nombreCompleto;
        this.id = id;
        this.salarioB = salarioB;
    }
    
    public abstract double calcularPago();
    
    public void imprimirInfo()
    {
        System.out.println("ID: " + id + " | Nombre: " + nombreCompleto + " | Salario Base: $" + salarioB);
    }
    
    //Getters
    public String getNombreCompleto()
    {
        return nombreCompleto;
    }

    public int getId()
    {
        return id;
    }

    public double getSalarioB()
    {
        return salarioB;
    }
    
    //Setters
    public void setNombreCompleto(String nombreCompleto)
    {
        this.nombreCompleto = nombreCompleto;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public void setSalarioB(double salarioB)
    {
        this.salarioB = salarioB;
    }
    
}
