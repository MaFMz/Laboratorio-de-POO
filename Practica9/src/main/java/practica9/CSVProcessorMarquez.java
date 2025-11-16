package practica9;

// ============================================================
// File: CSVProcessorMarquez.java
// Procesamiento de archivos CSV para práctica 3.9
// ============================================================
 
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
 
public class CSVProcessorMarquez
{
 
    public void procesarCSV(Path ruta) throws IOException
    {
        if (!Files.exists(ruta))
        {
            System.out.println("CSV no encontrado. Generando archivo de ejemplo...");
            generarCSVejemplo(ruta);
        }
 
        List<String> lineas = Files.readAllLines(ruta, StandardCharsets.UTF_8);
        if (lineas.isEmpty())
        {
            System.out.println("CSV vacío.");
            return;
        }
 
        System.out.println("Encabezado: " + lineas.get(0));
 
        double suma = 0;
        int total = 0;
        double max = Double.MIN_VALUE;
        String mejor = "";
 
        for (int i = 1; i < lineas.size(); i++)
        {
            String linea = lineas.get(i).trim();
            if (linea.isEmpty()) continue;
 
            String[] cols = linea.split(",");
            try
            {
                double cal = Double.parseDouble(cols[3]);
                suma += cal;
                total++;
 
                if (cal > max)
                {
                    max = cal;
                    mejor = cols[1] + " " + cols[2];
                }
            } 
            catch (Exception e)
            {
                System.err.println("Fila inválida: " + linea);
            }
        }
 
        if (total > 0)
            System.out.printf("Promedio: %.2f | Mejor estudiante: %s (%.2f)\n", suma / total, mejor, max);
        else
            System.out.println("Sin registros válidos.");
    }
 
    
    public void generarCSVejemplo(Path ruta) throws IOException
    {
        List<String> lineas = Arrays.asList(
                "id,nombre,apellido,calificacion",
                "1,Maria,Marquez,9.5",
                "2,Miguel,Morales,8.7",
                "3,Luisa,Lopez,10"
        );
 
        Files.write(ruta, lineas, StandardCharsets.UTF_8,StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
 
        System.out.println("CSV de ejemplo creado: " + ruta);
    }
}
