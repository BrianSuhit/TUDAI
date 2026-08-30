public class Poster extends Trabajo {

    public Poster(String titulo) {
        super(titulo);
    }

    // Sobrescribimos polimórficamente la regla: para Posters basta con un solo tema [cite: 30, 96]
    @Override
    public boolean puedeSerEvaluadoPor(Evaluador e) {
        return e.tieneAlgunTema(this.getPalabrasClave());
    }
}