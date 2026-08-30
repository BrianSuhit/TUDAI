public class Rectangulo {
    
    Punto_geométrico vertice1;
    // Punto_geométrico vertice2;

    double ancho;
    double alto;

    // public Rectangulo(Punto_geométrico v1, Punto_geométrico v2){
    //     this.vertice1 = v1;
    //     this.vertice2 = v2;
    // }

    public Rectangulo(Punto_geométrico v1, double anc, double alt){
        vertice1 = v1;
        ancho = anc;
        alto = alt;
    }

    public Rectangulo(Punto_geométrico v1, Punto_geométrico v2, Punto_geométrico v3, Punto_geométrico v4){
        double minX = Math.min(Math.min(v1.x, v2.x), Math.min(v3.x, v4.x));
        double maxX = Math.max(Math.max(v1.x, v2.x), Math.max(v3.x, v4.x));

        double minY = Math.min(Math.min(v1.y, v2.y), Math.min(v3.y, v4.y));
        double maxY = Math.max(Math.max(v1.y, v2.y), Math.max(v3.y, v4.y));
        
        this.ancho = maxX - minX;
        this.alto = maxY - minY;
        
        this.vertice1 = new Punto_geométrico();
        this.vertice1.x = minX;
        this.vertice1.y = minY;
    }

    public double CalcularArea(){
        // double ancho = vertice2.x - vertice1.x;
        // double alto = vertice2.y - vertice1.y;

        return ancho * alto;
    }

    public void Desplazar(double despX, double despY){
        vertice1.Desplazar(despX, despY);
        // vertice2.Desplazar(despX, despY);
    }

    public int CompararRectangulo(Rectangulo obj){
        double miArea = this.CalcularArea();

        double objArea = obj.CalcularArea();

        if(miArea > objArea){
            return 1;
        }else if(miArea == objArea){
            return 0;
        }else{
            return -1;
        }
    }

    public double GetAncho(){
        // return vertice2.x - vertice1.x;
        return ancho;
    }

    public double GetAlto(){
        // return vertice2.y - vertice1.y;
        return alto;
    }

    public boolean EsCuadrado(){
        return this.alto == this.ancho;
    }

    public double GetLargoSuperior(){
        return this.ancho;
    }

    public boolean EstaAcostado(){
        return this.alto > this.ancho;
    }
}
