package practica9;

// ============================================================
// File: BackupManagerMarquez.java
// Generación de backups automáticos con timestamp
// Práctica 3.9 I/O
// ============================================================
 
import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class BackupManagerMarquez
{
 
    public Path crearBackup(Path origen, Path destinoDir) throws IOException
    {
        if (!Files.exists(origen))
            throw new FileNotFoundException("Archivo origen no encontrado: " + origen);
 
        if (!Files.exists(destinoDir))
            Files.createDirectories(destinoDir);
 
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String nombreBackup = "backup_" + timestamp + ".dat";
 
        Path destinoFinal = destinoDir.resolve(nombreBackup);
 
        try (InputStream in = new FileInputStream(origen.toFile());
             OutputStream out = new FileOutputStream(destinoFinal.toFile())) {in.transferTo(out);}
 
        System.out.println("Backup creado: " + destinoFinal);
        return destinoFinal;
    }
}