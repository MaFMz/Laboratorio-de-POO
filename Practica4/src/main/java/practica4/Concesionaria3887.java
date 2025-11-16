package practica4;

import java.util.ArrayList;

public class Concesionaria3887
{
    private ArrayList<VehiculoBaseM> vehiculos;

    public Concesionaria3887()
    {
        vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(VehiculoBaseM vehiculo)
    {
        vehiculos.add(vehiculo);
    }

    public void mostrarVehiculos()
    {
        for (VehiculoBaseM v : vehiculos)
        {
            v.mostrarInfo();
            System.out.println("-------------------");
        }
    }

    public void encenderTodos()
    {
        for (VehiculoBaseM v : vehiculos)
        {
            v.encender();
        }
    }

    public void apagarTodos()
    {
        for (VehiculoBaseM v : vehiculos)
        {
            v.apagar();
        }
    }
}
