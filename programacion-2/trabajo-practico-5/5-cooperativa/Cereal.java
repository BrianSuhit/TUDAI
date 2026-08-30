import java.util.ArrayList;

public class Cereal {
    private String nombre;
    private ArrayList<String> mineralesRequeridos;

    public Cereal(String nombre) {
        setNombre(nombre);
        this.mineralesRequeridos = new ArrayList<>();
    }

    // --- GETTERS Y SETTERS TRADICIONALES ---

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // --- PROTECCIÓN DEL ENCAPSULAMIENTO (GETTER CON COPIA) ---

    public ArrayList<String> getMineralesRequeridos() {
        return new ArrayList<>(this.mineralesRequeridos);
    }

    // --- MÉTODOS DE ACCIÓN ---

    public void addMineralRequerido(String mineral) {
        this.mineralesRequeridos.add(mineral);
    }

    // --- LÓGICA DE NEGOCIO ---

    // Compara si este cereal puede sembrarse en un lote (Colaboración por parámetro)
    public boolean puedeSembrarseEn(Lote lote) {
        // Aplicamos "Tell, Don't Ask": Le delegamos al lote la responsabilidad de fijarse
        // si su tierra contiene todos nuestros minerales requeridos 
        return lote.tieneTodosLosMinerales(this.mineralesRequeridos);
    }

    @Override
    public String toString() {
        return this.nombre + " (Minerales req: " + this.mineralesRequeridos + ")";
    }
}