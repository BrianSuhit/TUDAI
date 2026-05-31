public class ControlAccesos {
/*
📝 SIMULACRO REAL: Control de Accesos (Nivel 2)
Dominio: Una base militar registra los ingresos diarios de su personal en un arreglo ingresos de tamaño MAX. Cada empleado se identifica con una secuencia de números enteros positivos, separados por ceros. Por otro lado, la base cuenta con un arreglo autorizados (también de tamaño MAX y separado por ceros) que contiene las identificaciones de los empleados que tienen permiso para entrar.
Consigna: Se pide realizar un programa en Java que analice los ingresos y cuente cuántas secuencias (personas) ingresaron a la base de forma ILEGAL. Un ingreso es ilegal si la secuencia registrada en ingresos NO se encuentra en el arreglo de autorizados. Al finalizar, el programa debe imprimir por consola la cantidad total de ingresos ilegales detectados.
*/
    public static final int SEPARADOR = 0;
    
    public static void main(String[] args) {
        // En este ejemplo, el empleado {99, 1} es el único ilegal. El resultado a imprimir debe ser 1.
        int[] ingresos = {0, 14, 22, 0, 8, 9, 0, 14, 22, 0, 99, 1, 0};
        int[] autorizados = {0, 8, 9, 0, 10, 5, 0, 14, 22, 0};
        
        // TU LLAMADA AL DIRECTOR ACÁ
        procesarSecuencia(ingresos, autorizados);
    }

    public static void procesarSecuencia(int[] ingresos, int[] autorizados){
        int ini = 0, fin = -1;

        int contadorIlegales = 0;

        while(ini < ingresos.length){
            ini = buscarInicio(ingresos, fin + 1);

            if(ini < ingresos.length){
                fin = buscarFin(ingresos, ini);

                if(!existeEnAutorizados(ingresos, ini, fin, autorizados)){
                    contadorIlegales++;
                }
            }
        }
        System.out.println("se encontraron: " + contadorIlegales + " secuencias ilegales");
    }

    public static boolean existeEnAutorizados(int[] arr, int ini, int fin, int[] arrB){
        int iniB = 0,  finB = -1;
        
        boolean loEncontre = false;

        while(iniB < arrB.length && !loEncontre){
            iniB = buscarInicio(arrB, finB + 1);

            if(iniB < arrB.length){
                finB = buscarFin(arrB, iniB);

                if(cumplePatron(arr, ini, fin, arrB, iniB, finB)){
                    loEncontre = true;
                }
            }
        }
        return loEncontre;
    }

    public static boolean cumplePatron(int[] arrA, int iniA, int finA, int[] arrB, int iniB, int finB){
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
        while(pos < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos - 1;
    }
}
