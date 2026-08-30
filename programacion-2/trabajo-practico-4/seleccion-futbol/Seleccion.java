import java.util.ArrayList;

public class Seleccion {
    private String nombre;
    private ArrayList<MiembroSeleccion> integrantes;

    public Seleccion(String nombre) {
        this.nombre = nombre;
        this.integrantes = new ArrayList<MiembroSeleccion>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarIntegrante(MiembroSeleccion nuevo) {
        if (!integrantes.contains(nuevo)) {
            integrantes.add(nuevo);
        }
    }

    public ArrayList<MiembroSeleccion> getIntegrantesDisponibles() {
        ArrayList<MiembroSeleccion> disponibles = new ArrayList<MiembroSeleccion>();
        
        for (int i = 0; i < integrantes.size(); i++) {
            MiembroSeleccion actual = integrantes.get(i);
            
            if (actual.estaDisponible()) {
                disponibles.add(actual);
            }
        }
        
        return disponibles;
    }
}