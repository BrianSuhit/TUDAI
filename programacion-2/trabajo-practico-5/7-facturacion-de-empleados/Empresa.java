import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private ArrayList<Empleado> empleados;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter seguro retornando copia de seguridad en RAM [cite: 268]
    public ArrayList<Empleado> getEmpleados() {
        return new ArrayList<>(this.empleados);
    }

    public void addEmpleado(Empleado e) {
        this.empleados.add(e);
    }

    // SECCIÓN B: Calcula polimórficamente la suma total de gastos en sueldos [cite: 30]
    public double getSumaTotalSueldos() {
        double total = 0;
        for (Empleado e : this.empleados) {
            total += e.getSueldoAPagar(); // Polimorfismo puro [cite: 96, 101]
        }
        return total;
    }
}