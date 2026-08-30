import java.util.ArrayList;

public class Congreso {
    private ArrayList<Evaluador> evaluadores;
    private ArrayList<Trabajo> trabajos;
    private ArrayList<String> temasExpertos; // Temas específicos del congreso

    public Congreso() {
        this.evaluadores = new ArrayList<>();
        this.trabajos = new ArrayList<>();
        this.temasExpertos = new ArrayList<>();
    }

    public void addEvaluador(Evaluador e) {
        this.evaluadores.add(e);
    }

    public void addTrabajo(Trabajo t) {
        this.trabajos.add(t);
    }

    public void addTemaExperto(String tema) {
        this.temasExpertos.add(tema);
    }

    // --- LAS 4 CONSULTAS QUE PIDE EL ENUNCIADO ---

    // 1) Qué evaluador puede asignarse a un determinado trabajo
    public ArrayList<Evaluador> getEvaluadoresAptosPara(Trabajo t) {
        ArrayList<Evaluador> aptos = new ArrayList<>();
        for (Evaluador e : this.evaluadores) {
            // Colaboración por parámetro: el trabajo sabe si el evaluador califica
            if (t.puedeSerEvaluadoPor(e)) {
                aptos.add(e);
            }
        }
        return aptos;
    }

    // 2) Qué trabajos pueden asignarse a un evaluador particular
    public ArrayList<Trabajo> getTrabajosAptosPara(Evaluador e) {
        ArrayList<Trabajo> aptos = new ArrayList<>();
        for (Trabajo t : this.trabajos) {
            if (t.puedeSerEvaluadoPor(e)) {
                aptos.add(t);
            }
        }
        return aptos;
    }

    // 3) Cuántos trabajos tiene un evaluador determinado
    public int getCantTrabajosDe(Evaluador e) {
        return e.getCantTrabajos(); // Delegamos la respuesta en el objeto Evaluador
    }

    // 4) Determinar si un evaluador dado es general o experto
    public boolean esExperto(Evaluador e) {
        // Es experto si declaró conocimiento en al menos un tema específico
        return e.tieneAlgunTema(this.temasExpertos);
    }

    public boolean esGeneral(Evaluador e) {
        // Es general si no califica como experto 
        return !this.esExperto(e);
    }
}