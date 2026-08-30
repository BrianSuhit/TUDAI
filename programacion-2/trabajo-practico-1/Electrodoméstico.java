public class Electrodoméstico {
    
    String nombre;
    int precioBase = 100;
    String color = "Gris plata";
    int consumoE = 10;
    int peso = 2;

    public Electrodoméstico(){

    }

    public Electrodoméstico(String unNombre){
        nombre = unNombre;
    }

        public Electrodoméstico(String unNombre, int unPrecioBase, String unColor, int unConsumoE, int unPeso){
        nombre = unNombre;
        precioBase = unPrecioBase;
        color = unColor;
        consumoE = unConsumoE;
        peso = unPeso;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setPrecio(int precioBase){
        this.precioBase = precioBase;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setConsumo(int consumoE){
        this.consumoE = consumoE;
    }

    public void setPeso(int peso){
        this.peso = peso;
    }

    public String getNombre() {
    return nombre;
    }

    public int getPrecio() {
        return precioBase;
    }

    public String getColor() {
        return color;
    }

    public int getConsumo() {
        return consumoE;
    }

    public int getPeso() {
        return peso;
    }

    public boolean EsBajoConsumo(){
        int limite = 45;

        return consumoE < limite;
    }

    public int CalcularBalance(){
        return precioBase / peso;
    }

    public boolean EsGamaAlta(){
        int gamaAlta = 3;
        int balanceReal = CalcularBalance();

        return balanceReal > gamaAlta;        
    }
}
