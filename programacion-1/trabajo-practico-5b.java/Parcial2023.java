public class Parcial2023 {
/*
Misión 8 - Parcial 2023: "Compresión de Imagen"
El Dominio (Consigna Pura): Una imagen está compuesta por píxeles en un arreglo de enteros. El color negro se representa con el valor 0 y funciona como separador. Se debe comprimir la imagen buscando secuencias que cumplan dos condiciones simultáneas [cite: 360, 393]:
Que tengan un tamaño estrictamente mayor a X (donde X es una constante, por ejemplo 3).
Que todos los píxeles de esa secuencia sean exactamente iguales (ej: 67 | 67 | 67 | 67 | 67).
La Compresión (La Acción): Si la secuencia cumple el filtro, se debe comprimir dejando solo 2 casilleros [cite: 360, 393]:
El primer casillero de la secuencia pasa a tener el valor negativo de la cantidad de ocurrencias (el tamaño). Ej: -5.
El segundo casillero mantiene el valor del píxel que se repite (ej: 67).
Todo el resto de la secuencia desaparece (se tritura) [cite: 360, 443].
*/
    public static final int SEPARADOR = 0;
    public static final int X = 3;

    public static void main(String[] args) {

        int[] imagen = {0, 67, 67, 67, 67, 67, 67, 67, 67, 0, 14, 0, 33, 33, 33, 33, 0, 5, 98, 0};

        System.out.println("Imagen Original:");
        mostrarArreglo(imagen);

        int ini = 0;
        int fin = -1;

        while(ini < imagen.length){
            ini = buscarInicio(imagen, fin + 1);

            if(ini < imagen.length){
                fin = buscarFin(imagen, ini);

                int tamaño = fin - ini + 1;

                if(tamaño > X && sonTodosIguales(imagen, ini, fin)){

                    imagen[ini] = tamaño * -1;
                    int basura = tamaño - 2;

                    for(int i = 0; i < basura; i++){
                        corrimientoIzquierda(imagen, ini + 2);
                    }
                    fin = fin - basura;
                }
            }
        }

        System.out.println("\nImagen Comprimida:");
        mostrarArreglo(imagen);
    }
    
    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "|");
        }
    }

    public static boolean sonTodosIguales(int[] arr, int ini, int fin){
        while(ini < fin && arr[ini] == arr[ini + 1]){
            ini++;
        }
        return ini == fin;
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
        while(pos < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos - 1;
    }
}
