public class FiltradoADN {
/*
Simulacro 5 NIVEL 5 - "Filtrado de Genética Compleja"
El Dominio: Un laboratorio secuencia ADN en un arreglo de enteros de tamaño MAX. Cada secuencia de genes está separada por ceros (0). El sistema debe analizar el ADN y eliminar las secuencias anómalas. Se descubrió que las secuencias anómalas cumplen dos condiciones simultáneas [cite: 343, 441]:
Tienen una cantidad impar de genes (tamaño impar).
Contienen adentro al menos una vez un gen específico (en este caso, el gen 7).
Objetivo: Eliminar por completo las secuencias (achicar el arreglo) que cumplan ambas condiciones.
*/
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        // Vagón 1: 15, 7, 22 (Tamaño 3 impar. ¿Tiene el 7? SÍ) -> DEBE BORRARSE
        // Vagón 2: 8, 4, 7, 9 (Tamaño 4 par. ¿Tiene el 7? SÍ) -> SE SALVA
        // Vagón 3: 11, 33, 5 (Tamaño 3 impar. ¿Tiene el 7? NO) -> SE SALVA
        // Vagón 4: 7 (Tamaño 1 impar. ¿Tiene el 7? SÍ) -> DEBE BORRARSE
        int[] adn = {0, 15, 7, 22, 0, 8, 4, 7, 9, 0, 11, 33, 5, 0, 7, 0, 0, 0, 0, 0};
        
        int genEspecifico = 7;

        System.out.println("ADN Original:");
        mostrarArreglo(adn);

        // --- TU LÓGICA DEL DIRECTOR ACÁ ---
        int ini = 0;
        int fin = - 1;

        while(ini < adn.length){
            ini = buscarInicio(adn, fin + 1);
            
            if(ini < adn.length){
                fin = buscarFin(adn, ini);

                int tamaño = fin - ini + 1;

                if(tamaño % 2 != 0 && tieneGen(adn, ini, fin, genEspecifico)){

                    for(int i = 0; i < tamaño; i++){
                        corrimientoIzquierda(adn, ini);
                    }
                    fin = fin - tamaño;
                }
            }
        }

        System.out.println("\nADN Filtrado:");
        mostrarArreglo(adn);
    }
    
    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
    }

    public static boolean tieneGen(int[] arr, int ini, int fin, int valor){
        int i = ini;
        boolean loEncontre = false;

        while(i <= fin && !loEncontre){
            if(arr[i] == valor){
                loEncontre = true;
            }
            i++;
        }
        return loEncontre;
    }

    public static void corrimientoIzquierda(int[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
            arr[pos] = arr[pos - 1];
        }
    }

    public static int buscarInicio(int[]arr, int pos){
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
