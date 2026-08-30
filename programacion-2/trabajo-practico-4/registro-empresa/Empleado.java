public class Empleado extends Persona{
    private int legajo;
    private int sueldo;

    public Empleado(String nombre, String apellido, int edad, int legajo, int sueldo) {
        super(nombre, apellido, edad);
        setLegajo(legajo);
        setSueldo(sueldo);
    }

    @Override
    public String getCargo() {
        return "Empleado";
    }

    public int getLegajo() {
        return legajo;
    }
    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }
    public int getSueldo() {
        return sueldo;
    }
    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
}
