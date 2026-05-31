public class ClonacionCelulas {
/*
SIMULACRO 5 (Nivel 4): "Clonación de células" (Expansión masiva)
El Dominio: Un sistema de análisis genético almacena cadenas de ADN en un arreglo de secuencias (separadas por 0). Los científicos descubrieron que la célula de tipo 7 es altamente inestable: cada vez que aparece adentro de una cadena, se divide en dos (es decir, se clona).
La Consigna: Recorrer todo el arreglo y, cada vez que encuentres un 7 adentro de una secuencia, tenés que insertar otro 7 inmediatamente al lado. Si en un vagón hay múltiples 7, todos deben ser clonados.
*/
    public static final int SEPARADOR = 0;
    
    public static void main(String[] args) {
        
        // Cadenas de ADN separadas por 0. 
        // Observá el segundo vagón: tiene dos 7 seguidos. ¡Cuidado ahí!
        int[] adn = {0, 1, 7, 4, 0, 0, 7, 7, 2, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int celulaInestable = 7;
        
        System.out.println("ADN original:");
        mostrarArreglo(adn);
        
        // --- EL DIRECTOR ---
        int ini = 0;
        int fin = - 1;

        while(ini < adn.length){
            ini = buscarInicio(adn, fin + 1);

            if(ini < adn.length){
                fin = buscarFin(adn, ini);

                int posActual = ini;

                while(posActual <= fin){

                    if(adn[posActual] == celulaInestable){
                        corrimientoDerecha(adn, posActual + 1);
                        adn[posActual + 1] = celulaInestable;
                        fin = fin + 1;
                        posActual+=2;       
                    }
                    else{
                        posActual++;
                    }
                }
            }
        }
        
        System.out.println("\nADN despues de la clonacion:");
        mostrarArreglo(adn);
    }

    public static int buscarInicio(int[] arr, int pos) {
        while(pos < arr.length && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos) {
        while(pos < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos - 1;
    }

    public static void corrimientoDerecha(int[] arr, int pos) {
        for(int i = arr.length - 1; i > pos; i--){
            arr[i] = arr[i - 1];
        }
    }

    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
    }
}
