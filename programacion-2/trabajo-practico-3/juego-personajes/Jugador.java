import java.util.ArrayList;

public class Jugador {
    private String nombreReal;
    private String nombreSuper;
    private ArrayList<Habilidad> habilidades;

    public Jugador(){
        setNombreReal(nombreReal);
        setNombreSuper(nombreSuper);
        this.habilidades = new ArrayList<Habilidad>();
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }


    public String getNombreSuper() {
        return nombreSuper;
    }


    public void setNombreSuper(String nombreSuper) {
        this.nombreSuper = nombreSuper;
    }

    public void agregarHabilidad(Habilidad nuevHabilidad){
        if(!habilidades.contains(nuevHabilidad)){
            habilidades.add(nuevHabilidad);
        }
    }

    public int getValorHabilidad(String nombreBuscado){
        for(int i = 0; i < habilidades.size(); i++){
                Habilidad actual = habilidades.get(i);

                if(actual.getNombre().equals(nombreBuscado)){
                    return actual.getValor();
                }
        }
        return 0;
    }

    public boolean equals(Object o1) {
        try {
            Jugador otro = (Jugador) o1;
            return otro.getNombreSuper().equals(this.getNombreSuper());
        } catch(Exception e) {
            return false;
        }
    }

    public Jugador atacar(Jugador oponente, String habilidadPrincipal, String habilidadDesempate){
        int player1Puntos = this.getValorHabilidad(habilidadDesempate);

        int player2Puntos = this.getValorHabilidad(habilidadPrincipal);

        if(player1Puntos > player2Puntos){
            return this;
        }else if(player1Puntos < player2Puntos){
            return oponente;
        }else{
            int player1Desempate = this.getValorHabilidad(habilidadDesempate);

            int player2Desempate = this.getValorHabilidad(habilidadDesempate);

            if (player1Desempate > player2Desempate) {
                return this;
            }
            else if(player1Desempate < player2Desempate) {
                    return oponente;
            }else{
                    return null;
            }  
        }

    }
}
