public class Parcial2026 {
    
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
