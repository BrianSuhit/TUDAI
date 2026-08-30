import java.util.ArrayList;

public class Trabajo {
    private String titulo;
    private ArrayList<String> palabrasClave;

    public Trabajo(String titulo) {
        this.titulo = titulo;
        this.palabrasClave = new ArrayList<>();
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Encapsulamiento seguro con copia en RAM
    public ArrayList<String> getPalabrasClave() {
        return new ArrayList<>(this.palabrasClave);
    }

    public void addPalabraClave(String palabra) {
        this.palabrasClave.add(palabra);
    }

    // Método polimórfico de aptitud: Por defecto requiere TODAS las palabras clave
    public boolean puedeSerEvaluadoPor(Evaluador e) {
        // Principio "Tell, Don't Ask": Le ordenamos al evaluador que se verifique a sí mismo 
        return e.tieneTodosLosTemas(this.palabrasClave);
    }

    public String toString() {
        return "Trabajo: '" + this.titulo + "'";
    }
}