import java.time.LocalDate;

public class Refrigerado extends ProductoFrio {

    public Refrigerado(LocalDate vencimiento, LocalDate envasado, String granja, int numLote, double temperatura,
            int codigo) {
        super(vencimiento, envasado, granja, numLote, temperatura, codigo);
    }
}
