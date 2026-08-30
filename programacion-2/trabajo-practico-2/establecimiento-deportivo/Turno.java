import java.time.LocalDate;

public class Turno {
    LocalDate fecha;
    Cancha cancha;
    Usuario usuario;
    double cantHs;

    public Turno(LocalDate fecha, Cancha cancha, Usuario usuario, double cantHs) {
        setFecha(fecha);
        setCancha(cancha);
        setUsuario(usuario);
        setCantHs(cantHs);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getCantHs() {
        return cantHs;
    }

    public void setCantHs(double cantHs) {
        this.cantHs = cantHs;
    }

    public double getPrecioFinal(){
        double precioBase = cancha.getPrecio() * cantHs;

        if(usuario.esSocio()){
            return precioBase * 0.9;
        }
        return precioBase;
    }
}
