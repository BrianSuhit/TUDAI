import java.util.ArrayList;

public class SombreroSeleccionador {
    private ArrayList<Casa> casas;

    public SombreroSeleccionador() {
        this.casas = new ArrayList<>();
    }

    // Permite fundar o agregar casas a la escuela de magia
    public void addCasa(Casa casa) {
        this.casas.add(casa);
    }

    // Getter protegido con copia de seguridad
    public ArrayList<Casa> getCasas() {
        return new ArrayList<>(this.casas);
    }

    // --- EL MÉTODO ESTRELLA: ASIGNACIÓN ---
    public boolean asignarCasa(Alumno alumno) {
        for (Casa casa : this.casas) {
            // addAlumno() internamente se fija si lo acepta
            // Si lo acepta, lo mete a su lista, le asigna la casa al alumno y devuelve true
            if (casa.addAlumno(alumno)) {
                return true; // Asignación exitosa, salimos del método
            }
        }
        return false; // Pasó por todas las casas y ninguna lo pudo aceptar
    }
}