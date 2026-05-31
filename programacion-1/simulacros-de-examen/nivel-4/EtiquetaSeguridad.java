public class EtiquetaSeguridad {
/*
SIMULACRO 4 (Nivel 4): "Etiqueta de seguridad" (Romper al medio)
El Dominio: Una línea de ensamblaje agrupa códigos de piezas en secuencias (separadas por 0). Los ingenieros determinaron que cada vez que la máquina detecta la pieza "Motor" (código 99) adentro de cualquier secuencia, el sistema debe insertar automáticamente una "Etiqueta de Inspección" (código 100) inmediatamente después del motor. Si un vagón tiene varios motores, todos deben recibir su etiqueta.
*/
    public static final int SEPARADOR = 0;
    
    public static void main(String[] args) {
        
        // Línea de ensamblaje. Pieza Motor = 99. Etiqueta = 100.
        int[] linea = {0, 45, 99, 12, 0, 0, 99, 0, 8, 3, 99, 7, 99, 0, 0, 0, 0, 0, 0, 0};
        int motor = 99;
        int etiqueta = 100;
        
        System.out.println("Línea inicial:");
        mostrarArreglo(linea);
        
        // --- EL DIRECTOR ---
        int ini = 0;
        int fin = -1;

        while(ini < linea.length){
            ini = buscarInicio(linea, fin + 1);

            if(ini < linea.length){
                fin = buscarFin(linea, ini);

                int posActual = ini;

                while(posActual <= fin){
                    if(linea[posActual] == motor){
                        corrimientoDerecha(linea, posActual + 1);
                        linea[posActual + 1] = etiqueta;
                        fin = fin + 1;
                        posActual+=2;
                    }else{
                        posActual++;
                    }
                }
            }
        }
        
        System.out.println("\nLínea después de la inspección:");
        mostrarArreglo(linea);
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