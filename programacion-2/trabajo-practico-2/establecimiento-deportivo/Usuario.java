import java.time.LocalDate;

public class Usuario {
    String nombre;
    Turno[] misTurnos;

    public Usuario(String nombre, Turno[] misTurnos) {
        setNombre(nombre);
        this.misTurnos = misTurnos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void registrarTurno(Turno turno, int pos){
        if(pos >= 0 && pos < misTurnos.length){
            this.misTurnos[pos] = turno;
        
        }
    }

    public boolean esSocio(){
        int contador = 0;
        LocalDate fechaCorte = LocalDate.now().minusMonths(2);

        for(int i = 0; i < misTurnos.length; i++){
            if(misTurnos[i] != null){
                if(misTurnos[i].getFecha().isAfter(fechaCorte)){
                    contador++;
                }
            }
        }
        return contador >= 4;
    }
}
