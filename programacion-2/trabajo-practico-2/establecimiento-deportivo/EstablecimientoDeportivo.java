public class EstablecimientoDeportivo {
    String nombre;
    Cancha[] canchas;

    public EstablecimientoDeportivo(String nombre, int cantCanchas) {
        setNombre(nombre);
        this.canchas = new Cancha[cantCanchas];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cancha[] getCanchas() {
        return canchas;
    }

    public void agregarCancha(Cancha cancha, int pos){
        if(pos >= 0 && pos < canchas.length){
            this.canchas[pos] = cancha;
        }
    }
}
