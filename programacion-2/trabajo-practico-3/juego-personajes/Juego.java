import java.util.ArrayList;

public class Juego{

    private ArrayList<Jugador> mazo;

    public Juego(){
        this.mazo = new ArrayList<Jugador>();
    }

    public void agregarJugador(Jugador nuevoJugador){
        if(!mazo.contains(nuevoJugador)){
            mazo.add(nuevoJugador);
        }
    }

    public Jugador jugarRonda(Jugador j1, Jugador j2, String principal, String desempate){
        Jugador ganador = j1.atacar(j2, principal, desempate);

        return ganador;
    }

    public String getGanador(Jugador ganador){
        return ganador.getNombreSuper();
    }
}