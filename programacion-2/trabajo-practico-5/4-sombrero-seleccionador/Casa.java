import java.util.ArrayList;

public class Casa {
    private String nombre;
    private ArrayList<String> cualidades;
    private ArrayList<Alumno> alumnos;
    private int cantidadMaximaAlumnos;


    public Casa(String nombre, int cantidadMaximaAlumnos) {
        this.nombre = nombre;
        this.cantidadMaximaAlumnos = cantidadMaximaAlumnos;
        this.cualidades = new ArrayList<>();
        this.alumnos = new ArrayList<>();
    }

    // --- GETTERS Y SETTERS TRADICIONALES ---
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadMaximaAlumnos() {
        return this.cantidadMaximaAlumnos;
    }

    public void setCantidadMaximaAlumnos(int cantidadMaximaAlumnos) {
        this.cantidadMaximaAlumnos = cantidadMaximaAlumnos;
    }

    // --- PROTECCIÓN DEL ENCAPSULAMIENTO (GETTERS) ---
    public ArrayList<String> getCualidades() {
        return new ArrayList<>(this.cualidades);
    }

    public ArrayList<Alumno> getAlumnos() {
        return new ArrayList<>(this.alumnos);
    }

    // --- MÉTODOS DE ACCIÓN ---
    public void addCualidad(String cualidad) {
        this.cualidades.add(cualidad);
    }

    // --- LÓGICA DE NEGOCIO (COMPORTAMIENTO) ---
    // Determina si el alumno es apto y cumple las condiciones de la casa
    public boolean acepta(Alumno a) {
        // 1. Regla de Hogwarts: Un alumno puede pertenecer como máximo a una única casa
        if (a.tieneCasaAsignada()) {
            return false;
        }

        // 2. Controlar que no esté llena
        if (this.alumnos.size() >= this.cantidadMaximaAlumnos) {
            return false;
        }

        // 3. Controlar cualidades requeridas delegando en el alumno (Tell, Don't Ask)
        if (!a.tieneTodasLasCualidades(this.cualidades)) {
            return false;
        }

        return true;
    }

    // Agrega efectivamente al alumno si pasa el filtro de aceptación
    public boolean addAlumno(Alumno a) {
        if (this.acepta(a)) {
            this.alumnos.add(a);
            a.setCasa(this); // Vinculación bidireccional en memoria RAM
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Casa " + this.nombre + " (" + this.alumnos.size() + "/" + this.cantidadMaximaAlumnos + ")";
    }
}