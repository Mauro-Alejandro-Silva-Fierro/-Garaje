

package garaje;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Garaje garaje = new Garaje();
        
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1.- Alquilar un espacio");
            System.out.println("2.- Retirar vehículo");
            System.out.println("3.- Consulta de ingresos mensuales");
            System.out.println("4.- Consulta proporción Autos / Motos / Camionetas");
            System.out.println("5.- Listado de matrículas y cuota mensual y tipo vehículo");
            System.out.println("6.- Buscar vehículo");
            System.out.println("7.- Contar camionetas por tipo");
            System.out.println("8.- Consultar plazas disponibles");
            System.out.println("0.- Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  
            
            switch (opcion) {
                case 1:
                 
                    System.out.print("Ingrese tipo de vehículo (1 - Moto, 2 - Auto, 3 - Camioneta): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); 
                    Vehiculo vehiculo = null;

                    if (tipo == 1) {
                       
                        System.out.print("Ingrese marca de la moto: ");
                        String marcaMoto = scanner.nextLine();
                        System.out.print("Ingrese precio de la moto: ");
                        double precioMoto = scanner.nextDouble();
                        System.out.print("Ingrese cilindraje de la moto: ");
                        int cilindrajeMoto = scanner.nextInt();
                        System.out.print("¿Tiene Sidecar? (true/false): ");
                        boolean tieneSidecar = scanner.nextBoolean();
                        vehiculo = new Moto(marcaMoto, precioMoto, cilindrajeMoto, tieneSidecar);
                    } else if (tipo == 2) {
                    
                        System.out.print("Ingrese marca del auto: ");
                        String marcaAuto = scanner.nextLine();
                        System.out.print("Ingrese precio del auto: ");
                        double precioAuto = scanner.nextDouble();
                        System.out.print("Ingrese cilindraje del auto: ");
                        int cilindrajeAuto = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("¿Tiene radio? (true/false): ");
                        boolean tieneRadio = scanner.nextBoolean();
                        System.out.print("¿Tiene navegador? (true/false): ");
                        boolean tieneNavegador = scanner.nextBoolean();
                        vehiculo = new Auto(marcaAuto, precioAuto, cilindrajeAuto, tieneRadio, tieneNavegador);
                    } else if (tipo == 3) {
                       
                        System.out.print("Ingrese marca de la camioneta: ");
                        String marcaCamioneta = scanner.nextLine();
                        System.out.print("Ingrese precio de la camioneta: ");
                        double precioCamioneta = scanner.nextDouble();
                        System.out.print("Ingrese cilindraje de la camioneta: ");
                        int cilindrajeCamioneta = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Ingrese tipo de servicio (SUV, Pickup, Carga, Otro): ");
                        String tipoServicio = scanner.nextLine();
                        System.out.print("Ingrese número de pasajeros (2 o 5): ");
                        int pasajeros = scanner.nextInt();
                        System.out.print("¿Tiene remolque? (true/false): ");
                        boolean tieneRemolque = scanner.nextBoolean();
                        vehiculo = new Camioneta(marcaCamioneta, precioCamioneta, cilindrajeCamioneta, tipoServicio, pasajeros, tieneRemolque);
                    }

                    if (vehiculo != null) {
                        System.out.print("Ingrese matrícula (6 caracteres): ");
                        String matricula = scanner.next();
                        if (vehiculo.matricular(matricula)) {
                            if (garaje.alquilarEspacio(vehiculo)) {
                                System.out.println("Vehículo alquilado con éxito.");
                            } else {
                                System.out.println("No se pudo alquilar el espacio.");
                            }
                        } else {
                            System.out.println("Matrícula inválida.");
                        }
                    }
                    break;

                case 2:
     
                    System.out.print("Ingrese matrícula del vehículo a retirar: ");
                    String matriculaRetirar = scanner.nextLine();
                    if (garaje.retirarVehiculo(matriculaRetirar)) {
                        System.out.println("Vehículo retirado con éxito.");
                    } else {
                        System.out.println("Vehículo no encontrado.");
                    }
                    break;

                case 3:
           
                    System.out.println("Ingresos mensuales: " + garaje.calcularIngresos());
                    break;

                case 4:
            
                    System.out.println("Proporción de motos: " + garaje.consultarProporcion());
                    break;

                case 5:
       
                    garaje.listarVehiculos();
                    break;

                case 6:
               
                    System.out.print("Ingrese matrícula a buscar: ");
                    String matriculaBuscar = scanner.nextLine();
                    int posicion = garaje.buscarVehiculo(matriculaBuscar);
                    if (posicion != -99) {
                        System.out.println("Vehículo encontrado en la posición: " + posicion);
                    } else {
                        System.out.println("Vehículo no encontrado.");
                    }
                    break;

                case 7:
            
                    garaje.contarCamionetasPorTipo();
                    break;

                case 8:
               
                    System.out.println("Plazas disponibles: " + garaje.cantidadPlazasDisponibles());
                    break;

                case 0:
           
                    System.out.println("Saliendo...");
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
