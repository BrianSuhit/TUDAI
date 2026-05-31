public class Ejercicio15 {
/*
15. Dado un arreglo de caracteres, hacer un programa que
implemente métodos tal que devuelva al main dos arreglos: un
arreglo con los caracteres que son letras vocales y otro con los
que son consonantes.
*/
    public static void main(String[] args) {
        
        char[] arreglo = {'a', 'b', '3', 'e', 'z', 'i', '!', 'o', 'p', 'u', 'g'};

        char[] arregloVocales = new char[arreglo.length];

        char[] arregloConsonantes = new char[arreglo.length];

        clasificador(arreglo, arregloVocales, arregloConsonantes);

        System.out.print("Vocales encontradas: ");
        mostrarArreglo(arregloVocales);

        System.out.print("Consonantes encontradas: ");
        mostrarArreglo(arregloConsonantes);
    }

    public static void clasificador(char[] arreglo, char[] arregloVocales, char[] arregloConsonantes){
        int contadorVocal = 0;
        int contadorConsonante = 0;
        int pos = 0;

        for(pos = 0; pos < arreglo.length; pos++){
            
            if(esVocal(arreglo[pos])){
                arregloVocales[contadorVocal] = arreglo[pos];
                contadorVocal++;
            }
            else if(esConsonante(arreglo[pos])){
                arregloConsonantes[contadorConsonante] = arreglo[pos];
                contadorConsonante++;
            }
        }
    }

    public static boolean esVocal(char caracter){
        return (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u');
    }

    public static boolean esConsonante(char caracter){
        return (!esVocal(caracter) && (caracter >= 'a' && caracter <= 'z'));
    }

    public static void mostrarArreglo(char[] arrenteros){
        for (int pos = 0; pos < arrenteros.length; pos++){
        System.out.println("arrenteros["+pos+"] -> "+arrenteros[pos]);
        }
    }
}
