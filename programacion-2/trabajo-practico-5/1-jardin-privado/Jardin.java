import java.util.ArrayList;

public class Jardin{

    ArrayList<Planta> plantas;

    public Jardin(){
        this.plantas = new ArrayList<Planta>();
    }

    public void agregarPlanta(Planta nueva){
        if(!plantas.contains(nueva)){
            plantas.add(nueva);
        }
    }
}