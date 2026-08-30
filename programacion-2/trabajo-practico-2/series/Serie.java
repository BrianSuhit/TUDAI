public class Serie{

    String titulo;
    String descripcion;
    String creador;
    String genero;

    Temporada[] temporadas;

    public Serie(String titulo, String descripcion, String creador, String genero, int cantTemporadas) {
        setTitulo(titulo);
        setDescripcion(descripcion);
        setCreador(creador);
        setGenero(genero);
        this.temporadas = new Temporada[cantTemporadas];
    }

    public void agregarTemporada(Temporada temp, int posicion) {
        if (posicion >= 0 && posicion < temporadas.length) {
            this.temporadas[posicion] = temp;
        }
    }

    public void calificarEpisodio(int nroTemporada, int nroEpisodio, int nota) {
        if (nroTemporada >= 0 && nroTemporada < temporadas.length) {
            Temporada temp = temporadas[nroTemporada];
            if (temp != null) {
                temp.calificarEpisodio(nroEpisodio, nota);
            }
        }
    }

    public int getCantidadVistosTemporada(int nroTemporada) {
        if (nroTemporada >= 0 && nroTemporada < temporadas.length) {
            Temporada temp = temporadas[nroTemporada];
            if (temp != null) {
                return temp.getCantidadVistos();
            }
        }
        return 0;
    }

    public int getCantidadVistos() {
        int total = 0;
        for (int i = 0; i < temporadas.length; i++) {
            Temporada temp = temporadas[i];
            if (temp != null) {
                total += temp.getCantidadVistos();
            }
        }
        return total;
    }

    public double getPromedioCalificacionTemporada(int nroTemporada) {
        if (nroTemporada >= 0 && nroTemporada < temporadas.length) {
            Temporada temp = temporadas[nroTemporada];
            if (temp != null) {
                return temp.getPromedioCalificacion();
            }
        }
        return 0.0;
    }

    public double getPromedioCalificacion() {
        int totalVistos = getCantidadVistos();
        if (totalVistos == 0) {
            return 0.0;
        }
        int sumaTotal = 0;
        for (int i = 0; i < temporadas.length; i++) {
            Temporada temp = temporadas[i];
            if (temp != null) {
                sumaTotal += temp.getSumaCalificaciones();
            }
        }
        return (double) sumaTotal / totalVistos;
    }

    public boolean seVioCompleta() {
        for (int i = 0; i < temporadas.length; i++) {
            Temporada temp = temporadas[i];
            if (temp == null || !temp.seVioCompleta()) {
                return false;
            }
        }
        return true;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}