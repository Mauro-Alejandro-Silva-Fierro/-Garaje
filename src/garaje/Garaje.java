
package garaje;

import java.util.ArrayList;
import java.util.List;

public class Garaje implements iGarage {
    private List<Vehiculo> espacios;
    public static final int NUMERO_MAXIMO_ESPACIOS = 10;
    public static final int NUMERO_MAXIMO_CAMIONETAS = NUMERO_MAXIMO_ESPACIOS / 5; 
    public static final int NUMERO_MAXIMO_MOTOS = NUMERO_MAXIMO_ESPACIOS / 3; 
    
    public Garaje() {
        this.espacios = new ArrayList<>();
    }

    @Override
    public double calcularIngresos() {
        double ingresos = 0;
        for (Vehiculo vehiculo : espacios) {
            ingresos += vehiculo.getCuotaMesGaraje();
        }
        return ingresos;
    }

    @Override
    public int calcularOcupacionPorTipoVehiculo(Vehiculo v) {
        int contador = 0;
        for (Vehiculo vehiculo : espacios) {
            if (vehiculo.getClass().equals(v.getClass())) {
                contador++;
            }
        }
        return contador;
    }

 
    public int buscarVehiculo(String matricula) {
        for (int i = 0; i < espacios.size(); i++) {
            if (espacios.get(i).getPlaca().equals(matricula)) {
                return i; 
            }
        }
        return -99; 
    }

   
    public boolean alquilarEspacio(Vehiculo vehiculo) {
        if (espacios.size() < NUMERO_MAXIMO_ESPACIOS) {
           
            if (vehiculo instanceof Camioneta && calcularOcupacionPorTipoVehiculo(new Camioneta("", 0, 0, "", 0, false)) < NUMERO_MAXIMO_CAMIONETAS) {
                espacios.add(vehiculo);
                return true;
            } 
           
            else if (vehiculo instanceof Moto && calcularOcupacionPorTipoVehiculo(new Moto("", 0, 0, false)) < NUMERO_MAXIMO_MOTOS) {
                espacios.add(vehiculo);
                return true;
            } 
            
            else if (vehiculo instanceof Auto) {
                espacios.add(vehiculo);
                return true;
            }
        }
        return false;
    }


    public double consultarProporcion() {
        int motos = calcularOcupacionPorTipoVehiculo(new Moto("", 0, 0, false));
        int autos = calcularOcupacionPorTipoVehiculo(new Auto("", 0, 0, false, false));
        int camionetas = calcularOcupacionPorTipoVehiculo(new Camioneta("", 0, 0, "", 0, false));
        return (double) motos / (motos + autos + camionetas);
    }


    public void listarVehiculos() {
        for (Vehiculo vehiculo : espacios) {
            System.out.println("Matrícula: " + vehiculo.getPlaca() +
                               ", Cuota Mensual: " + vehiculo.getCuotaMesGaraje() +
                               ", Tipo: " + vehiculo.getClass().getSimpleName());
        }
    }


    public int contarVehiculosPorTipo(Class<?> tipoVehiculo) {
        int contador = 0;
        for (Vehiculo vehiculo : espacios) {
            if (vehiculo.getClass().equals(tipoVehiculo)) {
                contador++;
            }
        }
        return contador;
    }


    public void contarCamionetasPorTipo() {
        int suv = 0, pickup = 0, carga = 0, otro = 0;

        for (Vehiculo vehiculo : espacios) {
            if (vehiculo instanceof Camioneta) {
                Camioneta camioneta = (Camioneta) vehiculo;
                switch (camioneta.getTipoServicio()) {
                    case "SUV":
                        suv++;
                        break;
                    case "Pickup":
                        pickup++;
                        break;
                    case "Carga":
                        carga++;
                        break;
                    default:
                        otro++;
                        break;
                }
            }
        }

        System.out.println("Camionetas SUV: " + suv);
        System.out.println("Camionetas Pickup: " + pickup);
        System.out.println("Camionetas Carga: " + carga);
        System.out.println("Camionetas Otro: " + otro);
    }

 
    public int cantidadPlazasDisponibles() {
        return NUMERO_MAXIMO_ESPACIOS - espacios.size();
    }

    boolean retirarVehiculo(String matriculaRetirar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
