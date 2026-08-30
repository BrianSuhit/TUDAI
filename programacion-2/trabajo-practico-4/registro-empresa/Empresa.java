import java.util.ArrayList;

public class Empresa {
    
    private ArrayList<Persona> personas;

    public Empresa() {
        this.personas = new ArrayList<Persona>();
    }

    public void agregarEmpleado(Persona nuevaPersona){
        if(!personas.contains(nuevaPersona)){
            personas.add(nuevaPersona);
        }
    }

    public String exportarListado() {
        String resultado = "";
        
        for (int i = 0; i < personas.size(); i++) {
            resultado += personas.get(i).toString() + "\n"; 
        }
        
        return resultado;
    }
}
