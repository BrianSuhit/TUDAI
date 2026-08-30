import java.util.ArrayList;

public class Lote {
    private int id;
    private double superficie;
    private ArrayList<String> minerales;

    public Lote(int id, double superficie) {
        setId(id);
        setSuperficie(superficie);
        this.minerales = new ArrayList<>();
    }

    // --- GETTERS Y SETTERS ---

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSuperficie() {
        return this.superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public ArrayList<String> getMinerales() {
        return new ArrayList<>(this.minerales);
    }

    // --- MÉTODOS DE ACCIÓN ---

    public void addMineral(String mineral) {
        this.minerales.add(mineral);
    }

    // --- LÓGICA DE NEGOCIO ---

    // Comprueba si el lote tiene todos los minerales de una lista requerida
    public boolean tieneTodosLosMinerales(ArrayList<String> requeridos) {
        return this.minerales.containsAll(requeridos);
    }

    // Comprueba si el lote tiene al menos un mineral de interés primario para la cooperativa
    public boolean contieneAlgunMineral(ArrayList<String> deInteres) {
        for (String m : deInteres) {
            if (this.minerales.contains(m)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Lote #" + this.id + " (" + this.superficie + " ha) - Minerales: " + this.minerales;
    }
}