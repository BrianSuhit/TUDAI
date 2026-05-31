public class MonitoreoDeCalidadDeAire {
/*
📝 SIMULACRO NIVEL 1: "Monitoreo de Calidad del Aire"
El Dominio Real (La Saraza): Una red de sensores ambientales registra los Índices de Calidad del Aire (ICA) en distintas zonas industriales de una ciudad. Los datos se guardan en un arreglo de enteros A de tamaño MAX. Cada secuencia de números representa las lecturas tomadas en una zona distinta. Para separar las lecturas de una zona de las de otra, se utiliza el valor 0 como delimitador
.
La Consigna: El Ministerio de Medio Ambiente considera que una zona entra en "Alerta Ambiental" si cumple simultáneamente dos condiciones:
Se tomaron al menos N lecturas en esa zona (es decir, el tamaño de la secuencia es mayor o igual a N).
El promedio del índice de contaminación de esa zona es estrictamente mayor a M.
Se pide implementar un programa en Java que, dados los valores N y M (podés declararlos como variables o constantes en tu main), determine si existió alguna zona en Alerta Ambiental. De ser así, el programa debe imprimir por pantalla la posición de inicio y fin de la primera secuencia que cumpla con estas condiciones
.
(Ejemplo mental: Si N=3 y M=100, y encontrás un vagón que tiene 4 lecturas y su promedio da 115, imprimís su inicio y fin, y podés cortar la búsqueda).
*/
    public static final int SEPARADOR = 0;
    public static final int N = 3;
    public static final int M = 100;

    public static void main(String[] args) {
        
        int[] arrA = {0, 40, 150, 120, 0, 50, 60, 0, 0};

        int ini = 0;
        int fin = -1;

        boolean seEncontroZonaEnAlerta = false;

        while(ini < arrA.length && !seEncontroZonaEnAlerta){
            ini = buscarInicio(arrA, fin + 1);

            if(ini < arrA.length){
                fin = buscarFin(arrA, ini);

                int tamaniooZona = fin - ini + 1;

                if(tamaniooZona > N){

                    double promedio = calcularPromedio(arrA, ini, fin);

                    if(promedio > M){
                        seEncontroZonaEnAlerta = true;
                        System.out.println("Existio zona en alerta ambiental entre " + ini + " y " + fin + " con promedio: " + promedio);
                    }
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
        while( pos < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos -1;
    }

    public static double calcularPromedio(int[] arr, int ini, int fin){
        int suma = 0;
        int contador = 0;
        
        for(int pos = ini; pos <= fin; pos++){
            suma = suma + arr[pos];
            contador++;
        }

        return (double)suma / contador;
    }
}
