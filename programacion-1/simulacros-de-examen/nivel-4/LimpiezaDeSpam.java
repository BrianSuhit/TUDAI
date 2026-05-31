public class LimpiezaDeSpam {
/*
📝 SIMULACRO NIVEL 4: "Limpieza de Spam"
El Dominio Real: El servidor de correos de la universidad guarda los IDs de los mensajes en un arreglo de secuencias separadas por ceros (0). El equipo de ciberseguridad detectó que un virus está inyectando correos basura (Spam). Descubrieron un patrón muy simple: todos los correos Spam son secuencias que tienen exactamente un tamaño de N elementos.
La Consigna: Escribir un programa que recorra el arreglo y, si encuentra una secuencia cuyo tamaño sea exactamente igual a TAMANIO_SPAM (por ejemplo, 2), debe eliminar la secuencia completa del arreglo.
*/
    public static final int SEPARADOR = 0;
    public static final int TAMANIO_SPAM = 2;

    public static void main(String[] args) {
        
        int[] arrCorreos = {0, 15, 22, 19, 0, 88, 99, 0, 14, 12, 10, 0, 44, 55, 0, 0};

        int ini = 0;
        int fin = -1;

        while(ini < arrCorreos.length){
            ini = buscarInicio(arrCorreos, fin + 1);

            if(ini < arrCorreos.length){
                fin = buscarFin(arrCorreos, ini);

                int tamanio = fin - ini +1;

                if(tamanio == TAMANIO_SPAM){

                    for(int i = 0; i < tamanio; i++){
                        corrimientoIzquierda(arrCorreos, ini);
                    }
                    
                    fin = fin - tamanio;
                }
            }
        }
    }

    public static int buscarInicio(int[] arr, int pos){
        while( pos < arr.length && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos){
        while( pos < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos -1;
    }

    public static void corrimientoIzquierda(int[] arr, int pos){
        for( int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
    }
}
