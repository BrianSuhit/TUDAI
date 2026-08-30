public class CasaSangrePura extends Casa {

    public CasaSangrePura(String nombre, int cantidadMaximaAlumnos) {
        super(nombre, cantidadMaximaAlumnos);
    }

    @Override
    public boolean acepta(Alumno a) {
        // 1. Reusamos el comportamiento del padre (cupo, cualidades, no asignado) 
        // 2. Y le sumamos nuestra regla específica delegando en el Alumno
        return super.acepta(a) && a.tieneFamiliarEnCasa(this);
    }
}