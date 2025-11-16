import java.time.LocalDate;

public class HolaMundoMM
{
    public static void main(String[] args)
    {
        String nombreCompleto = "María Fernanda Márquez Silva";
        int matricula = 2043887;

        LocalDate fechaActual = LocalDate.now();

        System.out.println("Nombre completo: " + nombreCompleto);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Fecha actual del sistema: " + fechaActual);
    }
}