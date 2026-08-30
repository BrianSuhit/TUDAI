public class Sensor {
    private String nombre;
    private boolean activo;

    public Sensor(String nombre, boolean activo){
        setNombre(nombre);
        setActivo(activo);
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean equals(Object o1){
        try {
            Sensor otro = (Sensor)o1;
            return otro.getNombre().equals(this.getNombre());
        } catch (Exception e) {
            return false;
        }
    }    
}
