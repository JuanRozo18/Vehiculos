import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehiculo vehiculo = null;
        boolean salir = false;

        while (!salir) {
            System.out.println("\n---- Menú Vehículos ----");
            System.out.println("1. Crear Carro");
            System.out.println("2. Crear Camión");
            System.out.println("3. Crear Moto");
            System.out.println("4. Crear Carro Eléctrico");
            System.out.println("5. Mostrar Información");
            System.out.println("6. Encender Vehículo");
            System.out.println("7. Apagar Vehículo");
            System.out.println("8. Abastecer Combustible/Cargar Batería");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la marca del carro: ");
                    String marcaCarro = scanner.nextLine();
                    System.out.print("Ingrese el modelo del carro: ");
                    String modeloCarro = scanner.nextLine();
                    vehiculo = new Carro(marcaCarro, modeloCarro, "Gasolina");
                    System.out.println("Carro creado.");
                    break;

                case 2:
                    System.out.print("Ingrese la marca del camión: ");
                    String marcaCamion = scanner.nextLine();
                    System.out.print("Ingrese el modelo del camión: ");
                    String modeloCamion = scanner.nextLine();
                    vehiculo = new Camion(marcaCamion, modeloCamion, "Diésel");
                    System.out.println("Camión creado.");
                    break;

                case 3:
                    System.out.print("Ingrese la marca de la moto: ");
                    String marcaMoto = scanner.nextLine();
                    System.out.print("Ingrese el modelo de la moto: ");
                    String modeloMoto = scanner.nextLine();
                    vehiculo = new Moto(marcaMoto, modeloMoto, "Gasolina");
                    System.out.println("Moto creada.");
                    break;

                case 4:
                    System.out.print("Ingrese la marca del carro eléctrico: ");
                    String marcaCarroElectrico = scanner.nextLine();
                    System.out.print("Ingrese el modelo del carro eléctrico: ");
                    String modeloCarroElectrico = scanner.nextLine();
                    vehiculo = new CarroElectrico(marcaCarroElectrico, modeloCarroElectrico);
                    System.out.println("Carro eléctrico creado.");
                    break;

                case 5:
                    if (vehiculo != null) {
                        vehiculo.mostrarInformacion();
                    } else {
                        System.out.println("No se ha creado ningún vehículo.");
                    }
                    break;

                case 6:
                    if (vehiculo != null) {
                        vehiculo.encender();
                    } else {
                        System.out.println("No se ha creado ningún vehículo.");
                    }
                    break;

                case 7:
                    if (vehiculo != null) {
                        vehiculo.apagar();
                    } else {
                        System.out.println("No se ha creado ningún vehículo.");
                    }
                    break;

                case 8:
                    if (vehiculo != null) {
                        if (vehiculo instanceof CarroElectrico) {
                            ((CarroElectrico) vehiculo).cargarBateria();
                        } else {
                            vehiculo.abastecerCombustible();
                        }
                    } else {
                        System.out.println("No se ha creado ningún vehículo.");
                    }
                    break;

                case 9:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
        scanner.close();
    }
}


abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected String combustible;

    public Vehiculo(String marca, String modelo, String combustible) {
        this.marca = marca;
        this.modelo = modelo;
        this.combustible = combustible;
    }

    public abstract void encender();
    public abstract void apagar();
    public abstract void mostrarInformacion();


    public void abastecerCombustible() {
        System.out.println("Abasteciendo combustible...");
    }
}

interface VehiculoElectrico {
    void cargarBateria();
    int nivelBateria();
}

class Carro extends Vehiculo {

    public Carro(String marca, String modelo, String combustible) {
        super(marca, modelo, combustible);
    }

    @Override
    public void encender() {
        System.out.println("El carro está encendido.");
    }

    @Override
    public void apagar() {
        System.out.println("El carro está apagado.");
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Carro - Marca: " + marca + ", Modelo: " + modelo + ", Combustible: " + combustible);
    }
}

class Camion extends Vehiculo {

    public Camion(String marca, String modelo, String combustible) {
        super(marca, modelo, combustible);
    }

    @Override
    public void encender() {
        System.out.println("El camión está encendido.");
    }

    @Override
    public void apagar() {
        System.out.println("El camión está apagado.");
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Camión - Marca: " + marca + ", Modelo: " + modelo + ", Combustible: " + combustible);
    }
}

class Moto extends Vehiculo {

    public Moto(String marca, String modelo, String combustible) {
        super(marca, modelo, combustible);
    }

    @Override
    public void encender() {
        System.out.println("La moto está encendida.");
    }

    @Override
    public void apagar() {
        System.out.println("La moto está apagada.");
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Moto - Marca: " + marca + ", Modelo: " + modelo + ", Combustible: " + combustible);
    }
}

class CarroElectrico extends Carro implements VehiculoElectrico {
    private int bateria;

    public CarroElectrico(String marca, String modelo) {
        super(marca, modelo, "Eléctrico");
        this.bateria = 100;
    }

    @Override
    public void cargarBateria() {
        System.out.println("Cargando la batería del carro eléctrico...");
        bateria = 100;
        System.out.println("Batería cargada al 100%");
    }

    @Override
    public int nivelBateria() {
        return bateria;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Carro Eléctrico - Marca: " + marca + ", Modelo: " + modelo + ", Nivel de batería: " + nivelBateria() + "%");
    }
}

