public class Encuesta {
    private String nombre;
    private Persona encuestado;
    private Empleado empleado;

    public Encuesta(String nombre, Persona encuestado, Empleado empleado) {
        this.nombre = nombre;
        this.encuestado = encuestado;
        this.empleado = empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public Persona getEncuestado() {
        return encuestado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }
}
