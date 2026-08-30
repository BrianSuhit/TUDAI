public class Ciudad {
    String nombre;
    int poblacion;
    double gastosMantenimiento;

    double[] impuestos = new double[5];

    public Ciudad(String nombre, int poblacion, double gastosMantenimiento, double[] impuestos) {
       setNombre(nombre);
       setPoblacion(poblacion);
       setGastosMantenimiento(gastosMantenimiento);
       setImpuestos(impuestos);
    }

    public String getNombre() {
        return nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public double getGastosMantenimiento() {
        return gastosMantenimiento;
    }

    public double[] getImpuestos() {
        return impuestos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public void setGastosMantenimiento(double gastosMantenimiento) {
        this.gastosMantenimiento = gastosMantenimiento;
    }

    public void setImpuestos(double[] impuestos) {
        this.impuestos = impuestos;
    }

    public double RecaudacionTotal(){
        double recaudacion = 0;
        for(int i = 0; i < impuestos.length; i++){
            recaudacion += impuestos[i];
        }
        return recaudacion;
    }

    public boolean SuperaPoblacionMinima(){
        return poblacion >= 100000;
    }

    public boolean CiudadEnDeficit(){
        return gastosMantenimiento > RecaudacionTotal();
    }
}