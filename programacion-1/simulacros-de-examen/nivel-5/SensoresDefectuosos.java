public class SensoresDefectuosos {
/*
Simulacro 3 - "Sensores Defectuosos" (Nivel 5)
El Dominio (Consigna Oficial): Un dron de exploración registra sus altitudes de vuelo en un arreglo de enteros. Cada lectura de vuelo se guarda como una secuencia de valores positivos, separadas entre sí por ceros (0).
Los técnicos de la reserva notaron que el altímetro a veces sufre un cortocircuito. Cuando esto pasa, la lectura de los datos cae en picada, registrando valores que están en orden estrictamente descendente (por ejemplo: | 80 | 50 | 20 | 5 |).
Basado en el Ejercicio 31 de la Práctica 5, se pide realizar un programa en Java que analice el registro del dron y elimine por completo todas las secuencias (lecturas) que tengan orden descendente entre sus elementos [cite: 377].
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

                if(esAscendente(arreglo, ini, fin)){

                    for(int i = 0; i < tamaño; i++){
                        corriminetoIzquierda(arreglo, ini);
                    }
                    fin = fin - tamaño;
                }
            }
        }

    }

    public static boolean esAscendente(int[] arr, int ini, int fin){
        int i = ini;

        while(i < fin && arr[i] > arr[i + 1]){
            i++;
        }
        return i == fin;
    }

    public static void corriminetoIzquierda(int[] arr, int pos){
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
        while(pos <  arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos - 1;
    }
}
