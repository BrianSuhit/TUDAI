public class EncriptacionDeMensajes {
/*
6. Encriptación de mensajes
El servicio de inteligencia de una potencia mundial desea revitalizar su sistema de encriptación de mensajes
de texto. Cada texto que debe ser encriptado es almacenado en una matriz de caracteres de NxM, donde
cada fila representa un renglón del mensaje.
El texto puede contener cualquier tipo de carácter: letras, dígitos, caracteres especiales o de puntuación. El
sistema de encriptación sólo debe encriptar las palabras compuestas por letras (minúsculas o mayúsculas).
El mecanismo de encriptación elegido consiste en:

● Desplazar cada vocal tantas posiciones en el abecedario como caracteres tenga la palabra.
● Duplicar cada consonante.

Por ejemplo, dada la palabra “secreto”, cuya longitud es 7, debe ser encriptada como “sslccrrlttv”, dado que
las consonantes se duplicaron, la vocal ‘e’ se desplazó 7 posiciones pasando a ser una ‘l’ y la vocal ‘o’ pasó a
ser una ‘v’. Se pide implementar en Java un programa que encripte una matriz de caracteres de NxM e
informe la cantidad total de palabras encriptadas.
la cantidad de palabras encriptadas sería 7.
Asumir que siempre se tiene espacio suficiente para realizar las inserciones (si se pierden otros caracteres no
importa) y que cada fila de texto empieza y termina siempre con uno o más carácteres que no se
corresponden con una letra. Para desplazar un caracter n posiciones, puedo sumarle a un char la
cantidad de posiciones que quiero desplazarlo. char c = ‘a’; c = (char)(c + 5); // c pasa a almacenar ‘f’
*/
    public static void main(String[] args) {
        char[][] secreto = {
            {'-', 'S', 'u', 'p', 'e', 'r', '-', 's', 'e', 'c', 'r', 'e', 't', 'o', ':', '-', '-', '-', '-', '-', '-', '-'},
            {'¡', '¡', 'n', 'o', ' ', 'c', 'o', 'r', 't', 'a', 'r', ' ', 'f', 'o', 'r', '-', '-', '-', '-', '-', '-', '-'},
            {'-', 'c', 'o', 'n', ' ', 'r', 'e', 't', 'u', 'r', 'n', '!', '!', '!', '!', '!', '!', '!', '!', '!', '!', '!'}
        };

        procesarMatriz(secreto);
    }

    public static void procesarMatriz(char[][] mat){
        int totalEncriptaciones = 0;

        for(int fila = 0; fila < mat.length; fila++){

            totalEncriptaciones += procesarFila(mat[fila]);
        }

        System.out.println("cantidad de palabras encriptadas: " + totalEncriptaciones);
    }

    public static int procesarFila(char[] fila){
        int ini = 0, fin = -1, cantidadEncriptaciones = 0;

        while(ini < fila.length){
            ini = buscarInicio(fila, fin + 1);

            if(ini < fila.length){
                fin = buscarFin(fila, ini);

                fin = encriptarMensaje(fila, ini, fin);
                cantidadEncriptaciones++;
            }
        }
        return cantidadEncriptaciones;
    }

    public static int encriptarMensaje(char[] arr, int ini, int fin){
        int tam = fin - ini + 1;

        int i = ini;
        while(i <= fin){
            if(esVocal(arr[i])){
                arr[i] = (char)(arr[i] + tam);
            }else{
                corrimientoDerecha(arr, i);
                fin++;
                i++;
            }
            i++;
        }
        return fin;
    }

    public static void corrimientoDerecha(char[] arr, int pos){
        for(int i = arr.length - 1; i > pos; i--){
            arr[i] = arr[i - 1];
        }
    }

    public static boolean esVocal(char letra){
        return letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u' || letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U' ;
    }

    public static int buscarInicio(char[] arr, int pos){
        while(pos < arr.length && !esCaracterLetra(arr[pos])){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(char[] arr, int pos){
        while(pos < arr.length && esCaracterLetra(arr[pos])){
            pos++;
        }
        return pos -1;
    }

    public static boolean esCaracterLetra(char letra){
        return letra >='A' && letra <= 'Z' || letra >= 'a' && letra <= 'z'; 
    }
}
