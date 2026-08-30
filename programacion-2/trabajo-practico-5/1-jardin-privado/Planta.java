import java.time.LocalDate;

public class Planta {
    private String nombreCientifico;
    private String nombreComun;
    private String pais;
    private LocalDate fechaCompra;
    private int id;

    private static int ultimoId = 0; 

    public Planta(String nombreCientifico, String nombreComun, String pais, LocalDate fechaCompra) {
        setNombreCientifico(nombreCientifico);
        setNombreComun(nombreComun);
        setPais(pais);
        setFechaCompra(fechaCompra);
        ultimoId++;
        this.id = ultimoId;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }
    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }
    public String getNombreComun() {
        return nombreComun;
    }
    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public LocalDate getFechaCompra() {
        return fechaCompra;
    }
    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o1) {
        try {
            Planta otra = (Planta) o1;
            return this.getId() == otra.getId();
        } catch(Exception e) {
            return false;
        }
    }
}
