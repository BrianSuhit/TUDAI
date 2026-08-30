public class AlarmaLuminosa extends Alarma {
    
    private Luz luz;

    public AlarmaLuminosa(Timbre timbre, Luz luz){
        super(timbre); 
        this.luz = luz;
    }

    @Override
    public boolean comprobar(){
        boolean seDisparo = super.comprobar();

        if(seDisparo){
            luz.encender();
        }
        return seDisparo;
    }
}
