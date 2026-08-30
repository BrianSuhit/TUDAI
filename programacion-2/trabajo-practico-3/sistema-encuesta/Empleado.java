public class Empleado {
    private String nombre;

    public Empleado(String nombre){
        setNombre(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

       public boolean equals(Object o1) {
        try {
            Empleado otro = (Empleado)o1;
            return otro.getNombre().equals(this.getNombre());
        } catch(Exception e) {
            return false;
        }
    }
}
