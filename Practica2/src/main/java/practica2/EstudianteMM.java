package practica2;

public class EstudianteMM
{
    private String nombre;
    private int matricula;
    private int edad;
    private String carrera;
    private int semestreActual;
    
    //Constructores: 
    public EstudianteMM()
    {
    }

    public EstudianteMM(int matricula)
    {
        this.matricula = matricula;
    }
    
    public EstudianteMM(String nombre, int matricula, int edad,
            String carrera, int semestreActual)
    {
        this.nombre = nombre;
        this.matricula = matricula;
        this.edad = edad;
        this.carrera = carrera;
        this.semestreActual = semestreActual;
    }
    
    //Métodos de instancia:
    public int regresarMatricula()
    {
        return matricula;
    }
    
    public void cambiarCarrera(String nueva_carrera)
    {
        this.carrera = nueva_carrera;
        
        System.out.println("La nueva carrera del alumno " + nombre + " es: " + carrera);
    }
    
    public void corregirMatricula(int nueva_matricula)
    {
        this.matricula = nueva_matricula;
        System.out.println("La nueva matricula del alumno " + nombre + " es: " + matricula);
    }
    
    public void mostrarInfo()
    {
        System.out.println("Nombre: " + nombre +
                "\tMatricula: " + matricula +
                "\tEdad: " + edad +
                "\tCarrera: " + carrera +
                "\tSemestre: " + semestreActual);
    }
    
    public void revalidarMaterias(int num_semestre)
    {
        this.semestreActual = num_semestre;
        System.out.println("El alumno " + nombre + " revalidó materias y ahora se encuentra en el semestre: " + semestreActual);
    }
    
}
