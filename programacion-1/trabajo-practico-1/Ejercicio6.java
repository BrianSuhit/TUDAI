public class Ejercicio6 {
/* 
Escribir un programa que permita el ingreso de un número entero
por teclado e imprima el cociente de la división de dicho número
por 2, 3, y 4. En base a los resultados obtenidos analice cada
caso si es correcto o no.
*/
    public static void main(String[] args) {
        
        int numero = 0;
        
        double cocientePor2 = 0;
        double cocientePor3 = 0;
        double cocientePor4 = 0;

        System.out.println("Ingrese un numero entero");
        numero = Utils.leerInt();

        cocientePor2 = (double)numero / 2;
        cocientePor3 = (double)numero / 3;
        cocientePor4 = (double)numero / 4;

        System.out.println("El cociente por 2 es: " + cocientePor2);
        System.out.println("El cociente por 3 es: " + cocientePor3);
        System.out.println("El cociente por 4 es: " + cocientePor4);
        
    }
/* 
si no hago la conversion a double java va a cortar los decimales
NO REDONDEA, LOS CORTA, por consiguiente el resultado es inexacto.
*/
}
