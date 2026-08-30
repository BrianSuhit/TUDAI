public class Habilidad {
    private String nombre;
    private int valor;

    public Habilidad(String nombre, int valor){
        setNombre(nombre);
        setValor(valor);
    }

    public String getNombre(){
        return nombre;
    }

    public int getValor(){
        return valor;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setValor(int valor){
        this.valor = valor;
    }

    public boolean equals(Object o1) {
        try {
            Habilidad otro = (Habilidad)o1;
            return otro.getNombre().equals(this.getNombre());
        } catch(Exception e) {
            return false;
        }
    }
}
