public class ControlAduanero {
/*
Sistema de Control Aduanero (Extracción y Eliminación Cruzada)
La Aduana Nacional registra los productos de los contenedores marítimos que ingresan al país. Estos registros se almacenan en un arreglo A de tamaño MAXA. Cada contenedor es una secuencia de números enteros (códigos de producto) separada por uno o más ceros. El arreglo siempre empieza y termina con uno o más ceros.
Por otro lado, la Interpol envía diariamente una lista con cargamentos reportados como contrabando. Estos cargamentos se almacenan en un arreglo B de tamaño MAXB, también compuestos por secuencias separadas por uno o más ceros. El arreglo B puede contener múltiples secuencias [cite: 413, 442].
Se pide implementar un programa en Java que recorra los contenedores del arreglo A. Por cada contenedor, se debe verificar si la secuencia de productos coincide exactamente con ALGUNA de las secuencias de contrabando almacenadas en el arreglo B [cite: 505].
Si coincide (es contrabando): El contenedor debe ser eliminado por completo del arreglo A (corrimiento a izquierda) [cite: 507]. Al mismo tiempo, esa secuencia de productos debe ser copiada en un arreglo C de tamaño MAXC (que arranca inicializado con ceros). Las secuencias copiadas en C deben guardarse de forma continua, separadas únicamente por un (1) cero entre contenedor y contenedor [cite: 413]. Además, se debe imprimir por consola: "Contenedor ilegal confiscado".
Si no coincide (es legal): La secuencia se deja intacta en el arreglo A.
Un ejemplo de arreglo principal A puede ser (MAXA = 22): {0, 0, 15, 22, 0, 8, 9, 0, 0, 4, 7, 11, 0, 15, 22, 0, 0, 0, 0, 0, 0, 0}
Un ejemplo de arreglo de contrabando B (MAXB = 15): {0, 4, 7, 11, 0, 0, 99, 1, 0, 15, 22, 0, 0, 0, 0}
(Nota: El contenedor {15, 22} y el contenedor {4, 7, 11} son contrabando porque existen íntegramente dentro del arreglo B).
Para este caso, los arreglos resultantes quedarían de la siguiente forma: Arreglo A: {0, 0, 8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0} Arreglo C: {0, 15, 22, 0, 4, 7, 11, 0, 15, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
Por consola se debió imprimir: Contenedor ilegal confiscado Contenedor ilegal confiscado Contenedor ilegal confiscado
IMPORTANTE: El ejemplo es meramente ilustrativo, la solución planteada debe ser válida para cualquier arreglo. Aplicar TODAS las buenas prácticas vistas en la materia. No usar estructuras auxiliares.
*/

    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        int[] A = {0, 0, 15, 22, 0, 8, 9, 0, 0, 4, 7, 11, 0, 15, 22, 0, 0, 0, 0, 0, 0, 0};

        int[] B = {0, 4, 7, 11, 0, 0, 99, 1, 0, 15, 22, 0, 0, 0, 0};
        
        int[] arrC = procesarSecuencia(A, B);

        mostrarArreglo(arrC);
    }

    public static int[] procesarSecuencia(int[] arrA, int[] arrB){
        int ini = 0, fin = -1, indiceResultado = 0;

        int[] arrC = new int[arrA.length];

        while(ini < arrA.length){
            ini = buscarInicio(arrA, fin + 1);

            if(ini < arrA.length){
                fin = buscarFin(arrA, ini);

                if(buscarEnContrabando(arrA, ini, fin, arrB)){

                    indiceResultado = copiarSecuencia(arrA, ini, fin, arrC, indiceResultado);
                    System.out.println("contenedor ilegar confiscado.");

                    int tamaño = fin - ini + 1;

                    eliminarSecuencia(arrA, ini, tamaño);
                    fin = fin - tamaño;
                }
            }
        }
        return arrC;
    }

    public static int copiarSecuencia(int[] arrA, int iniA, int finA, int[] arrC, int indiceResultado){
        for(int i = iniA; i <= finA; i++){
            arrC[indiceResultado] = arrA[i];
            indiceResultado++;
        }
        arrC[indiceResultado] = SEPARADOR;
        indiceResultado++;

        return indiceResultado;
    }

    public static void eliminarSecuencia(int[] arrA, int ini, int tamaño){
        for(int i = 0; i < tamaño; i++){
            corrimientoIzquierda(arrA, ini);
        }
    }

    public static boolean buscarEnContrabando(int[] arrA, int ini, int fin, int[] arrB){
        int iniB = 0, finB = -1;
        boolean loEncontre = false;

        while(iniB < arrB.length && !loEncontre){
            iniB = buscarInicio(arrB,  finB + 1);

            if(iniB < arrB.length){
                finB = buscarFin(arrB, iniB);

                if(existeEnContrabando(arrA, ini, fin, arrB, iniB, finB)){
                    loEncontre = true;
                }
            }
        }
        return loEncontre;
    }

    public static boolean existeEnContrabando(int[] arrA, int iniA, int finA, int[] arrB, int iniB, int finB){
        if(finA - iniA + 1 != finB - iniB + 1){
            return false;
        }

        while(iniA <= finA && arrA[iniA] == arrB[iniB]){
            iniA++;
            iniB++;
        }
        return iniA > finA;
    }

    public static int buscarInicio(int[] arr, int pos){
        while(pos < arr.length && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos){
        while (pos < arr.length && arr[pos] != SEPARADOR) {
            pos++;
        }
        return pos - 1;
    }

    public static void corrimientoIzquierda(int[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
    }

    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }
}
