import java.time.LocalDate;

public class CongeladoAgua extends Congelado {
    public double salinidad;

    public CongeladoAgua(LocalDate vencimiento, LocalDate envasado, String granja, int numLote, double temperatura, int codigo, double salinidad) {
        super(vencimiento, envasado, granja, numLote, temperatura, codigo);
        setSalinidad(salinidad);
    }

    public double getSalinidad() {
        return salinidad;
    }

    public void setSalinidad(double salinidad) {
        this.salinidad = salinidad;
    }

    @Override
    public String getEtiqueta() {
        return super.getEtiqueta() + ", Salinidad: " + salinidad + "g/l";
    }
}
