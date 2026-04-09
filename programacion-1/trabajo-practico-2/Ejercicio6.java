public class Ejercicio6 {
/*
Escribir un programa que mientras el usuario ingrese un caracter
distinto del caracter ‘’, muestre por pantalla si es carácter dígito, o
si es carácter vocal minúscula. Cuando ingrese ‘*’ debe terminar.
*/
    public static void main(String[] args) {
        
        char caracter = '0';

        System.out.println("ingrese un caracter");
        caracter = Utils.leerChar();

        while(caracter != '*'){

            if((caracter >= '0') && (caracter <= '9')){
                System.out.println("es un caracter digito: " + caracter);
            }
            else if(caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u'){
                System.out.println("es un caracter vocal: " + caracter);
            }
            System.out.println("ingrese un caracter");
            caracter = Utils.leerChar();    
        }
    }
}
