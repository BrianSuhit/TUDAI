import java.util.ArrayList;

public class Empresa {

	private ArrayList<Empleado> empleados;

	public Empresa() {
		empleados = new ArrayList<Empleado>();
	}
	
	public void agregarEmpleado(Empleado aa) {
		if (!empleados.contains(aa)) {
			empleados.add(aa);
		}
	}
	
	public double getMasaSalarial() {
		double suma = 0;
		for(int i=0; i<empleados.size();i++) {
			suma = suma +empleados.get(i).getSalario(); 
		}
		return suma;
	}
	
	public double getSueldo(Empleado ee) {
	  if (empleados.contains(ee))
		return ee.getSalario();
	  else {
		  return 0;
	  }
	}
}