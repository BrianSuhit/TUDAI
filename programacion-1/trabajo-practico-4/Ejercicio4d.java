public class Ejercicio4d {
/*
d. public static int buscarMayor(int a, int b, int c) {
// retorna el mayor de los 3 números
int mayor = a;
if (b > mayor) {
mayor = b;
}
if (c > mayor) {
mayor = c;
}
return mayor;
}
*/
    // ejercicio sin errores
    
    public static void main(String[] args) {
        
        System.out.println(buscarMayor(5, 5, 3 ));
    }

    public static int buscarMayor(int a, int b, int c) {
        // retorna el mayor de los 3 números
        int mayor = a;
        if (b > mayor) {
        mayor = b;
        }
        if (c > mayor) {
        mayor = c;
        }
        return mayor;
    }
}