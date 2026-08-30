public class ContribuyenteComerciante extends Contribuyente {
    private double montoVentas;

    public ContribuyenteComerciante(String nombre, String cuit, double montoFijo, double montoVentas) {
        super(nombre, cuit, montoFijo);
        setMontoVentas(montoVentas);
    }

    public double getMontoVentas() {
        return this.montoVentas;
    }

    public void setMontoVentas(double montoVentas) {
        this.montoVentas = montoVentas;
    }

    @Override
    public double getImpuestoAPagar() {
        return (this.montoFijo * 0.5) + (this.montoVentas * 0.035);
    }
}