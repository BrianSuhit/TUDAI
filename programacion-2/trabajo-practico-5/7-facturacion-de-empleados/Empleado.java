public class Empleado {
    private String nombre;
    private String apellido;
    private String dni;
    protected double sueldoMensual; // protected para que las subclases lo lean directamente

    public Empleado(String nombre, String apellido, String dni, double sueldoMensual) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sueldoMensual = sueldoMensual;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getSueldoMensual() {
        return this.sueldoMensual;
    }

    public void setSueldoMensual(double sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    // Comportamiento por defecto: retorna el sueldo mensual básico
    public double getSueldoAPagar() {
        return this.sueldoMensual;
    }

    @Override
    public String toString() {
        return this.nombre + " " + this.apellido + " (DNI: " + this.dni + ")";
    }
}