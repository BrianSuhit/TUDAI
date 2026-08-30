public class Ejecutable {
    public static void main(String[] args) {
        
        Episodio ep1 = new Episodio("Piloto", "Primer capitulo de la serie");
        Episodio ep2 = new Episodio("Gato en la bolsa", "Segundo capitulo de la serie");

        Temporada tem1 = new Temporada(2);

        tem1.agregarEpisodio(ep1, 0);
        tem1.agregarEpisodio(ep2, 1);

        Serie serie = new Serie("Breaking Bad", "Drama quimico", "Vince Gilligan", "Drama", 1);
        serie.agregarTemporada(tem1, 0);

        serie.calificarEpisodio(0, 0, 5);
        serie.calificarEpisodio(0, 1, 4);

        System.out.println("Episodios vistos en temporada 0: " + serie.getCantidadVistosTemporada(0));
        System.out.println("Promedio de temporada 0: " + serie.getPromedioCalificacionTemporada(0));
        System.out.println("Episodios vistos totales: " + serie.getCantidadVistos());
        System.out.println("Promedio total de la serie: " + serie.getPromedioCalificacion());
        System.out.println("Se vio completa: " + serie.seVioCompleta());
    }
}
