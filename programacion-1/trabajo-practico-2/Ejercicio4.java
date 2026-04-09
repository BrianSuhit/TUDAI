public class Ejercicio4 {
/*
Escribir un programa donde el usuario ingrese un número entre 0
y 999, y muestre un mensaje de cuántos dígitos tiene. Además, si
tiene 3 dígitos debe informar qué número es.
*/
    public static void main(String[] args) {

        int numero = 0;

        System.out.println("ingrese un numero entre 0 y 999");
        numero = Utils.leerInt();

        if(numero >= 0 && numero < 10){
            System.out.println("el numero ingresa tiene un digito");
        }
        else if (numero >= 10 && numero < 100){
            System.out.println("el numero ingresa tiene dos digitos");
        }
        else if(numero >= 100 && numero <= 999){
            System.out.println("el numero ingresa tiene tres digitos y es: "+ numero);
        }
        else{
            System.out.println("error");
        }
    }
}
