package practica6;

public class Practica6
{
    public static void main(String[] args)
    {
        EmpresaTIM3887 empresa = new EmpresaTIM3887();
 
        GerenteMarquez g = new GerenteMarquez("Laura Márquez", 101, 30000);
        DesarrolladorMarquez d = new DesarrolladorMarquez("Carlos Ruiz", 102, 18000);
        VendedorMarquez v = new VendedorMarquez("Ana Torres", 103, 15);
 
        empresa.agregarEmpleado(g);
        empresa.agregarEmpleado(d);
        empresa.agregarEmpleado(v);
 
        g.evaluarDesempeno(9);
        d.evaluarDesempeno(8);
 
        empresa.mostrarEmpleados();
 
        System.out.println("\n¿" + g.getNombreCompleto() + " es promovible? " + g.esPromovible());
        System.out.println("¿" + v.getNombreCompleto() + " es promovible? " + v.esPromovible());
    }
}