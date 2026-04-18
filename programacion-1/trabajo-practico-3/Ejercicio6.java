public class Ejercicio6 {
/*
Escribir un programa que solicite al usuario una letra minúscula, y
si la letra es una vocal, llame a un método que imprima por
pantalla la tabla de multiplicar del 9. Si la letra ingresada es una
consonante, imprima la tabla de multiplicar del 7.

*/
    public static final int MULTIPLICADOR_9 = 9;
    public static final int MULTIPLICADOR_7 = 7;

    public static void main(String[] args) {

        System.out.println("ingrese una letra");
        char letra = Utils.leerChar();

        if(esVocal(letra)){
            imprimirTablaDel9();
        }
        else if(esConsonante(letra)){

            System.out.println("tabla de multiplicar del 7:");
            for(int i = 1; i <= 10; i++){
                System.out.println(MULTIPLICADOR_7 + " x " + i + " = " + i * MULTIPLICADOR_7);
            }
        }
        else{
            System.out.println("Error: El caracter ingresado no es una letra válida.");
        }

        /* ERRORES DE RAZONAMIENTO
            1. no preguntarme como asegurarme de que efectivamente sea una consonante
            2. no interpretar que en esta unidad lo que pueda convertir en metodo lo hago
            3. no cortar un programa de la nada, el else debe retornar un error siempre
        */
    }

    public static void imprimirTablaDel9(){
        System.out.println("tabla de multiplicar del 9:");
            for(int i = 1; i <= 10; i++){
                System.out.println(MULTIPLICADOR_9 + " x " + i + " = " + i * MULTIPLICADOR_9);
            }
    }

    public static boolean esVocal(char c){

        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    public static boolean esConsonante(char c){
        return (c >= 'a' && c <= 'z' && !esVocal(c));
    }
}
