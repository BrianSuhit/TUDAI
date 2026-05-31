public class FiltroRed {
/*
📝 SIMULACRO REAL: Cuarentena de Paquetes de Red
Dominio: El firewall de un servidor registra los paquetes de red entrantes en un arreglo trafico de tamaño MAX. Cada paquete es una secuencia de números enteros positivos (los bytes del paquete), separada por ceros (0). El sistema de ciberseguridad determinó que los ataques de denegación de servicio (DDoS) envían paquetes inusualmente grandes.
Consigna: Se pide crear un método Director que reciba el arreglo trafico y un umbral entero. El método debe:
Recorrer el arreglo buscando los paquetes (secuencias) cuyo tamaño sea estrictamente mayor al umbral.
Si encuentra un paquete sospechoso, debe copiar toda la secuencia de forma continua en un nuevo arreglo llamado cuarentena.
¡OJO! Las secuencias en el arreglo cuarentena también deben quedar separadas por un 0 para no romper la estructura [cite: 467].
Retornar el arreglo cuarentena al main.
*/
    public static final int SEPARADOR = 0;
    public static void main(String[] args) {
        // En este ejemplo, el umbral es 3.
        // El único paquete sospechoso (tamaño > 3) es {8, 9, 14, 5}
        int[] trafico = {0, 15, 22, 0, 8, 9, 14, 5, 0, 11, 0, 0};
        int umbral = 3; 

        int[] paqueteSospechoso = procesarSecuencia(trafico, umbral);

        mostrarArreglo(paqueteSospechoso);
    }

    // TUS MÉTODOS ACÁ (Director, Buscadores, Copiador...)
    public static int[] procesarSecuencia(int[] arr, int valor){
        int ini = 0;
        int fin = -1;

        int indexNuevo = 0;
        int[] arregloB = new int[arr.length];

        while(ini < arr.length){
            ini = buscarInicio(arr, fin + 1);

            if(ini < arr.length){
                fin = buscarFin(arr, ini);

                int tamaño = fin - ini + 1;

                if(tamaño > valor){
                    indexNuevo = copiarSecuencia(arr, ini, fin, arregloB, indexNuevo);
                }
            }
        }
        return arregloB;
    }

    public static int copiarSecuencia(int[] arr, int ini, int fin,  int[] nuevo, int indexNuevo){
        for(int i = ini; i <= fin; i++){ 
            nuevo[indexNuevo] = arr[i];
            indexNuevo++;
        }

        nuevo[indexNuevo] = SEPARADOR;
        indexNuevo++;

        return indexNuevo;
    }

    public static int buscarInicio(int[] arr, int pos){
        while(pos < arr.length && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int ini){
        while(ini < arr.length && arr[ini] != SEPARADOR){
            ini++;
        }
        return ini - 1;
    }

    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }
}
