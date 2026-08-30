import java.util.ArrayList;

public class Evaluador {
    private String nombre;
    private ArrayList<String> temas;
    private ArrayList<Trabajo> trabajosAsignados; // Para resolver la consulta 3

    public Evaluador(String nombre) {
        this.nombre = nombre;
        this.temas = new ArrayList<>();
        this.trabajosAsignados = new ArrayList<>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getTemas() {
        return new ArrayList<>(this.temas); // Copia segura
    }

    public void addTema(String tema) {
        this.temas.add(tema);
    }

    public ArrayList<Trabajo> getTrabajosAsignados() {
        return new ArrayList<>(this.trabajosAsignados);
    }

    // Permite al sistema asignarle un trabajo a este evaluador
    public void asignarTrabajo(Trabajo t) {
        this.trabajosAsignados.add(t);
    }

    public int getCantTrabajos() {
        return this.trabajosAsignados.size();
    }

    // --- MÉTODOS AUXILIARES DE COMPARACIÓN (Tell, Don't Ask) ---

    // Comprueba si conoce todos los temas requeridos
    public boolean tieneTodosLosTemas(ArrayList<String> requeridos) {
        return this.temas.containsAll(requeridos);
    }

    // Comprueba si conoce al menos uno de los temas indicados
    public boolean tieneAlgunTema(ArrayList<String> deInteres) {
        for (String t : deInteres) {
            if (this.temas.contains(t)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.nombre + " (Temas conocidos: " + this.temas + ")";
    }
}