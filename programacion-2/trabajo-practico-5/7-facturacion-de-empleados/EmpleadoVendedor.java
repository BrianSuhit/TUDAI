public class EmpleadoVendedor extends Empleado {
    private double totalVentas;
    private double porcentajeComision; // Ej: 5.0 representa el 5%

    public EmpleadoVendedor(String nombre, String apellido, String dni, double sueldoMensual, double porcentajeComision) {
        super(nombre, apellido, dni, sueldoMensual);
        this.porcentajeComision = porcentajeComision;
        this.totalVentas = 0; // Empieza el mes sin ventas registradas
    }

    public double getTotalVentas() {
        return this.totalVentas;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }

    public double getPorcentajeComision() {
        return this.porcentajeComision;
    }

    public void setPorcentajeComision(double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    // Registra una venta nueva sumando al acumulador mensual
    public void registrarVenta(double monto) {
        this.totalVentas += monto;
    }

    @Override
    public double getSueldoAPagar() {
        // Sueldo básico + el porcentaje acordado del total de ventas [cite: 29]
        double extraComision = this.totalVentas * (this.porcentajeComision / 100.0);
        return this.sueldoMensual + extraComision;
    }
}