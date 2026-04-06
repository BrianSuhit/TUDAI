public class Ejercicio8 {
/*
Escribir un programa que permita el ingreso de un número entero
por teclado e imprima el resultado de determinar:
a. si es múltiplo de 6 y de 7,
b. si es mayor a 30 y múltiplo de 2, o es menor igual a 30,
c. si el cociente de la división de dicho número por 5 es mayor
que 10.
*/
    public static void main(String[] args) {
        
        int numero = 0;

        boolean condicionA = false;
        boolean condicionB = false;
        boolean condicionC = false;

        System.out.print("Ingrese un numero entero");
        numero = Utils.leerInt();

        condicionA = ((numero % 6 == 0) && (numero % 7 == 0));
        condicionB = (((numero > 30) && (numero % 2 == 0)) || (numero <= 30));
        condicionC = (numero / 5) > 10;

        System.out.println("La condicion A es: " + condicionA);
        System.out.println("La condicion B es: " + condicionB);
        System.out.println("La condicion C es: " + condicionC);
    }
}
