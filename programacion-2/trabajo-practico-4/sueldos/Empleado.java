public class Empleado {
	private double sueldo;
	private String nombre;
	
	public Empleado(double sueldo, String nombre) {
		super();
		this.sueldo = sueldo;
		this.nombre = nombre;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getSalario() {
		return this.getSueldo();
	}
	
	public boolean equals(Object o1) {
		try {
			Empleado ee = (Empleado)o1;
			return ee.getNombre().equals(this.getNombre());
		} catch(Exception e) {
			return false;
		}
	}
}
