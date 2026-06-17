public class EncriptacionDeDocumentos {
/*
3. Encriptación de documentos
El servicio de inteligencia secreto MD5 desea implementar un sistema de encriptación de documentos
ultrasecretos. Dichos documentos son almacenados en matrices de caracteres en donde cada fila representa
un renglón del mismo. Todos los renglones tienen M caracteres y comienzan y terminan con uno o más
espacios.
Se desea principalmente encriptar los nombres propios (comienzan con mayúscula) que aparezcan en el
documento, ya que seguramente harán referencia a información sensible como ciudades, espías propios o
agentes enemigos. El mecanismo de encriptación consiste en realizar una simple inversión de los caracteres
y la duplicación de las vocales minúsculas sólo de los nombres propios (secuencias) presentes en el
documento. Se pide (a) implementar el mecanismo de encriptación antes descrito sobre una matriz de NxM e
(b) informar, al finalizar la ejecución del mismo, la cantidad de secuencias encriptadas.
Puede asumir que hay espacio suficiente para incorporar los caracteres que deba.
*/
    public static final char SEPARADOR = ' ';
    public static void main(String[] args) {

        char[][] matriz = {
            {' ', 'P', 'a', 'b', 'l', 'o', ' ', 'c', 'o', 'm', 'e', ' ', 'p', 'a', 'n', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', 'E', 'l', ' ', 'a', 'g', 'e', 'n', 't', 'e', ' ', 'J', 'a', 'm', 'e', 's', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', 'v', 'i', 'a', 'j', 'a', ' ', 'a', ' ', 'C', 'o', 'l', 'o', 'n', 'i', 'a', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };
        
        imprimirMatriz(matriz);
        int contadorTotal = procesarMatriz(matriz);
        System.out.println("la cantidad de secuencias encriptadas fue: " + contadorTotal);
        imprimirMatriz(matriz);
    }

    public static int procesarMatriz(char[][] matriz){
        int contadorEncriptadas = 0;
        for(int fila = 0; fila < matriz.length; fila++){
            contadorEncriptadas += procesarFila(matriz[fila]);
        }
        return contadorEncriptadas;
    }

    public static int procesarFila(char[] arr){
        int ini = 0, fin = -1, secuencienciasEncriptadas = 0;

        while(ini < arr.length){
            ini = buscarInicio(arr, fin + 1);

            if(ini < arr.length){
                fin = buscarFin(arr, ini);

                if(esPrimeraMayus(arr[ini])){
                    invertirSecuencia(arr, ini, fin);

                   fin = duplicarVocal(arr, ini, fin);
                   secuencienciasEncriptadas++;
                }
            }
        }
        return secuencienciasEncriptadas;
    }

    public static int duplicarVocal(char[] arr, int ini, int fin){
        int i = ini;
        while(i <= fin){
            if(esVocalMinuscula(arr[i])){
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

    public static void invertirSecuencia(char[] arr, int ini, int fin){
        int izq = ini, der = fin;

        while(izq < der){
            char aux = arr[izq];
            arr[izq] = arr[der];
            arr[der] = aux;
            izq++;
            der--;
        }
    }

    public static boolean esVocalMinuscula(char letra) {
        return (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u');
    }

    public static boolean esPrimeraMayus(char letra){
        return (letra >= 'A' && letra <= 'Z');
    }

    public static int buscarInicio(char[] arr, int pos){
        while(pos < arr.length && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(char[] arr, int pos){
        while(pos < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos -1;
    }

    public static void imprimirMatriz(char[][] mat) {
        for (int fila = 0; fila < mat.length; fila++) {
            System.out.print("|");
            for (int col = 0; col < mat[fila].length; col++) {
                System.out.print(mat[fila][col] + "|");
            }
            System.out.println();
        }
    }
}
