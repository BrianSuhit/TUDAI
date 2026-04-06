public class Ejercicio3 {
/*
 * Escribir un programa que declare una constante de tipo int y pida el
 * ingreso de un valor por teclado (hacer uso de Utils.java). 
 * Luego muestre el valor ingresado.
 * ¿Qué pasa en este caso? ¿Se puede o surge algún problema?
 */
    public static void main(String[] args) {
        
        final int CONSTANTE;

        System.out.println("ingrese un numero entero");
        CONSTANTE = Utils.leerInt();

        System.out.println("el valor de la constante es: " + CONSTANTE);
    }
/*
El unico problema surgiria si la constante ya hubiera sido inicializada
como no tiene ningun valor se le puede asignar uno por consola.
*/
}
