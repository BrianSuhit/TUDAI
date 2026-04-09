public class Ejercicio9 {
/*
Escribir un programa que mientras el usuario ingrese un caracter
letra minúscula, acumule la cantidad de vocales que ingresó.
Finalmente muestre por pantalla dicha cantidad.
*/
    public static void main(String[] args) {
        
        char caracter = '0';
        int suma = 0;

        final char MIN = 'a';
        final char MAX = 'z';

        System.out.println("ingrese un caracter en minuscula");
        caracter = Utils.leerChar();

        while ((caracter >= MIN) && (caracter <= MAX)) {
            
            if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
                
                suma++;
            }

            System.out.println("ingrese un caracter en minuscula");
            caracter = Utils.leerChar(); 
        }
         System.out.println("la suma total de las vocales es: " + suma);
    }
}
