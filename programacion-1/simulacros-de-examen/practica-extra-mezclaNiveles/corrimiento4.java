public class corrimiento4 {
/*
Nivel 4: El "Jefe Final" Simplificado (Secuencias + Doble Arreglo + Agrandar)
El objetivo: Esta es la lógica central del Ejercicio 4 del supermercado y el Parcial 2025
, pero sin texto confuso.
Consigna: Tenés un arreglo principal de secuencias (separadas por 0) y un arreglo pequeño llamado claves. Si una secuencia tiene ADENTRO algún número que exista en el arreglo claves, tenés que insertar un 99 al final de esa secuencia.
Arreglo Principal: {0, 4, 8, 0, 1, 5, 0, 0}
Arreglo Claves: {8, 7}
Resultado esperado: {0, 4, 8, 99, 0, 1, 5, 0} (Al primer vagón se le agregó el 99 porque contenía un 8. Al segundo no, porque ni el 1 ni el 5 están en las claves).
Pista:
Motor principal para aislar el vagón.
Recorrer el vagón viendo si sus números están en el arreglo claves.
Si es verdadero, llamás a corrimientoDerecha(arr, fin + 1) para abrir el hueco al final de la secuencia.
Insertás el 99.
Ajuste: fin = fin + 1
.
*/
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        int[] arreglo = {0, 4, 8, 0, 1, 5, 0, 0};

        int[] claves = {8, 7};

        int ini = 0;
        int fin = -1;
        int numAInsertar = 99;


        while(ini < arreglo.length){
            ini = buscarInicio(arreglo, fin + 1);

            if(ini < arreglo.length){
                fin = buscarFin(arreglo, ini);

                if(tieneAlgunaClave(arreglo, claves, ini, fin)){
                    corrimientoDerecha(arreglo, fin + 1);
                    arreglo[fin + 1] = numAInsertar;
                    fin = fin + 1;
                }
            }
        }
        mostrarArreglo(arreglo);

    }

    public static void corrimientoDerecha(int[] arr, int pos){
        for(int i = arr.length - 2; i >= pos; i--){
            arr[i + 1] = arr[i];
        }
    }

    public static boolean tieneAlgunaClave(int[] arreglo, int[] claves, int ini, int fin) {
        
        // Avanzo MIENTRAS no me caiga del vagón Y MIENTRAS el número actual NO exista en las claves
        while (ini <= fin && !existeEnArreglo(claves, arreglo[ini])) {
            ini++;
        }
        
        // Si el while se frenó antes de caerse del vagón (ini <= fin), 
        // significa que el !existeEnArreglo dio falso (es decir, ¡SÍ LO ENCONTRÓ!).
        return ini <= fin; 
    }

    // Búsqueda simple en arreglo (¡De tu apunte de la teoría!)
    public static boolean existeEnArreglo(int[] arr, int valor){
        int pos = 0;
        while(pos < arr.length && arr[pos] != valor){
            pos++;
        }
        return pos < arr.length; // Si no se cayó, es porque lo encontró
    }

    public static int buscarInicio(int[] arr, int ini) {
        while (ini<arr.length && arr[ini]== SEPARADOR)
        ini++;
        return ini;
    }

    public static int buscarFin(int[] arr, int ini) {
        while (ini<arr.length && arr[ini]!=SEPARADOR)
        ini++;
        return ini-1;
    }

    public static void mostrarArreglo(int[] arr){
        for (int pos = 0; pos < arr.length; pos++){
        System.out.println("arrenteros["+pos+"] -> "+arr[pos]);
        }
    }
}
