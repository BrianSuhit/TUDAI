public class Ejercicio16 {
/*
16. Dado un arreglo de caracteres, hacer un programa que
implemente métodos tal que devuelva al main: un arreglo con las
posiciones de los caracteres que son letras vocales y otro con las
posiciones que son consonantes.
*/
    public static void main(String[] args) {
        
        char[] arreglo = {'a', 'b', '3', 'e', 'z', 'i', '!', 'o', 'p', 'u', 'g'};

        int[] arregloVocales = new int[arreglo.length];

        int[] arregloConsonantes = new int[arreglo.length];

        clasificadorPos(arreglo, arregloVocales, arregloConsonantes);

        System.out.print("Vocales encontradas: ");
        mostrarArreglo(arregloVocales);

        System.out.print("Consonantes encontradas: ");
        mostrarArreglo(arregloConsonantes);
    }

    public static void clasificadorPos(char[] arreglo, int[] arregloVocales, int[] arregloConsonantes){
        int contadorPosVocal = 0;
        int contadorPosConsonante = 0;
        int pos = 0;

        for(pos = 0; pos < arreglo.length; pos++){
            


            if(esVocal(arreglo[pos])){
                arregloVocales[contadorPosVocal] = pos;
                contadorPosVocal++;
            }
            else if(esConsonante(arreglo[pos])){
                arregloConsonantes[contadorPosConsonante] = pos;
                contadorPosConsonante++;
            }
        }
    }

    public static boolean esVocal(char caracter){
        return (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u');
    }

    public static boolean esConsonante(char caracter){
        return (!esVocal(caracter) && (caracter >= 'a' && caracter <= 'z'));
    }

    public static void mostrarArreglo(int[] arrenteros){
        for (int pos = 0; pos < arrenteros.length; pos++){
        System.out.println("arrenteros["+pos+"] -> "+arrenteros[pos]);
        }
    }
}
