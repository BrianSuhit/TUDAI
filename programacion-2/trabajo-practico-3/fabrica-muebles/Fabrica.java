import java.util.ArrayList;

public class Fabrica{
    ArrayList<Mueble> stock;

    public Fabrica(){
        this.stock = new ArrayList<Mueble>();
    }

    public void agregarStock(Mueble nuevoMueble){
        if(!stock.contains(nuevoMueble)){
            stock.add(nuevoMueble);
        }
    }

    public double costoTotalFabricacion(){
        double suma = 0.0;
        for(int i = 0; i < stock.size(); i++){
            suma+= stock.get(i).getCostoFabricacion();
        }
        return suma;
    }

    public double precioVentaTotal(){
        double suma = 0.0;
        for(int i = 0; i < stock.size(); i++){
            suma+= stock.get(i).getPrecioVenta();
        }
        return suma;
    }
}