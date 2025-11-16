package practica9;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Practica9
{

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        GestorArchivosMarquez3887 gestor = new GestorArchivosMarquez3887();
        CSVProcessorMarquez csv = new CSVProcessorMarquez();
        BackupManagerMarquez backup = new BackupManagerMarquez();
          
        //Generación de Archivos de Prueba antes de iniciar.
        gestor.serializePersonaDemo();
        gestor.deserializePersonaDemo();
        
        gestor.generateTestFiles();
                
        System.out.println("===== MENU PRINCIPAL I/O =====");
        System.out.println("1) Escribir archivo de texto");
        System.out.println("2) Leer archivo de texto");
        System.out.println("3) Escritura binaria");
        System.out.println("4) Lectura binaria");
        System.out.println("5) Serializar objeto");
        System.out.println("6) Deserializar objeto");
        System.out.println("7) Procesar CSV");
        System.out.println("8) Crear Backup");
        System.out.println("Seleccione una opción: ");
        int op = sc.nextInt();
        sc.nextLine();

        switch (op)
        {
            case 1 -> {
                System.out.print("Ruta a escribir: ");
                String ruta = sc.nextLine();
                System.out.print("Contenido: ");
                String txt = sc.nextLine();
                gestor.writeTextFile(Paths.get(ruta), txt);
            }

            case 2 -> {
                System.out.print("Ruta a leer: ");
                String ruta = sc.nextLine();
                gestor.readTextFile(Paths.get(ruta));
            }

            case 3 -> {
                System.out.print("Archivo binario destino: ");
                String ruta = sc.nextLine();
                System.out.print("Contenido: ");
                String txt = sc.nextLine();
                byte[] bytes = txt.getBytes(StandardCharsets.UTF_8);
                gestor.writeBinaryFile(Paths.get(ruta), bytes);
                System.out.println("Binario escrito.");
            }

            case 4 -> {
                System.out.print("Archivo binario a leer: ");
                String ruta = sc.nextLine();
                byte[] datos = gestor.readBinaryFile(Paths.get(ruta));
                System.out.println("Contenido binario (bytes): ");
                for (byte b : datos) System.out.print(b + " ");
                System.out.println();
            }

            case 5 -> {
                PersonaMSerializable p = new PersonaMSerializable("Marquez", "M", 2043887);
                gestor.serializePersona(p, Paths.get("persona_2043887.ser"));
                System.out.println("Objeto serializado.");
            }

            case 6 -> {
                PersonaMSerializable p = gestor.deserializePersona(Paths.get("persona_2043887.ser"));
                System.out.println("Objeto cargado: " + p);
            }

            case 7 -> {
                System.out.print("Ruta del CSV: ");
                String ruta = sc.nextLine();
                csv.procesarCSV(Paths.get(ruta));
            }

            case 8 -> {
                System.out.print("Archivo origen: ");
                Path origen = Paths.get(sc.nextLine());
                System.out.print("Directorio destino: ");
                Path destino = Paths.get(sc.nextLine());
                backup.crearBackup(origen, destino);
            }

            default -> System.out.println("Opción no válida.");
        }
    }
}
 