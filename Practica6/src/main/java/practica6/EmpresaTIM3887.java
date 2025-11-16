package practica6;

import java.util.ArrayList;
 
public class EmpresaTIM3887
{
    private ArrayList<EmpleadoMM> empleados;
 
    public EmpresaTIM3887()
    {
        empleados = new ArrayList<>();
    }
 
    public void agregarEmpleado(EmpleadoMM e)
    {
        empleados.add(e);
    }
 
    public void mostrarEmpleados()
    {
        System.out.println("\n--- Lista de Empleados ---");
        for (EmpleadoMM e : empleados)
        {
            e.imprimirInfo();
            System.out.println("Pago total: $" + e.calcularPago());
            System.out.println("-------------------------");
        }
    }
}
