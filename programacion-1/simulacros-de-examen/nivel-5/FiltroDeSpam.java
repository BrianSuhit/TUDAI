public class FiltroDeSpam{
/*
Simulacro 2 - "Filtro de Spam" (Nivel 5)
El Dominio (Consigna Oficial): Un sistema de mensajería codifica los textos de sus usuarios almacenándolos en un arreglo de enteros de tamaño MAX. Cada palabra se representa como una secuencia de números positivos, y las palabras están separadas entre sí por uno o más ceros (0).
El equipo de ciberseguridad descubrió un patrón: los bots de spam siempre camuflan al menos un número par (múltiplo de 2) adentro de las palabras que generan [cite: 343].
Se pide realizar un programa en Java que analice el arreglo y elimine por completo todas las secuencias (palabras) que contengan al menos un número múltiplo de 2. Se deben respetar las buenas prácticas de la cátedra: uso de procedimientos para la modificación del arreglo, banderas booleanas para la evaluación del filtro y el ajuste estricto del tamaño del vagón en el bloque principal.

*/
    public static final int SEPARADOR = 0;
    public static void main(String[] args) {

        int[] arreglo = {0, 12, 45, 0, 8, 0, 33, 14, 55, 0, 9, 10, 0, 0, 0, 0, 0, 0, 0, 0};
        int ini = 0;
        int fin = -1;

        while(ini < arreglo.length){
            ini = buscarInicio(arreglo, fin + 1);

            if(ini < arreglo.length){
                fin = buscarFin(arreglo, ini);

                int tamaño = fin - ini + 1;

                if(esMultiplo(arreglo, ini, fin)){
                    for(int i = 0; i < tamaño;i++){
                        corrimientoIzquierda(arreglo, ini);
                    }
                    fin = fin - tamaño;
                }
            }
        }
    }

    public static boolean esMultiplo(int[] arr, int ini, int fin){
        int i = ini;
        boolean loEncontre = false;

        while(i <= fin && !loEncontre){
            if(arr[i] % 2 == 0){
                loEncontre = true;
            }
            i++;
        }
        return loEncontre;
    }

    public static void corrimientoIzquierda(int[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
    }

    public static int buscarInicio(int[] arr, int pos){
        while(pos < arr.length && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos){
        while(pos  < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos - 1;
    }
}