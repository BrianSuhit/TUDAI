public class Mueble {
    private String tipo;
    private double peso;
    private double costoFabricacion;
    private String tipoMadera;
    private String color;

    public Mueble(String tipo, double peso, double costoFabricacion, String tipoMadera, String color){
        setTipo(tipo);
        setPeso(peso);
        setCostoFabricacion(costoFabricacion);
        setTipoMadera(tipoMadera);
        setColor(color);
    }

    public String getTipo(){
        return tipo;
    }

    public double getPeso(){
        return peso;
    }

    public double getCostoFabricacion(){
        return costoFabricacion;
    }

    public String getTipoMadera(){
        return tipoMadera;
    }

    public String getColor(){
        return color;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    public void setCostoFabricacion(double costoFabricacion){
        this.costoFabricacion = costoFabricacion;
    }

    public void setTipoMadera(String tipoMadera){
        this.tipoMadera = tipoMadera;
    }

    public void setColor(String color){
        this.color = color;
    }

    public double getPrecioVenta(){
        return costoFabricacion * 1.35;
    }

    public boolean equals(Object o1) {
    try {
        Mueble otro = (Mueble)o1;
        // Si coinciden el tipo, la madera y el color, asumimos que es el mismo mueble
        return otro.getTipo().equals(this.getTipo()) && 
               otro.getTipoMadera().equals(this.getTipoMadera()) && 
               otro.getColor().equals(this.getColor());
    } catch(Exception e) {
        return false;
    }
}
}
