import java.time.LocalDate;

public class MiembroSeleccion {
    private String nombre;
    private String apellido;
    private int numPasaporte;
    private LocalDate fechaNacimiento;
    private String estado;

    public MiembroSeleccion(String nombre, String apellido, int numPasaporte, LocalDate fechaNacimiento){
        setNombre(nombre);
        setApellido(apellido);
        setNumPasaporte(numPasaporte);
        setFechaNacimiento(fechaNacimiento);
        setEstado(estado);
    }

    public String getEstado(){
        return estado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getNumPasaporte() {
        return numPasaporte;
    }
    public void setNumPasaporte(int numPasaporte) {
        this.numPasaporte = numPasaporte;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean estaDisponible(){
        return this.estado.equals("En país de origen"); 
    }

    @Override
    public boolean equals(Object o1) {
       try {
           MiembroSeleccion otro = (MiembroSeleccion) o1;
           return this.getNumPasaporte() == otro.getNumPasaporte();
        } catch (Exception e) {
           return false;
        }
   }
}
