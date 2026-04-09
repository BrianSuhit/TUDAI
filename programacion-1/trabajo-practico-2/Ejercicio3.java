public class Ejercicio3 {
/*
Escribir un programa que solicite el ingreso de un número mayor a
50, y lo muestre por pantalla en caso de ser múltiplo de 2 o 3, sino
muestre un mensaje que informe dicha situación.
*/
    public static void main(String[] args) {
        
        int numero = 0;

        System.out.println("Ingrese un numero mayor a 50");
        numero = Utils.leerInt();

        if((numero > 50) && ((numero % 2 == 0) || (numero % 3 ==0))){
            System.out.println("su numero ingresado es: " + numero);
        }
        else{
            System.out.println("error");
        }
    }
}
