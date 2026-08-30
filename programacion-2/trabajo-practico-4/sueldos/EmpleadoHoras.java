
public class EmpleadoHoras extends Empleado{

	private double valorHora;
	private int horas;

	public EmpleadoHoras(double sueldo, 
		String nombre, double valorHora, int horas) {
		super(sueldo, nombre);
		this.valorHora = valorHora;
		this.horas = horas;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public double getSalario() {
		return super.getSalario() + valorHora*horas;
	}
}