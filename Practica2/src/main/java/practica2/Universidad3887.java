package practica2;

public class Universidad3887
{
    private EstudianteMM[] estudiantes;
    private int contador;
    
    //Constructor:
    public Universidad3887(int cantidad)
    {
        estudiantes = new EstudianteMM[cantidad];
        contador = 0;
    }
    
    //Métodos:
    public void agregarEstudiante(EstudianteMM estudiante)
    {
        if(contador < estudiantes.length)
        {
            estudiantes[contador++] = estudiante;
            System.out.println("Estudiante agregado.");
        }
        else
        {
            System.out.println("No se pueden agregar más estudiantes.");
        }
    }
    
    public void mostrarEstudiantes()
    {
        System.out.println("-----Lista de estudiantes-----");
        for (int i = 0; i < contador; i++)
        {
            estudiantes[i].mostrarInfo();
        }
    }
    
    public void buscarEstudiante(int matricula)
    {
        int i, encontrado = 0;
        System.out.println("Buscando estudiante por su matrícula: " + matricula);
        for (i = 0; i < contador; i++)
        {
            if (estudiantes[i].regresarMatricula() == matricula)
            {
                estudiantes[i].mostrarInfo();
                encontrado += 1;
            }
        }
        if(encontrado == 0)
        {
            System.out.println("No se encontró un estudiante registrado con esa matrícula.");
        }
        if (encontrado > 1)
        {
            System.out.println("Total de estudiantes con esa matricula encontrados: " + encontrado);
            System.out.println("Considere cambiar las matriculas para que los registros sean únicos.");
        }
        
    }
}