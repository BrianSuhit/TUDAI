import java.util.ArrayList;

public class PilaDePlatos {
    
    private ArrayList<Plato> platos;

    public PilaDePlatos(){
        this.platos = new ArrayList<>();
    }

    public void push(Plato plato){
        platos.add(plato);
    }

    public Plato top(){
        return platos.getLast();
    }

    public int size(){
        return platos.size();
    }

    public Plato pop(){
        Plato platoAux = platos.getLast();

        platos.removeLast();

        return platoAux;
        // return platos.remove(platos.size() - 1); -> metodo de una sola sentencia
    }

    public PilaDePlatos copy() {
        PilaDePlatos nuevaPila = new PilaDePlatos();

        nuevaPila.platos.addAll(this.platos); 
        return nuevaPila;
    }

    public PilaDePlatos reverse() {
        PilaDePlatos nuevaPila = new PilaDePlatos();
        
        for (int i = this.platos.size() - 1; i >= 0; i--) {
            nuevaPila.platos.add(this.platos.get(i));
        }
        return nuevaPila;   
    }
}
