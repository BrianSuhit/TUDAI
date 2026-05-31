public class SimulacroAduana {
/*
🛂 Simulacro Inédito: "Control de Aduanas" (Nivel 5)
El Dominio (Consigna Pura): Un escáner de aduana registra el contenido del equipaje de los pasajeros en un arreglo A de enteros de tamaño MAX. Cada pasajero (secuencia) lleva una serie de códigos de artículos (números positivos), y el equipaje de un pasajero se separa del otro mediante ceros (0). El arreglo empieza y termina con ceros.
Las reglas de la Policía Aduanera son estrictas e inapelables:
Regla de Contrabando: Si el escáner detecta que un equipaje contiene al menos una vez el artículo prohibido código 99, se confisca (elimina) el equipaje completo [cite: 447, 448].
Regla de Exceso de Peso: Si el equipaje está limpio de contrabando, se debe calcular su peso total (la suma de todos sus artículos). Si la suma es estrictamente mayor a 100 kg, se le debe pegar una etiqueta de advertencia. Esto se hace reemplazando únicamente el primer artículo de esa secuencia por el código -1 (los demás artículos de esa secuencia quedan intactos) [cite: 428, 452].
*/
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {

        // Equipaje 1: 50, 60 -> Suma 110 (Exceso de peso). Esperado: Reemplaza 50 por -1.
        // Equipaje 2: 20, 99, 10 -> Contrabando (99). Esperado: Se tritura el vagón entero.
        // Equipaje 3: 40, 10 -> Limpio y suma 50. Esperado: Queda intacto.
        // Equipaje 4: 99 -> Contrabando pegado al final. Esperado: Se tritura.
        int[] A = {0, 50, 60, 0, 20, 99, 10, 0, 40, 10, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        System.out.println("Arreglo Original (Cinta de Aduana):");
        mostrarArreglo(A);

        // --- TU LÓGICA DEL DIRECTOR ACÁ ---
        int ini = 0;
        int fin = -1;

        int Contrabando = 99;
        int maxPeso = 100;

        while(ini < A.length){
            ini = buscarInicio(A, fin + 1);

            if(ini < A.length){
                fin = buscarFin(A, ini);

                if(tieneContrabando(A, ini, fin, Contrabando)){

                    int tamaño = fin - ini + 1;

                    for(int i = 0; i < tamaño; i++){
                        corrimientoIzquierda(A, ini);
                    }
                    fin = fin - tamaño;
                }
                else{

                    int total = calcularPeso(A, ini, fin);
                    
                    if(total > maxPeso){
                        A[ini] = -1;
                    }
                }
            }
        }
        
        
        // ----------------------------------

        System.out.println("\nArreglo Final (Equipajes procesados):");
        mostrarArreglo(A);
    }

    // --- TUS MÉTODOS OBREROS ACÁ ---
    public static boolean tieneContrabando(int[] arr, int ini, int fin, int valor){
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

    public static int calcularPeso(int[] arr, int ini, int fin){
        int suma = 0;
        for(int i = ini; i <= fin; i++){
            suma = suma + arr[i];
        }
        return suma;
    }

    public static void corrimientoIzquierda(int[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
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

    // -------------------------------
    // Método auxiliar para imprimir
    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "|");
        }
    }
}
