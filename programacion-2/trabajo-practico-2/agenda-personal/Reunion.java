import java.time.LocalDateTime;

public class Reunion {
    // agenda -> reuniones : tema - lugar - duracion -> asistente : telefono - mail

    String tema;
    String lugar;
    Asistente[] asistentes;

    double duracion;
    LocalDateTime fechaYhora;

    public Reunion(String tema, String lugar, double duracion, int cantAsistentes, LocalDateTime fechaYhora){
        setTema(tema);
        setLugar(lugar);
        this.asistentes = new Asistente[cantAsistentes];

        setDuracion(duracion);
        setFechayHora(fechaYhora);
    }

    public String getTema(){
        return tema;
    }

    public String getLugar(){
        return lugar;
    }

    public double getDuracion(){
        return duracion;
    }

    public LocalDateTime getFechayHoraInicio(){
        return fechaYhora;
    }

    public LocalDateTime getFechayHoraFin() {
        int minutos = (int) (duracion * 60);
        return this.fechaYhora.plusMinutes(minutos);
    }

    public void setFechayHora(LocalDateTime fechaYhora){
        this.fechaYhora = fechaYhora;
    }

    public void setTema(String tema){
        this.tema = tema;
    }

    public void setLugar(String lugar){
        this.lugar = lugar;
    }

    public void setDuracion(double duracion){
        this.duracion = duracion;
    }

    public void AgregarAsistente(Asistente nuevoAsistente, int pos){
        if(pos >= 0 && pos < asistentes.length){
            this.asistentes[pos] = nuevoAsistente;
        }
    }
}
