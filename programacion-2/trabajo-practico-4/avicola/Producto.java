import java.time.LocalDate;

public class Producto {
    private LocalDate vencimiento;
    private LocalDate envasado;
    private String granja;
    private int numLote;

    public Producto(LocalDate vencimiento, LocalDate envasado, String granja, int numLote) {
        setVencimiento(vencimiento);
        setEnvasado(envasado);
        setGranja(granja);
        setNumLote(numLote);
    }

    public int getNumLote() {
        return numLote;
    }

    public void setNumLote(int numLote) {
        this.numLote = numLote;
    }
    
    public LocalDate getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(LocalDate vencimiento) {
        this.vencimiento = vencimiento;
    }

    public LocalDate getEnvasado() {
        return envasado;
    }

    public void setEnvasado(LocalDate envasado) {
        this.envasado = envasado;
    }

    public String getGranja() {
        return granja;
    }

    public void setGranja(String granja) {
        this.granja = granja;
    }

    public String getEtiqueta() {
        return "Lote: " + numLote + ", Vencimiento: " + vencimiento + 
           ", Envasado: " + envasado + ", Granja: " + granja;
    }
}
