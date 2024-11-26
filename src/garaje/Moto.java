
package garaje;

public class Moto extends Vehiculo {
    private boolean tieneSidecar;

    public Moto(String marca, double precio, int cilindraje, boolean tieneSidecar) {
        super(marca, precio, cilindraje);
        this.tieneSidecar = tieneSidecar;
        calcularImpuestoCirculacion();
        if (tieneSidecar) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.5);
        }
    }

    Moto(String string, int i, int i0, boolean b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public void calcularImpuestoCirculacion() {
        super.calcularImpuestoCirculacion();
        if (tieneSidecar) {
            double incremento = getPrecio() * 0.1;
            setImpuestoCirculacion(getImpuestoCirculacion() + incremento);
        }
    }
    public boolean isTieneSidecar() {
        return tieneSidecar;
    }
}
