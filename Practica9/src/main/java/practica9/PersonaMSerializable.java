package practica9;


import java.io.Serializable;
 
public class PersonaMSerializable implements Serializable
{
    private static final long serialVersionUID = 1L;
 
    private String apellido;
    private String nombre;
    private int matricula;

    public PersonaMSerializable(String apellido, String nombre, int matricula)
    {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }
    
    public String getApellido() { return apellido; }
    public String getNombre() { return nombre; }
    public int getMatricula() { return matricula; }
 
    @Override
    public String toString()
    {
        return "PersonaMSerializable{" + "apellido='" + apellido + '\'' +
                ", inicialNombre='" + nombre + '\'' + ", matricula=" + matricula + '}';
    }
}