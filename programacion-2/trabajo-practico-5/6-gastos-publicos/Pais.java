public class Pais {
    String nombre;
    Provincia[] provincias;

    public Pais(String nombre, int cantProvincias){
        setNombre(nombre);
        provincias = new Provincia[cantProvincias];
    }

    public String nombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void AgregarProvincia(Provincia provincia, int pos){
        if(pos >= 0 && pos < provincias.length){
            this.provincias[pos] = provincia;
        }else{
            System.out.println("Posición inválida");
        }
    }

    public int ProvinciasEnDeficit(){
        int contador = 0;
        for(int i = 0; i < provincias.length; i++){
            if(provincias[i] != null && provincias[i].TieneDeficitProvincia()){
               contador++;
            }
        }
        return contador;
    }
}
