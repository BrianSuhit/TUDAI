import java.util.ArrayList;

public class Cooperativa {
    private ArrayList<Lote> lotes;
    private ArrayList<Cereal> cereales;
    private ArrayList<String> mineralesPrimarios;

    public Cooperativa() {
        this.lotes = new ArrayList<>();
        this.cereales = new ArrayList<>();
        this.mineralesPrimarios = new ArrayList<>();
    }

    // --- MÉTODOS DE REGISTRO ---

    public void addLote(Lote l) {
        this.lotes.add(l);
    }

    public void addCereal(Cereal c) {
        this.cereales.add(c);
    }

    public void addMineralPrimario(String mineral) {
        this.mineralesPrimarios.add(mineral);
    }

    // --- GETTERS PROTEGIDOS CON COPIAS ---

    public ArrayList<Lote> getLotes() {
        return new ArrayList<>(this.lotes);
    }

    public ArrayList<Cereal> getCereales() {
        return new ArrayList<>(this.cereales);
    }

    public ArrayList<String> getMineralesPrimarios() {
        return new ArrayList<>(this.mineralesPrimarios);
    }

    // --- LAS 3 CONSULTAS REQUERIDAS ---

    // 1) Qué cereales pueden sembrarse en un determinado lote
    public ArrayList<Cereal> getCerealesAptosPara(Lote lote) {
        ArrayList<Cereal> aptos = new ArrayList<>();
        for (Cereal c : this.cereales) {
            // Colaboración por parámetro: le preguntamos al cereal si el lote le sirve
            if (c.puedeSembrarseEn(lote)) {
                aptos.add(c);
            }
        }
        return aptos;
    }

    // 2) En qué lotes se puede sembrar un determinado cereal
    public ArrayList<Lote> getLotesAptosPara(Cereal cereal) {
        ArrayList<Lote> aptos = new ArrayList<>();
        for (Lote l : this.lotes) {
            // Colaboración por parámetro [cite: 24, 47]
            if (cereal.puedeSembrarseEn(l)) {
                aptos.add(l);
            }
        }
        return aptos;
    }

    // 3) Determinar si un lote dado es "especial" o "común"
    public boolean esLoteEspecial(Lote lote) {
        // Un lote es especial si contiene al menos uno de los minerales primarios
        return lote.contieneAlgunMineral(this.mineralesPrimarios);
    }

    public boolean esLoteComun(Lote lote) {
        // Un lote es común si no es especial (solo tiene minerales secundarios)
        return !this.esLoteEspecial(lote);
    }
}