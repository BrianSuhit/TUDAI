public class Asistente {
    // agenda -> reuniones : tema - lugar - duracion -> asistente : telefono - mail

    String nombre;
    String telefono;
    String mail;

    public Asistente(String nombre, String telefono, String mail){
        setNombre(nombre);
        setTelefono(telefono);
        setMail(mail);
    }

    public String getNombre(){
        return nombre;
    }

    public String getTelefono(){
        return telefono;
    }

    public String getMail(){
        return mail;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public void setMail(String mail){
        this.mail = mail;
    }
}
