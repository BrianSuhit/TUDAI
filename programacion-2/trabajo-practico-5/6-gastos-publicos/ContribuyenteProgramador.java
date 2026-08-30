public class ContribuyenteProgramador extends Contribuyente {
    private double montoSoftware;

    public ContribuyenteProgramador(String nombre, String cuit, double montoFijo, double montoSoftware) {
        super(nombre, cuit, montoFijo);
        setMontoSoftware(montoSoftware);
    }

    public double getMontoSoftware() {
        return this.montoSoftware;
    }

    public void setMontoSoftware(double montoSoftware) {
        this.montoSoftware = montoSoftware;
    }

    @Override
    public double getImpuestoAPagar() {
        return (this.montoFijo * 0.2) + (this.montoSoftware * 0.02);
    }
}