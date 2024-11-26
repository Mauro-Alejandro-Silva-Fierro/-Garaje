
package garaje;

public class Camion extends Vehiculo {
    private int numeroEjes;
    private String tipoCamion;
    private double capacidadCarga; 
    
    public Camion(String marca, double precio, int cilindraje, int numeroEjes, String tipoCamion, double capacidadCarga) {
        super(marca, precio, cilindraje);
        this.numeroEjes = numeroEjes;
        this.tipoCamion = tipoCamion;
        this.capacidadCarga = capacidadCarga;
        
      
        if (tipoCamion.equals("Sencillo") && numeroEjes != 2) {
            throw new IllegalArgumentException("Un camión sencillo debe tener 2 ejes.");
        }
        if (tipoCamion.equals("Doble") && (numeroEjes < 3 || numeroEjes > 6)) {
            throw new IllegalArgumentException("Un camión doble debe tener entre 3 y 6 ejes.");
        }

   
        calcularImpuestoCirculacion();
        
      
        if (tipoCamion.equals("Sencillo")) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.75); 
        } else if (tipoCamion.equals("Doble")) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 2.25); 
        }
    }

   
    @Override
    public void calcularImpuestoCirculacion() {
       
        this.impuestoCirculacion = 0.09 * this.precio + (this.capacidadCarga / 5) * 10;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    public String getTipoCamion() {
        return tipoCamion;
    }

    public void setTipoCamion(String tipoCamion) {
        this.tipoCamion = tipoCamion;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
}




 
 
 
