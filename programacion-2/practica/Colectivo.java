public class Colectivo extends Vehiculo {
    private int cantAsientos;

    public Colectivo(String patente, int anio, int cantAsientos){
        super(patente, anio);
        setAsientos(cantAsientos);
    }

    public int getAsientos(){
        return this.cantAsientos;
    }

    public void setAsientos(int a){
        this.cantAsientos = a;
    }

    @Override
    public String toString(){
        return super.toString() + " con: " + cantAsientos + " asientos.";
    }
}
