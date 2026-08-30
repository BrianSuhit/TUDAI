import java.util.ArrayList;

public class Jerarquico extends Empleado{
    
    ArrayList<Empleado> empleadosACargo;

    public Jerarquico(String nombre, String apellido, int edad, int legajo, int sueldo) {
        super(nombre, apellido, edad, legajo, sueldo);
        this.empleadosACargo = new ArrayList<Empleado>();
    }

    @Override
    public String getCargo() {
        return "Jerárquico";
    }

    public void agregarEmpleado(Empleado nuevoEmpleado){
        if(!empleadosACargo.contains(nuevoEmpleado)){
            empleadosACargo.add(nuevoEmpleado);
        }
    }
}
