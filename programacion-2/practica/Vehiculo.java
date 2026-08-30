public class Vehiculo{
    
    private String patente;
    private int anio;

    public Vehiculo(String patente, int anio){
        setPatente(patente);
        setAnio(anio);
    }

    public String getPatente(){
        return this.patente;
    }

    public void setPatente(String p){
        this.patente = p;
    }

    public int getAnio(){
        return this.anio;
    }

    public void setAnio(int a){
        this.anio = a;
    }

    public String toString(){
        return "Vehiculo: " + patente + " año: " + anio;
    }

    public boolean equals(Object o1) {
        try {
            Vehiculo otro = (Vehiculo) o1; 
            return otro.getPatente().equals(this.getPatente());
            // return otro.getAnio() == this.getAnio(); -> ejemplo si fuera por int se usa ==
        } catch(Exception e) {
            return false;
        }
    }
}