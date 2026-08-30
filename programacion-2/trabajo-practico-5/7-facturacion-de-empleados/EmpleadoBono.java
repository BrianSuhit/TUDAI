public class EmpleadoBono extends Empleado {
    private int ventasRealizadas;
    private int ventasRequeridas; // Cantidad mínima de ventas para cobrar el bono
    private double montoBono; // El premio extra en plata 

    public EmpleadoBono(String nombre, String apellido, String dni, double sueldoMensual, int ventasRequeridas, double montoBono) {
        super(nombre, apellido, dni, sueldoMensual);
        this.ventasRequeridas = ventasRequeridas;
        this.montoBono = montoBono;
        this.ventasRealizadas = 0;
    }

    public int getVentasRealizadas() {
        return this.ventasRealizadas;
    }

    public void setVentasRealizadas(int ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }

    public int getVentasRequeridas() {
        return this.ventasRequeridas;
    }

    public void setVentasRequeridas(int ventasRequeridas) {
        this.ventasRequeridas = ventasRequeridas;
    }

    public double getMontoBono() {
        return this.montoBono;
    }

    public void setMontoBono(double montoBono) {
        this.montoBono = montoBono;
    }

    // Registra una unidad de venta concretada
    public void registrarVenta() {
        this.ventasRealizadas++;
    }

    @Override
    public double getSueldoAPagar() {
        // Si cumple la meta, se le suma el bono al sueldo básico. Si no, cobra el básico normal
        if (this.ventasRealizadas >= this.ventasRequeridas) {
            return this.sueldoMensual + this.montoBono;
        }
        return this.sueldoMensual;
    }
}