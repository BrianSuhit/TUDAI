import java.time.LocalDate;
import java.time.Period;

public class Contacto {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String direccion;
    private String email;

    public Contacto(String nombre, String apellido, LocalDate fechaNacimiento, String telefono, String direccion, String email) {
        setNombre(nombre);
        setApellido(apellido);
        setFechaNacimiento(fechaNacimiento);
        setTelefono(telefono);
        setDireccion(direccion);
        setEmail(email);
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
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad(){
        LocalDate nacimiento = getFechaNacimiento();
        LocalDate hoy = LocalDate.now();

        int edad = Period.between(nacimiento, hoy).getYears();
        return edad;
    }

    public boolean esIgualA(Contacto otro) {
        if (otro == null) {
            return false;
        }
        return this.nombre.equals(otro.getNombre()) &&
            this.apellido.equals(otro.getApellido()) &&
            this.telefono.equals(otro.getTelefono());
    }

    public boolean equals(Object o1) {
        try {
            Contacto otro = (Contacto)o1;
            // Si coinciden el tipo, la madera y el color, asumimos que es el mismo mueble
            return otro.getNombre().equals(this.getNombre());
        } catch(Exception e) {
            return false;
        }
    }
}
