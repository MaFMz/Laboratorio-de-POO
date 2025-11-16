package practica2;

public class Practica2
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        
        EstudianteMM estudiante1 = new EstudianteMM();
        EstudianteMM estudiante2 = new EstudianteMM("María Fernanda Márquez Silva",
                2043887,20,"LCC",5);
        EstudianteMM estudiante3 = new EstudianteMM(2043877);
        EstudianteMM estudiante4 = new EstudianteMM(7883402);
        EstudianteMM estudiante5 = new EstudianteMM("María Márquez",
                2005059,21,"LCC",5);
        
        estudiante1.regresarMatricula();
        estudiante2.regresarMatricula();
        estudiante2.corregirMatricula(2043877);
        estudiante2.cambiarCarrera("LSTI");
        estudiante2.revalidarMaterias(2);
        estudiante2.mostrarInfo();
        
        Universidad3887 lista_estudiantes = new Universidad3887(10);
        lista_estudiantes.agregarEstudiante(estudiante1);
        lista_estudiantes.agregarEstudiante(estudiante2);
        lista_estudiantes.agregarEstudiante(estudiante3);
        lista_estudiantes.agregarEstudiante(estudiante4);
        lista_estudiantes.agregarEstudiante(estudiante5);
        lista_estudiantes.mostrarEstudiantes();
        lista_estudiantes.buscarEstudiante(2043877);
    }
}