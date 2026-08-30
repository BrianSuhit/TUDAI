import java.time.LocalDate;

public class Masajista extends MiembroSeleccion {
    private String titulo;
    private int anosExp;

    public Masajista(String nombre, String apellido, int numPasaporte, LocalDate fechaNacimiento, String titulo,    int anosExp){
        super(nombre, apellido, numPasaporte, fechaNacimiento);
        setTitulo(titulo);
        setAnosExp(anosExp);
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnosExp(int anosExp) {
        this.anosExp = anosExp;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnosExp() {
        return anosExp;
    }  
}
