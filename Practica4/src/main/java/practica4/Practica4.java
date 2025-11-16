package practica4;

public class Practica4
{
    public static void main(String[] args)
    {
        Concesionaria3887 concesionaria = new Concesionaria3887();

        VehiculoBaseM auto = new AutoMarquez("Nissan", "Versa", 2020, 4);
        VehiculoBaseM moto = new MotocicletaMarquez("Yamaha", "FZ", 2022, true);
        VehiculoBaseM camion = new CamionMarquez("Volvo", "FH16", 2018, 18.5);

        concesionaria.agregarVehiculo(auto);
        concesionaria.agregarVehiculo(moto);
        concesionaria.agregarVehiculo(camion);

        System.out.println("Información de vehículos:");
        concesionaria.mostrarVehiculos();

        System.out.println("\nEncendiendo vehículos:");
        concesionaria.encenderTodos();

        System.out.println("\nApagando vehículos:");
        concesionaria.apagarTodos();
    }
}

