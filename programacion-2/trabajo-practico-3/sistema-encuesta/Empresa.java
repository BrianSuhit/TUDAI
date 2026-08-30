import java.util.ArrayList;

public class Empresa {

    private ArrayList<Encuesta> encuestas;   

    public Empresa(){
        this.encuestas = new ArrayList<Encuesta>();
    }

    public void agregarEncuesta(Encuesta nueva){
        for(int i = 0; i < encuestas.size(); i++){

            Encuesta actual = encuestas.get(i);

            if (actual.getNombre().equals(nueva.getNombre()) && 
                actual.getEncuestado().equals(nueva.getEncuestado())) {
                return; 
            }
        }
        encuestas.add(nueva);
    }

    public int getCantidadEncuestas(Empleado e) {
        int total = 0;
        for (int i = 0; i < encuestas.size(); i++) {
            Encuesta actual = encuestas.get(i);
            
            if (actual.getEmpleado().equals(e)) {
                total++;
            }
        }
        return total;
    }
}