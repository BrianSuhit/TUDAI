public class Ejercicio7 {
/*
Escribir un programa que permita el ingreso de dos números
enteros por teclado e imprima:
a. si el primero es mayor al segundo.
b. si ambos son múltiplos de 2.
*/
    public static void main(String[] args) {
        
        int numero1 = 0;
        int numero2 = 0;

        boolean condicicionA = false;
        boolean condicicionB = false;

        System.out.print("Ingrese el primer numer");
        numero1 = Utils.leerInt();

        System.out.print("Ingrese el segundo numero");
        numero2 = Utils.leerInt();

        condicicionA = numero1 > numero2;

        condicicionB = (numero1 % 2 == 0) && (numero2 % 2 == 0);

        System.out.println("La condicion A es: " + condicicionA);
        System.out.println("La condicion B es: " + condicicionB);
    }
}
