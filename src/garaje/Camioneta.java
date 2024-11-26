
package garaje;

public class Camioneta extends Vehiculo {
    private String tipoServicio; 
    private int numeroPasajeros; 
    private boolean tieneRemolque;

    public Camioneta(String marca, double precio, int cilindraje, String tipoServicio, int numeroPasajeros, boolean tieneRemolque) {
        super(marca, precio, cilindraje);
        
       
        if ((tipoServicio.equals("Pickup") || tipoServicio.equals("Carga")) && numeroPasajeros != 2) {
            throw new IllegalArgumentException("Las camionetas Pickup y Carga solo pueden tener 2 pasajeros.");
        } else if (numeroPasajeros > 5) {
            throw new IllegalArgumentException("El número de pasajeros no puede ser mayor a 5.");
        }
        
        this.tipoServicio = tipoServicio;
        this.numeroPasajeros = numeroPasajeros;
        this.tieneRemolque = tieneRemolque;
        
        
        calcularImpuestoCirculacion();
        

        if (tipoServicio.equals("Pickup") || tipoServicio.equals("Carga") || tipoServicio.equals("Otro")) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.45);
        } else if (tipoServicio.equals("SUV")) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.10);
        }

       
        if (numeroPasajeros == 2) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.50); 
        } else if (numeroPasajeros > 2) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.60); 
        }

       
        if (tieneRemolque) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.10); 
        }
    }

    @Override
    public void calcularImpuestoCirculacion() {
        this.impuestoCirculacion = 0.05 * this.precio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    public boolean isTieneRemolque() {
        return tieneRemolque;
    }

    public void setTieneRemolque(boolean tieneRemolque) {
        this.tieneRemolque = tieneRemolque;
    }
}
