public class TorneoDeTiro {
/*
La Consigna: Un sistema registra los puntajes que obtiene un arquero en diferentes rondas de un torneo. Estos datos se guardan en un arreglo de secuencias separadas por ceros (0). Cada secuencia representa los tiros acertados en una misma ronda.
Se te pide recorrer el arreglo para encontrar cuál fue la mejor ronda del torneo. La "mejor ronda" es aquella en la que la suma total de sus puntajes sea la más alta.
Al finalizar de recorrer todo el arreglo, el programa no debe imprimir un contador, sino que debe informar dónde estaba esa secuencia ganadora y cuántos puntos sumó en total, imprimiendo: "La mejor ronda sumó Z puntos y está entre las posiciones X e Y".
*/
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        int[] arrPuntajes = {0, 50, 20, 0, 10, 10, 10, 0, 40, 60, 10, 0, 100, 0, 0};

        int ini = 0;
        int fin = -1;

        int mejorSuma = -1;
        int mejorIni = 0;
        int mejorFin = 0;

        while(ini < arrPuntajes.length){
            ini = buscarInicio(arrPuntajes, fin +1);

            if(ini < arrPuntajes.length){
                fin = buscarFin(arrPuntajes, ini);

                int suma = calcularPuntaje(arrPuntajes, ini, fin);

                if(suma > mejorSuma){
                    mejorSuma = suma;
                    mejorIni = ini;
                    mejorFin = fin;
                }
            }
        }
        System.out.println("La mejor ronda sumo: " + mejorSuma +  " puntos y está entre las posiciones: " + mejorIni + " y " + mejorFin);
    }

    public static int calcularPuntaje(int[] arr, int ini, int fin){
        int suma = 0;

        for(int i = ini; i <= fin; i++){
            suma = suma + arr[i];
        }
        return suma;
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
        return pos -1;
    }
}
