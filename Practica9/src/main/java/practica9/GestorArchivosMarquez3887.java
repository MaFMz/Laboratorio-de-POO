package practica9;


import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
 
public class GestorArchivosMarquez3887
{
    private static final Path ROOT = Paths.get(".");
    public void readTextFile(Path path)
    {
        try
        {
            System.out.println("Leyendo: " + path);
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (String l : lines) System.out.println(l);
        }
        catch (IOException e)
        {
            System.err.println("Error leyendo archivo: " + e.getMessage());
        }
    }
 
    public void writeTextFile(Path path, String content)
    {
        try
        {
            Files.write(path, Collections.singleton(content), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Escrito en: " + path);
        }
        catch (IOException e)
        {
            System.err.println("Error escribiendo archivo: " + e.getMessage());
        }
    }
 
    public void writeBinaryFile(Path path, byte[] data) throws IOException
    {
        Files.write(path, data, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
 
    public byte[] readBinaryFile(Path path) throws IOException
    {
        return Files.readAllBytes(path);
    }
 
    public static void createDirectory(Path dir) throws IOException
    {
        if (!Files.exists(dir)) Files.createDirectories(dir);
    }
 
    public static void listDirectory(Path dir) throws IOException
    {
        Path d = dir == null ? ROOT : dir;
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(d))
        {
            for (Path p : ds) System.out.println((Files.isDirectory(p)?"[D] ":"[F] ") + p.getFileName());
        }
    }
 
    
    public void serializePersona(PersonaMSerializable p, Path out) throws IOException
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(out.toFile())))
        {
            oos.writeObject(p);
        }
    }
 
    public PersonaMSerializable deserializePersona(Path in) throws IOException, ClassNotFoundException
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(in.toFile())))
        {
            return (PersonaMSerializable) ois.readObject();
        }
    }
 
    public void serializePersonaDemo() throws IOException
    {
        PersonaMSerializable p = new PersonaMSerializable("Marquez", "Maria", 2043887);
        Path out = Paths.get("persona_2043887.ser");
        serializePersona(p, out);
        System.out.println("Objeto serializado en: " + out);
    }
 
    public void deserializePersonaDemo() throws IOException, ClassNotFoundException
    {
        Path in = Paths.get("persona_2043887.ser");
        PersonaMSerializable p = deserializePersona(in);
        System.out.println("Deserializado: " + p);
    }
 
    public void processCsvStudentData(Path csvPath) throws IOException
    {
        if (!Files.exists(csvPath))
        {
            System.out.println("No existe archivo CSV, creando ejemplo...");
            createExampleCsv(csvPath);
        }
 
        List<String> lines = Files.readAllLines(csvPath, StandardCharsets.UTF_8);
        if (lines.isEmpty()) { System.out.println("CSV vacío."); return; }
 
        System.out.println("Encabezado: " + lines.get(0));
 
        double sum = 0; int count = 0; double max = Double.MIN_VALUE; String best = "";
 
        for (int i=1; i<lines.size(); i++)
        {
            String ln = lines.get(i).trim(); if (ln.isEmpty()) continue;
            String[] cols = ln.split(",");
            try
            {
                double cal = Double.parseDouble(cols[3]);
                sum += cal; count++;
                if (cal > max) { max = cal; best = cols[1] + " " + cols[2]; }
            }
            catch (Exception e)
            {
                System.err.println("Fila inválida: " + ln);
            }
        }
 
        if (count > 0)
            System.out.printf("Promedio: %.2f, Mejor: %s (%.2f)\n", sum/count, best, max);
        else
            System.out.println("Sin registros válidos.");
    }
 
    private  void createExampleCsv(Path csvPath) throws IOException
    {
        List<String> lines = new ArrayList<>();
        lines.add("id,nombre,apellido,calificacion");
        lines.add("1,Mariana,Marquez,9.5");
        lines.add("2,Miguel,M,8.7");
        lines.add("3,Luisa,Lopez,10");
        Files.write(csvPath, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
 
    
    public  void backupWithTimestamp(Path baseBackupFile) throws IOException
    {
        String ts = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String name = baseBackupFile.getFileName().toString();
        String backupName = name.replace(".dat", "") + "_" + ts + ".dat";
 
        Path out = baseBackupFile.getParent() == null ? Paths.get(backupName)
                : baseBackupFile.getParent().resolve(backupName);
 
        List<PersonaMSerializable> list = Arrays.asList(
            new PersonaMSerializable("Marquez","M",3887),
            new PersonaMSerializable("Estudiante","A",204)
        );
 
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(out.toFile()))) {
            oos.writeObject(list);
        }
 
        System.out.println("Backup creado: " + out);
   } 
 
    
    public void generateTestFiles() throws IOException
    {
        Path datos = Paths.get("datos_2043887.txt");
        List<String> contenido = Arrays.asList(
            "Nombre: M. Marquez",
            "Matrícula: 2043887",
            "Nacimiento: 9 Mayo"
        );
        Files.write(datos, contenido, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
 
        Path backup = Paths.get("backup_9Mayo.dat");
        writeBinaryFile(backup, new byte[]{0x00, 0x01, 0x02, 0x03});
 
        Path csv = Paths.get("log_Marquez.csv");
        List<String> csvLines = Arrays.asList("id,nombre,apellido,calificacion","1,Maria,Marquez,9.2","2,Alicia,Lopez,8.8");
        Files.write(csv, csvLines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}
