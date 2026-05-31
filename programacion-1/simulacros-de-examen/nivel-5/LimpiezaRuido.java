public class LimpiezaRuido {
    
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        // Vagón 1: 8, 4, -20, 10, 5 -> Tamaño 5 (impar). ¿Tiene múltiplo de 2? Sí. 
        // Acción: Se debe borrar el -20.
        // Vagón 2: 1, 25, -30 -> Tamaño 3 (impar). ¿Tiene múltiplo de 2? Sí (-30). 
        // Acción: Se debe borrar el -30.
        int[] temperaturas = {0, 8, 4, -20, 10, 5, 0, 1, 25, -30, 0, 0, 0, 0, 0};

        System.out.println("Temperaturas Originales:");
        mostrarArreglo(temperaturas);

        // --- TU LÓGICA ACÁ ---
        int ini = 0;
        int fin = -1;

        while(ini < temperaturas.length){
            ini = buscarInicio(temperaturas, fin + 1);

            if(ini < temperaturas.length){
                fin = buscarFin(temperaturas, ini);

                int tamaño = fin - ini + 1;

                if(tamaño % 2 != 0 && esPar(temperaturas, ini, fin)){

                    int pos = ini;

                    while(pos <= fin){

                        if(temperaturas[pos] < 0){
                            corrimientoIzquierda(temperaturas, pos);
                            fin--;
                            pos--;
                        }
                        pos++;
                    }
                }
            }
        }

        System.out.println("\nTemperaturas Limpias:");
        mostrarArreglo(temperaturas);
    }

    public static boolean esPar(int[] arr, int ini, int fin){
        int i = ini;
        boolean loEncontre = false;

        while(i <= fin && !loEncontre){
            if(arr[i] % 2 == 0){
                loEncontre = true;
            }
            i++;
        }
        return loEncontre;
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

    public static void corrimientoIzquierda(int[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
    }
    
    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "|");
        }
    }
}
