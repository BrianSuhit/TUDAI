import java.time.LocalDate;

public class ProductoFrio extends Producto {
    private double temperatura;
    private int codigo;

    public ProductoFrio(LocalDate vencimiento, LocalDate envasado, String granja, int numLote, double temperatura,
            int codigo) {
        super(vencimiento, envasado, granja, numLote);
        setTemperatura(temperatura);
        setCodigo(codigo);
    }
    public double getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String getEtiqueta() {
        return super.getEtiqueta() + ", Temperatura: " + temperatura + "°C, Código: " + codigo; 
    }
}
