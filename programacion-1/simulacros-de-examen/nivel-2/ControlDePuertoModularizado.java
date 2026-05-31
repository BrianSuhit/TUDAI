public class ControlDePuertoModularizado {
/*
📝 SIMULACRO NIVEL 2: "Control de Contenedores en el Puerto MODULARIZADO CORRECTAMENTE"
El Dominio Real (La Saraza): El puerto de Buenos Aires necesita auditar qué contenedores están actualmente dentro de sus instalaciones. Para ello, cuentan con dos sistemas de registro: uno que anota en un arreglo los contenedores cuando ingresan al puerto, y otro que anota en un segundo arreglo cuando los contenedores egresan (salen)
. La identificación de cada contenedor es una secuencia de números enteros positivos, y cada registro está separado por uno o más ceros (0).
La Consigna: Se pide implementar un programa en Java que cruce ambos arreglos y determine qué contenedores entraron al puerto pero aún no salieron. Por cada contenedor que detectes que sigue adentro (es decir, que su secuencia existe en Ingresos pero no existe en Egresos), el programa debe imprimir por consola la posición de inicio y fin de dicha secuencia referenciada desde el arreglo de Ingresos
*/
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        int[] arrIngresos = {0, 0, 12, 34, 0, 56, 78, 0, 91, 23, 0, 44, 55, 0, 0};
        int[] arrEgresos  = {0, 91, 23, 0, 0, 12, 34, 0, 0, 0, 0, 0, 0, 0, 0};

        int ini = 0;
        int fin = -1;

        while(ini < arrIngresos.length){
            ini = buscarInicio(arrIngresos, fin+1);

            if(ini < arrIngresos.length){
                fin = buscarFin(arrIngresos, ini);

                // LLAMO AL MÉTODO OBRERO QUE TIENE EL SEGUNDO MOTOR
                if (!existeEnEgresos(arrEgresos, arrIngresos, ini, fin)) {
                    System.out.println("No salió la secuencia de: " + ini + " a " + fin);
                }
            }
        }
    }

    public static boolean existeEnEgresos(int[] arrEgresos, int[] arrIngresos, int iniI, int finI){
        int iniE = 0;
        int finE = -1;

        // EL MOTOR CLÁSICO RECORRIENDO EGRESOS
        while(iniE < arrEgresos.length){
            iniE = buscarInicio(arrEgresos, finE + 1);

            if(iniE < arrEgresos.length){
                finE = buscarFin(arrEgresos, iniE);

                // ¡ACÁ ESTÁ LA MAGIA! Aislé un vagón de Egresos. 
                // Lo comparo con el vagón de Ingresos que vino por parámetro:
                if (cumplePatron(arrIngresos, iniI, finI, arrEgresos, iniE, finE)) {
                    return true; // ¡Lo encontré! Corto la búsqueda temprano
                }
            }
        }
        
        // Si el while dio toda la vuelta a los egresos y nunca hizo "return true",
        // significa que el contenedor sigue en el puerto.
        return false;
    }

    // 2. EL FILTRO UNIFICADO (Al estilo del profe)
    public static boolean cumplePatron(int[] arrA, int iniA, int finA, int[] arrB, int iniB, int finB) {
        
        int tamañoB = finB - iniB + 1;
        if(finA - iniA + 1 != tamañoB){
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
        while(pos < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos - 1;
    }
}
