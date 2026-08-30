public abstract class Contribuyente {
    private String nombre;
    private String cuit;
    protected double montoFijo;

    public Contribuyente(String nombre, String cuit, double montoFijo) {
        setNombre(nombre);
        setCuit(cuit);
        setMontoFijo(montoFijo);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuit() {
        return this.cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public double getMontoFijo() {
        return this.montoFijo;
    }

    public void setMontoFijo(double montoFijo) {
        this.montoFijo = montoFijo;
    }

    // Método polimórfico: cada subclase calcula su impuesto de forma única
    public double getImpuestoAPagar(){
        return this.montoFijo;
    }

    @Override
    public String toString() {
        return this.nombre + " (CUIT: " + this.cuit + ")";
    }
}