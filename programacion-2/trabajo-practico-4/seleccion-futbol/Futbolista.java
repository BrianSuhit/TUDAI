import java.time.LocalDate;

public class Futbolista extends MiembroSeleccion {
    
    private String posicion;
    private int cantGoles;
    private String piernaHabil;

        public Futbolista(String nombre, String apellido, int numPasaporte, LocalDate fechaNacimiento, String poSicion, int cantGoles, String piernaHabil){
        super(nombre, apellido, numPasaporte, fechaNacimiento);
        setPosicion(poSicion);
        setCantGoles(cantGoles);
        setPiernaHabil(piernaHabil);   
    }

    public String getPiernaHabil() {
        return piernaHabil;
    }

    public void setPiernaHabil(String piernaHabil) {
        this.piernaHabil = piernaHabil;
    }

    public String getPosicion() {
        return posicion;
    }
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    public int getCantGoles() {
        return cantGoles;
    }
    public void setCantGoles(int cantGoles) {
        this.cantGoles = cantGoles;
    }
}
