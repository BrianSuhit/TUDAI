public class EjercicioSismos {
/*
Análisis de Sismos
Un sismógrafo ubicado en la ciudad de Mendoza, Argentina, registró una fuerte actividad sísmica en los
últimos días. Los datos están en escala de Richter, y están representados en el siguiente arreglo:
0 2.1 1.5 4.1 0 3.4 0 2.5 3.0 0 3.8 0 2.7 2.7 3.9 2.5 0 4.2 2.0 0 0
Cada día de actividad sísmica está separado por un cero. Cada secuencia representa qué sismos hubo en
esa jornada. Entonces, con la información provista, se pide:
Determinar si en periodo registrado, existió un día donde hubo un número N mínimo de temblores y cuyo
promedio diario fuese superior a M en la escala de Richter. Por ejemplo, si N=2 y M=2.6, existió dicho día
dado que la 3ra secuencia (2.5, 3.0) cumple con lo buscado.
*/
    public static final int MAX = 21; 
    public static final double SEPARADOR = 0.0;
    
    public static final int N = 2; 
    public static final double M = 2.6;

    public static void main(String[] args){
        double[] arreglo = {0, 2.1, 1.5, 4.1, 0, 3.4, 0, 2.5, 3.0, 0, 3.8, 0, 2.7, 2.7, 3.9, 2.5, 0, 4.2, 2.0, 0, 0};

        int ini = 0;
        int fin = -1;
        
        boolean diaEncontrado = false; 

        while(ini < MAX && !diaEncontrado){
            ini = buscarInicio(arreglo, fin + 1);

            if(ini < MAX){
                fin = buscarFin(arreglo, ini);

                int cantidadTemblores = fin - ini + 1;
                
                if (cantidadTemblores >= N) {
                    
                    double promedio = buscarPromedio(arreglo, ini, fin);

                    if (promedio > M) {
                        diaEncontrado = true;
                        System.out.println("Existió un día (Posición " + ini + " a " + fin + ") con promedio: " + promedio);
                    }
                }
            }
        }
        
        if (!diaEncontrado) {
            System.out.println("No se registró ningún día que cumpla las condiciones.");
        }
    }

    public static int buscarInicio(double[] arr, int pos){
        while(pos < MAX && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(double[] arr, int ini){
        while(ini < MAX && arr[ini] != SEPARADOR){
            ini++;
        }
        return ini - 1;
    }

    public static double buscarPromedio(double[] arr, int ini, int fin){
        double suma = 0.0;
        int contador = 0;

        for(int pos = ini; pos <= fin; pos++){
            suma += arr[pos];
            contador++;
        }

        return suma / contador;
    }
}
