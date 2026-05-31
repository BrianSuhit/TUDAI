public class ControlDePuertoDeBuenosAires {
/*
📝 SIMULACRO NIVEL 2: "Control de Contenedores en el Puerto"
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

                boolean contenedorEncontrado = false;
                int iniE = 0;
                int finE = -1;

                while(iniE < arrEgresos.length && !contenedorEncontrado){
                    iniE = buscarInicio(arrEgresos, finE + 1);
                    
                    if(iniE < arrEgresos.length){
                        finE = buscarFin(arrEgresos, iniE);

                        if (salioDelPuerto(arrIngresos, ini, fin, arrEgresos, iniE, finE)) {
                            contenedorEncontrado = true; 
                        }
                    }
                }

                if(!contenedorEncontrado){
                    System.out.println("la secuencia de contenedores que no salieron inicia en: " + ini + " y termina en: " + fin);
                }
            }
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

    public static boolean salioDelPuerto(int[] arrA, int iniA , int finA, int[] arrB, int iniB, int finB){
        int tamA = finA - iniA + 1;
        int tamB = finB - iniB + 1;

        if(tamA != tamB){
            return false;
        }

       return sonSecuenciasIguales(arrA, iniA, finA, arrB, iniB);
    }

    public static boolean sonSecuenciasIguales(int[] arrA, int iniA, int finA, int[] arrB, int iniB){
        int i = iniA;
        int j = iniB;

        while(i <= finA){
            if(arrA[i] != arrB[j]){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
