public class Provincia {
    String nombre;

    Ciudad[] ciudades;

    public Provincia(String nombre, int cantCiudades){
        setNombre(nombre);
        ciudades = new Ciudad[cantCiudades];
    }

    public String nombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void AgregarCiudad(Ciudad ciudad, int pos){
        if(pos >= 0 && pos < ciudades.length){
            this.ciudades[pos] = ciudad;
        }else{
            System.out.println("Posición inválida");
        }
    }

    public int CiudadesAnalizadas(){
        int contador = 0;
        for(int i = 0; i < ciudades.length; i++){
            if(ciudades[i] != null && ciudades[i].SuperaPoblacionMinima()){
                contador++;
            }
        }
        return contador;
    }

    public int CiudadesEnDeficit(){
        int contador = 0;
        for(int i = 0; i < ciudades.length; i++){
            if(ciudades[i] != null && ciudades[i].SuperaPoblacionMinima() && ciudades[i].CiudadEnDeficit()){
                contador++;
            }
        }
        return contador;
    }

    public boolean TieneDeficitProvincia(){
        return CiudadesEnDeficit() > (CiudadesAnalizadas() / 2.0);
    }
}
