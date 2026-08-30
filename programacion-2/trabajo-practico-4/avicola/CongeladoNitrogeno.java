import java.time.LocalDate;

public class CongeladoNitrogeno extends Congelado {
    private String metodoCongelacion;
    private double tiempoExplosicion;

    
    public CongeladoNitrogeno(LocalDate vencimiento, LocalDate envasado, String granja, int numLote, double temperatura, int codigo, String metodoCongelacion, double tiempoExplosicion) {
        super(vencimiento, envasado, granja, numLote, temperatura, codigo);
        setMetodoCongelacion(metodoCongelacion);
        setTiempoExplosicion(tiempoExplosicion);
    }
    public String getMetodoCongelacion() {
        return metodoCongelacion;
    }
    public void setMetodoCongelacion(String metodoCongelacion) {
        this.metodoCongelacion = metodoCongelacion;
    }
    public double getTiempoExplosicion() {
        return tiempoExplosicion;
    }
    public void setTiempoExplosicion(double tiempoExplosicion) {
        this.tiempoExplosicion = tiempoExplosicion;
    }

    @Override
    public String getEtiqueta() {
        return super.getEtiqueta() + ", Metodo de Congelacion: " + metodoCongelacion +
            "Tiempo de exposicion (en hs): " + tiempoExplosicion;
    }
}
