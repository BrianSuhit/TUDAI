public class Parcial2026 {
/*
Un docente universitario desea calcular la pérdida de poder adquisitivo de su sueldo. Para
ello, dispone de un arreglo A de números reales (double) que almacena los porcentajes de
aumentos salariales recibidos en los últimos años.
Debido a que durante un año el docente recibió distintos aumentos mensuales, para mejor
organización, los valores se encuentran agrupados en secuencias. Cada secuencia,
representa los porcentajes de aumentos recibidos durante un mismo año. Las secuencias
están separadas por uno o más ceros.
Por ejemplo, el siguiente arreglo muestra los porcentajes de aumento recibidos por el
docente desde 2024 a 2026. En 2024, el docente recibió 11 aumentos durante el año; en
2025, recibió 7 y en lo que va de 2026, recibió 3.
0 0 10 12 8 9 4 7.5 3 2 6.8 2 1 0 0 2.7 2.6 1.3 3.95 1.2 1.1 1.1 0 2 6.85 1.7 0 0
A su vez, almacena en un arreglo I de números reales, la inflación acumulada
correspondiente a cada año.
Siguiendo con el ejemplo, en I = {117.74, 31.54, 12.27} el primer valor corresponde a 2024, el
segundo valor a 2025 y el tercero a lo que va de 2026.
Para calcular el porcentaje total de aumento recibido por año, el docente debe aplicar el
siguiente método que calcula los aumentos incrementalmente:

public static double calcularAumentoAnual(double[] arr, int ini, int fin) {
 double aumento = 1;
 for (int i = ini; i <= fin; i++) {
 aumento *= 1 + arr[i] / 100;
 }
 return (aumento - 1) * 100;
}
Se pide implementar un programa en Java que determine, para cada año, la diferencia
entre el porcentaje total de aumento recibido y la correspondiente inflación acumulada del
mismo año. Si la diferencia es negativa, se debe reemplazar en A la secuencia de
aumentos recibidos en el año por el valor de la diferencia. Además, se debe informar el
año con mayor pérdida de poder adquisitivo y si en dicho año, los aumentos otorgados
estuvieron ordenados en forma ascendente.
Para el ejemplo anterior, el arreglo A resultante quedaría de la siguiente forma:
0 0 -30.31 0 0 -16.77 0 -1.43 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
Además, se debería informar que el año con mayor pérdida de poder adquisitivo fue el año
0 (primer año del arreglo) con una diferencia de -30.31% y los aumentos de ese mes no
estuvieron ordenados en forma ascendente.
IMPORTANTE: Asumir que en el arreglo I hay tantos elementos como secuencias en el
arreglo A, por lo tanto los tamaños de A e I son distintos. El ejemplo es meramente
ilustrativo, la solución planteada debe ser válida para cualquier arreglo A e I. Aplicar
TODAS las buenas prácticas vistas en la materia. No usar estructuras auxiliares.

*/
    public static final double SEPARADOR = 0.0;
    public static void main(String[] args) {
        double[] A = {0, 0, 10, 12, 8, 9, 4, 7.5, 3, 2, 6.8, 2, 1, 0, 0, 2.7, 2.6, 1.3, 3.95, 1.2, 1.1, 1.1, 0, 2, 6.85, 1.7, 0, 0};
        double[] I = {117.74, 31.54, 12.27};

        ProcesarBalanceSalarial(A, I);

        mostrarArreglo(A);
    }

    public static void ProcesarBalanceSalarial(double[] arrA, double[] arrI) {
        
        double mayorPerdida = 0.0; 
        int anoMayorPerdida = 0;
        boolean ascMayorPerdida = false; 

        int ini = 0, fin = -1, ano = 0;

        while(ini < arrA.length) {
            ini = buscarInicio(arrA, fin + 1);
            
            if(ini < arrA.length) {
                fin = buscarFin(arrA, ini);
                
                int tamano = fin - ini + 1;
                double aumento = calcularAumentoAnual(arrA, ini, fin);
                double diferencia = aumento - arrI[ano];


                if(diferencia < mayorPerdida) {
                    mayorPerdida = diferencia;
                    anoMayorPerdida = ano;
                    
                    ascMayorPerdida = esAscendente(arrA, ini, fin); 
                }

                if(diferencia < 0) {
                    arrA[ini] = diferencia;
                    
                    eliminarSecuencia(arrA, tamano - 1, ini + 1); 
                    
                    fin = ini; 
                }
                ano++;
            }
        }
        
        System.out.println("El año con mayor pérdida fue: " + anoMayorPerdida + 
                           " la diferencia fue: " + mayorPerdida + 
                           " los aumentos fueron ascendentes: " + ascMayorPerdida);
    }

    // public static void ProcesarBalanceSalarialDEBRIAN(double[] arrA, double[] arrI) {

    //     int ini = 0, fin = -1, ano = 0;

    //     while(ini < arrA.length) {
    //         ini = buscarInicio(arrA, fin + 1);
            
    //         if(ini < arrA.length) {
    //             fin = buscarFin(arrA, ini);
                
    //             int tamano = fin - ini + 1;
    //             double aumento = calcularAumentoAnual(arrA, ini, fin);
    //             double diferencia = aumento - arrI[ano];

    //             boolean fueronAumentosAscendentes = esAscendente(arrA, ini, fin);
                
    //             if(diferencia < 0){
    //                 arrA[ini] = diferencia;
                    
    //                 eliminarSecuencia(arrA, tamano - 1, ini + 1); 
                    
    //                 fin = ini;
                    
    //                 double mayorPerdida = 0.0;
    //                 int anoMayorPerdida = 0;

    //                 if(diferencia < mayorPerdida){
    //                     mayorPerdida = diferencia;
    //                     anoMayorPerdida = mayorPerdida + 1;
    //                 }
    //             }
    //             ano++;
    //         }
    //     }
    //     System.out.println("El año con mayor pérdida fue: " + anoMayorPerdida + 
    //                        " la diferencia fue: " + mayorPerdida + 
    //                        " los aumentos fueron ascendentes: " + ascMayorPerdida);
    // }

    public static double calcularAumentoAnual(double[] arr, int ini, int fin) {
        double aumento = 1.0;
        for (int i = ini; i <= fin; i++) {
            aumento *= (1 + arr[i] / 100.0); 
        }
        return (aumento - 1) * 100;
    }

    public static void eliminarSecuencia(double[] arr, int tam, int pos){
        for(int i = 0; i < tam; i++){
            corrimientoIzquierda(arr, pos);
        }
    }

    public static void corrimientoIzquierda(double[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
    }

    public static boolean esAscendente(double[] arr, int ini, int fin) {
        while (ini < fin && arr[ini] <= arr[ini+1]) { 
            ini++;
        }
        return ini == fin;
    }

    public static int buscarInicio(double[]arr, int pos){
        while(pos < arr.length && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(double[] arr, int pos){
        while(pos < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos - 1;
    }

    public static void mostrarArreglo(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }
}
