import java.util.ArrayList;

public class Alumno {
    private String nombre;
    private ArrayList<String> cualidades;
    private ArrayList<Alumno> familiares;
    private Casa casa; 

    // Constructor obligatorio: el alumno nace sin casa asignada y con listas vacías
    public Alumno(String nombre) {
        setNombre(nombre);
        this.cualidades = new ArrayList<>();
        this.familiares = new ArrayList<>();
        this.casa = null; 
    }

    // --- GETTERS Y SETTERS TRADICIONALES ---
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Casa getCasa() {
        return this.casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    // --- PROTECCIÓN DEL ENCAPSULAMIENTO (GETTERS DE LISTAS) ---
    // Retornamos copias de seguridad de la lista en RAM para proteger el estado interno
    public ArrayList<String> getCualidades() {
        return new ArrayList<>(this.cualidades);
    }

    public ArrayList<Alumno> getFamiliares() {
        return new ArrayList<>(this.familiares);
    }

    // --- MÉTODOS DE ACCIÓN (AGREGAR ELEMENTOS DE A UNO) ---
    public void addCualidad(String cualidad) {
        this.cualidades.add(cualidad);
    }

    public void addFamiliar(Alumno familiar) {
        this.familiares.add(familiar);
    }

    // --- MÉTODOS DE COMPORTAMIENTO (LÓGICA DEL NEGOCIO) ---
    public boolean tieneCasaAsignada() {
        return this.casa != null;
    }

    // Principio "Tell, Don't Ask": El Alumno mismo sabe si posee todas las cualidades pedidas
    public boolean tieneTodasLasCualidades(ArrayList<String> requeridas) {
        return this.cualidades.containsAll(requeridas);
    }

    // Para la regla de Sangre Pura: Revisa si alguno de sus familiares pertenece a la casa consultada
    public boolean tieneFamiliarEnCasa(Casa casaConsultada) {
        for (Alumno familiar : this.familiares) {
            // Si el familiar tiene casa y es exactamente la que estamos buscando, devuelve true
            if (familiar.getCasa() != null && familiar.getCasa().equals(casaConsultada)) {
                return true;
            }
        }
        return false;
    }

    // Representación amigable del Alumno para imprimir en consola
    @Override
    public String toString() {
        String nombreCasa = (this.casa != null) ? this.casa.getNombre() : "Ninguna";
        return this.nombre + " (Casa: " + nombreCasa + ")";
    }
}