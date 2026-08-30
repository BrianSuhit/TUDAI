public class UsuarioFinal extends Persona {
    private String nombreUsuario;
    private int password;

    public UsuarioFinal(String nombre, String apellido, int edad, String nombreUsuario, int password){
        super(nombre, apellido, edad);
        setNombre(nombreUsuario);
        setPassword(password);
    }

    @Override
    public String getCargo() {
        return "Usuario Final";
    }

    public String getNombre() {
        return nombreUsuario;
    }
    public void setNombre(String nombre) {
        this.nombreUsuario = nombre;
    }
    public int getPassword() {
        return password;
    }
    public void setPassword(int password) {
        this.password = password;
    }
}
