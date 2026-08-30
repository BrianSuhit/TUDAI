public class Punto_geométrico {
    
    double x = 0;
    double y = 0;

    public void Desplazar(double incrementoX, double incrementoY){
        x += incrementoX;
        y += incrementoY;
    }

    public double DistanciaEuclidea(Punto_geométrico otroObjeto){
        double difX = this.x - otroObjeto.x;
        double difY = this.y - otroObjeto.y;

        double sumaCuadrados = (difX * difX) + (difY * difY);

        return Math.sqrt(sumaCuadrados); 
    }
}
