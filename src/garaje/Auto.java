
package garaje;

public class Auto extends Vehiculo {
    private boolean tieneRadio;
    private boolean tieneNavegador;

    public Auto(String marca, double precio, int cilindraje, boolean tieneRadio, boolean tieneNavegador) {
        super(marca, precio, cilindraje);
        this.tieneRadio = tieneRadio;
        this.tieneNavegador = tieneNavegador;
        calcularImpuestoCirculacion();
        if (cilindraje > 2499) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.2);
        }
    }

    @Override
    public void calcularImpuestoCirculacion() {
        super.calcularImpuestoCirculacion();
        if (tieneRadio) {
            double incremento = getPrecio() * 0.01;
            setImpuestoCirculacion(getImpuestoCirculacion() + incremento);
        }
        if (tieneNavegador) {
            double incremento = getPrecio() * 0.02;
            setImpuestoCirculacion(getImpuestoCirculacion() + incremento);
        }
    }
    
    
    public boolean isTieneRadio() {
        return tieneRadio;
    }

    public boolean isTieneNavegador() {
        return tieneNavegador;
    }
}
