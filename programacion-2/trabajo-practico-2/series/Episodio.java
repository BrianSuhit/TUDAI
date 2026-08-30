public class Episodio {
    
    String titulo;
    String descripcion;
    boolean episodioVisto; 
    int calificacion;

    public Episodio(String titulo, String descripcion){
        setTitulo(titulo);
        setDescripcion(descripcion);
        this.episodioVisto = false;
        this.calificacion = -1;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public boolean getEpisodioVisto() {
        return episodioVisto;
    }

    public void setEpisodioVisto(boolean episodioVisto){
        this.episodioVisto = episodioVisto;
    }

    public int getCalificacion(){
        return calificacion; 
    }

    public void setCalificacion(int calificacion){
        if(calificacion < 0 || calificacion > 5){
            System.out.println("por favor ingrese una calificacion entre 0 y 5");
        }
        else{
            this.calificacion = calificacion;
        }
    }
}
