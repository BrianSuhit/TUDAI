import java.time.LocalDate;

public class Entrenador extends MiembroSeleccion{
    
    private int numIdentificacion;

    public Entrenador(String nombre, String apellido, int numPasaporte, LocalDate fechaNacimiento, int numIdentificacion){
        super(nombre, apellido, numPasaporte, fechaNacimiento);
        setNumIdentificacion(numIdentificacion);
    }

    public int getNumIdentificacion(){
        return numIdentificacion;
    }
    public void setNumIdentificacion(int num){
        this.numIdentificacion = num;
    }
}
