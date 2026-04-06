public class Ejercicio13 {
/*
Dados los siguientes códigos, analizar y detectar los errores.
Justificar en cada caso.
*/
    public static void main(String[] args) {
        double altura=’a’; // las comillas no son de char
        boolean existe;
        existe = 34; // no se puede asignar un int a un boolean
        peso = 75.5; // le falta el tipo de dato
        System.out.println("El valor de " - "peso es: "); //no se puede "restar" dos strings
        System.out.println(peso); // le falta el tipo de dato

        //------------------------------------------------------

        final char letra=’a’; // las comillas estan mal
        int numero1, numero2;
        letra = ’f’; // no se puede asignar valor a una constante ya inicializada
        numero1=10+numero2; // num2 no esta inicializada, dara error

        System.out.println("El valor de numero1 es:" + numero1);
        System.out.println("El valor de numero2 es:" + numero2);

        //------------------------------------------------------

        // no tiene errores de sintaxis, solo de diseño
        int entero = Utils.leerInt();
        System.out.println ("Ingrese un entero: ");
        System.out.println ("Nro ingresado: " + entero);
    }
}
