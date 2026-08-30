public class Persona {
    private int dni;

    public Persona(int dni){
        setDNI(dni);
    }

    public int getDNI(){
        return dni;
    }

    public void setDNI(int dni){
        this.dni = dni;
    }

    public boolean equals(Object o1) {
        try {
            Persona otro = (Persona)o1;
            return otro.getDNI() == this.getDNI();
        } catch(Exception e) {
            return false;
        }
    }
}
