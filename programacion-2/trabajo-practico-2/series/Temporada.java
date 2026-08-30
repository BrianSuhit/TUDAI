public class Temporada{

    Episodio[] episodios;

    public Temporada(int cantEpisodios){
        this.episodios = new Episodio[cantEpisodios];
    }

    public void agregarEpisodio(Episodio nuevoEpisodio, int posicion){
        if(posicion >= 0 && posicion < episodios.length){
            this.episodios[posicion] = nuevoEpisodio;
        }
    }

    public void calificarEpisodio(int nroEpisodio, int calificacion) {
        if (nroEpisodio >= 0 && nroEpisodio < episodios.length) {
            Episodio epi = episodios[nroEpisodio];
            if (epi != null) {
                epi.setCalificacion(calificacion);
                epi.setEpisodioVisto(true);
            }
        }
    }

    public int getCantidadVistos(){
        int contador = 0;

        for(int i = 0; i < episodios.length; i++){
            Episodio epi = this.episodios[i];

            if(epi != null && epi.getEpisodioVisto() == true){
                contador += 1;
            }
        }
        return contador;
    }

    public int getSumaCalificaciones() {
        int suma = 0;
        for (int i = 0; i < episodios.length; i++) {
            Episodio epi = this.episodios[i];
            if (epi != null && epi.getEpisodioVisto()) {
                suma += epi.getCalificacion();
            }
        }
        return suma;
    }

    public double getPromedioCalificacion() {
        int vistos = getCantidadVistos();
        if (vistos == 0) {
            System.out.println("todavia no se vio ningun episodio");
            return 0.0;
        }
        return (double) getSumaCalificaciones() / vistos;
    }

    public boolean seVioCompleta() {
        for (int i = 0; i < episodios.length; i++) {
            Episodio epi = episodios[i];
            if (epi == null || !epi.getEpisodioVisto()) {
                return false;
            }
        }
        return true;
    }
}