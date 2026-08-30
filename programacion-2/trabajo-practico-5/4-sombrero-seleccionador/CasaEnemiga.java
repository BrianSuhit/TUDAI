public class CasaEnemiga extends Casa {
    private Casa casaEnemiga;

    public CasaEnemiga(String nombre, int cantidadMaximaAlumnos, Casa casaEnemiga) {
        super(nombre, cantidadMaximaAlumnos);
        this.casaEnemiga = casaEnemiga;
    }

    public Casa getCasaEnemiga() {
        return this.casaEnemiga;
    }

    public void setCasaEnemiga(Casa casaEnemiga) {
        this.casaEnemiga = casaEnemiga;
    }

    @Override
    public boolean acepta(Alumno a) {
        // 1. Debe cumplir los requisitos comunes de esta casa
        // 2. Y además, la casa enemiga NO debe poder aceptarlo
        return super.acepta(a) && !this.casaEnemiga.acepta(a);
    }
}