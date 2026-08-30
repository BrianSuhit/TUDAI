import java.time.LocalDate;

public class CongeladoAire extends Congelado {
    private double gases;

    public CongeladoAire(LocalDate vencimiento, LocalDate envasado, String granja, int numLote, double temperatura, int codigo, double gases) {
        super(vencimiento, envasado, granja, numLote, temperatura, codigo);
        setGases(gases);
    }

    public double getGases() {
        return gases;
    }

    public void setGases(double gases) {
        this.gases = gases;
    }

    @Override
    public String getEtiqueta() {

        return super.getEtiqueta() + ", Gases: " + gases + "%";
    }
}
