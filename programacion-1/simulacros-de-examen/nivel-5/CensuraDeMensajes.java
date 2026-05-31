public class CensuraDeMensajes {
/*
Simulacro 4 NIVEL 5: Consigna: "Una red social procesa comentarios almacenándolos en un arreglo de caracteres (separados por espacios). Además, cuenta con un segundo arreglo llamado Patron (totalmente limpio, sin espacios) que contiene una palabra prohibida. Se pide hacer un programa que analice el comentario y elimine del arreglo original todas las palabras que coincidan exactamente con el patrón."*/
    public static final char SEPARADOR = ' ';

    public static void main(String[] args) {
        
        // Vagón 1: "hola" -> SE SALVA
        // Vagón 2: "malo" -> COINCIDE EXACTO -> SE BORRA
        // Vagón 3: "si"   -> SE SALVA
        // Vagón 4: "malo" -> COINCIDE EXACTO -> SE BORRA
        char[] texto = {' ', 'h', 'o', 'l', 'a', ' ', 'm', 'a', 'l', 'o', ' ', 's', 'i', ' ', 'm', 'a', 'l', 'o', ' ', ' '};
        
        // El patrón prohibido limpio:
        char[] patron = {'m', 'a', 'l', 'o'};

        System.out.println("Texto Original:");
        mostrarArreglo(texto);

        // --- TU LÓGICA DEL DIRECTOR ACÁ ---
        int ini = 0;
        int fin = -1;

        while(ini < texto.length){
            ini = buscarInicio(texto, fin + 1);

            if(ini < texto.length){
                fin = buscarFin(texto, ini);

                int tamaño = fin - ini + 1;

                if(cumplePatron(texto, ini, fin, patron)){
                    
                    for(int i = 0; i < tamaño; i++){
                        corrimientoIzquierda(texto, ini);
                    }
                    fin = fin - tamaño;
                }
            }
        }

        System.out.println("\nTexto Censurado:");
        mostrarArreglo(texto);
    }

    public static boolean cumplePatron(char[] arrA, int ini, int fin, char [] arrB){
        if(fin - ini + 1 != arrB.length){
            return false;
        }

        int i = ini;
        int j = 0;
        while(i <= fin && arrA[i] == arrB[j]){
            i++;
            j++;
        }
        return i > fin;
    }
    
    public static void corrimientoIzquierda(char[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i - 1];
        }
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
        return pos - 1;
    }

    public static void mostrarArreglo(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "|");
        }
    }
}
