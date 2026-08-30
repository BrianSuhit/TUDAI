public class EmpleadoVentas extends Empleado {

	private double ventas;
	private double porc;

	public EmpleadoVentas(double sueldo, 
			String nombre, double ventas, double porc) {
		super(sueldo, nombre);
		this.ventas = ventas;
		this.porc = porc;
	}
	public double getVentas() {
		return ventas;
	}
	public void setVentas(double ventas) {
		this.ventas = ventas;
	}
	public double getPorc() {
		return porc;
	}
	public void setPorc(double porc) {
		this.porc = porc;
	}
	
	public double getSalario() {
		return super.getSalario() + porc*ventas;
	}
}