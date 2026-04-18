public class Ejercicio9 {
/*
Escribir un método que retorne el mayor de dos números. Usar
ese método para calcular el máximo de una serie de números
ingresados por el usuario (20 números en total).
*/
    public static void main(String[] args) {
        
        final int CANTIDAD_NUMEROS = 20;
        
        int numIngresado = 0;
        int maximo = 0;

        devolverMayor(maximo, numIngresado);
        System.out.println("El número más grande de toda la serie fue: " + maximo);

        for(int i = 1; i <= CANTIDAD_NUMEROS; i++){

            System.out.println("Ingrese el número " + i + " de " + CANTIDAD_NUMEROS + ":");
            numIngresado = Utils.leerInt();

            if(i == 1){
                maximo = numIngresado;
            }
            else{
                maximo = devolverMayor(maximo, numIngresado);
            }
        }
        System.out.println("El número más grande de toda la serie fue: " + maximo);
    }

    public static int devolverMayor(int valor1, int valor2){

        if(valor1 > valor2){
            return valor1;
        }
        else
            return valor2;
    }
}
