public class Ejercicio2 {
/*
Escribir un diseño de programa que mientras que el usuario
ingrese un carácter dígito o carácter letra minúscula, imprima
dicho carácter, y si es carácter letra minúscula, imprima si es vocal
o consonante.
*/
    public static void main(String[] args) {
        
        char caracter = obtenerCaracterValido();

        while(esDigitoOLetra(caracter)){

            if (caracter >= 'a' && caracter <= 'z') {
                imprimirTipoCaracter(caracter);
            }

            caracter = obtenerCaracterValido();
        }
        System.out.println("Fin del programa. Ingresó un caracter inválido.");
    }

    public static char obtenerCaracterValido(){
        System.out.println("Ingrese un caracter");
        char caracter = Utils.leerChar();
        return caracter;
    }

    public static boolean esDigitoOLetra(char caracter){
        return ((caracter >= '0' && caracter <= '9') || (caracter >= 'a' && caracter <= 'z'));
    }


    public static void imprimirTipoCaracter(char caracter){

        if(caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u'){
                System.out.println("Es una vocal");
        }
        else
            System.out.println("es una consonante"); 
    }
}