import java.time.LocalDate;

public class Congelado extends ProductoFrio{

    public Congelado(LocalDate vencimiento, LocalDate envasado, String granja, int numLote, double temperatura,
            int codigo) {
        super(vencimiento, envasado, granja, numLote, temperatura, codigo);
    }
}
