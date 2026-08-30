import java.util.ArrayList;

public class Alarma {
    // private boolean movimiento;
    // private boolean vidrioRoto;
    // private boolean puertaAbierta;
    // private boolean ventanaAbierta;

    private Timbre timbre;
    private ArrayList<Sensor> sensores;

    public Alarma(Timbre timbre){
        // setMovimiento(movimiento);
        // setVidrioRoto(vidrioRoto);
        // setPuertaAbierta(puertaAbierta);
        // setVentanaAbierta(ventanaAbierta);
        this.timbre = timbre;
        this.sensores = new ArrayList<Sensor>();
    }

    public void agregarSensor(Sensor sensorNuevo){
        if(!sensores.contains(sensorNuevo)){
            sensores.add(sensorNuevo);
        }
    }

    // public boolean isMovimiento() {
    //     return movimiento;
    // }
    // public void setMovimiento(boolean movimiento) {
    //     this.movimiento = movimiento;
    // }
    // public boolean isVidrioRoto() {
    //     return vidrioRoto;
    // }
    // public void setVidrioRoto(boolean vidrioRoto) {
    //     this.vidrioRoto = vidrioRoto;
    // }
    // public boolean isPuertaAbierta() {
    //     return puertaAbierta;
    // }
    // public void setPuertaAbierta(boolean puertaAbierta) {
    //     this.puertaAbierta = puertaAbierta;
    // }
    // public boolean isVentanaAbierta() {
    //     return ventanaAbierta;
    // }
    // public void setVentanaAbierta(boolean ventanaAbierta) {
    //     this.ventanaAbierta = ventanaAbierta;
    // }

    public boolean comprobar(){
        // if (isMovimiento() || isVidrioRoto() || isPuertaAbierta() || isVentanaAbierta()) {
        //     timbre.hacerSonar();
        //     return true;
        // }
        boolean seDisparo = false;

        for(int i = 0; i < sensores.size(); i++){
            Sensor sensorActual = sensores.get(i);

            if(sensorActual.isActivo()){
                System.out.println("sensor activo en la zona: " + sensorActual.getNombre());
                seDisparo = true;
            }
        }
        
        if(seDisparo){
            timbre.hacerSonar();
        }
        return seDisparo;
    }
}
