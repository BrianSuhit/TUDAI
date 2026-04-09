public class Ejercicio7 {
/*
Escribir un programa que mientras que el usuario ingrese un
caracter dígito o caracter letra minúscula, imprima si es dígito o
letra minúscula, y si es letra minúscula imprimir si es vocal o
consonante.
*/
    public static void main(String[] args) {
        
        char caracter = '0';

        System.out.println("ingrese un caracter");
        caracter = Utils.leerChar();

        while(((caracter >= '0') && (caracter <= '9')) || ((caracter >= 'a') && (caracter <= 'z'))){
            
            if((caracter >= '0') && (caracter <= '9'))
            {
                System.out.println("es un caracter digito: " + caracter);
            }
            
            if((caracter >= 'a') && (caracter <= 'z'))
            {
                if(caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u'){
                System.out.println("ingreso la vocal: " + caracter);
                }
            }
            else
            {
                System.out.println("ingreso la consonante: " + caracter);
            }
            
            System.out.println("ingrese un caracter");
            caracter = Utils.leerChar();
        }
    }
}
