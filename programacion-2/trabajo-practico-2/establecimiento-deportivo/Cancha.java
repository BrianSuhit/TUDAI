public class Cancha {
    int numero;
    String deporte;
    double precio;

    public Cancha(int numero, String deporte, double precio) {
        setDeporte(deporte);
        setPrecio(precio);
        setNumero(numero);
    }

    public String getDeporte() {
        return deporte;
    }

    public double getPrecio() {
        return precio;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
