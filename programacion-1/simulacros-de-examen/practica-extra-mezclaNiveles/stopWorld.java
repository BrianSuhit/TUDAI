public class stopWorld {
    
    public static final char SEPARADOR = ' ';
    public static void main(String[] args){

        char[] T = {' ', 'l','a', ' ', 'c','a','s','a', ' ', 'r','o','j','a', ' ', 'a', ' ', 'l','a', ' ', 'v','u','e','l','t','a', ' '};

        char[] S = {' ', 'a', ' ', 'l','a', ' ', 'd','e', ' '};

        procesarSecuencia(S, T);
    }

    public static void procesarSecuencia(char[] S, char[] T){
        int iniS = 0, finS = -1, maxContador = 0, maxIniS = 0, maxFinS = 0;

        while(iniS < S.length){
            iniS = buscarInicio(S, finS + 1);

            if(iniS < S.length){
                finS = buscarFin(S, iniS);

                int contador = purgarStopword(T, S, iniS, finS);

                if(contador > maxContador){
                    maxContador = contador;
                    maxIniS = iniS;
                    maxFinS = finS;
                }
            }
        }
        if(maxContador > 0){
            System.out.println("La stopword mas eliminada se encuentra en S entre los indices " + maxIniS + " y " + maxFinS + ". Se elimino " + maxContador + " veces");
        }
    }

    public static int purgarStopword(char[] T, char[] S, int iniS, int finS){
        int iniT = 0, finT = -1;
        int cantidadEliminada = 0;

        while(iniT < T.length){
            iniT = buscarInicio(T, finT + 1);

            if(iniT < T.length){
                finT = buscarFin(T, iniT);

                // Acá sí tenemos iniT y finT para pasarle a encontreOcurrencia y a eliminarSecuencia
                if(encontreOcurrencia(T, iniT, finT, S, iniS, finS)){
                    int tamanio = finT - iniT + 1;
                    
                    eliminarSecuencia(T, iniT, tamanio);
                    finT = finT - tamanio; // El ajuste obligatorio porque el arreglo T se achicó
                    
                    cantidadEliminada++;
                }
            }
        }
        return cantidadEliminada;
    }

    public static boolean encontreOcurrencia(char[] S, int iniS, int finS, char[] T, int iniT, int finT){
        if(finS - iniS + 1 != finT - iniT + 1){
            return false;
        }

        while(iniS <= finS && S[iniS] == T[iniT]){
            iniS++;
            iniT++;
        }
        return iniS > finS;
    }

    public static void eliminarSecuencia(char[] arrS, int ini, int tamaño){
        for(int i = 0; i < tamaño; i++){
            corrimientoIzquierda(arrS, ini);
        }
    }

    public static void corrimientoIzquierda(char[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
    }

    public static int buscarInicio(char[] arr, int pos){
        while(pos < arr.length && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(char[] arr, int pos){
        while(pos < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos - 1;
    }
}
