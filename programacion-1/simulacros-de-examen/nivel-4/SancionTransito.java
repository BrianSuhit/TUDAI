public class SancionTransito {
/*
SIMULACRO 2 (Nivel 4): "Sanción de tránsito" (Inserción al inicio de la secuencia)
El Dominio: Un radar agrupa las velocidades de los autos registradas por hora en un arreglo (cada hora es un vagón, separado por ceros). La ley de tránsito indica que si en una hora determinada pasaron más de 5 autos por ese tramo, se debe insertar un código especial de "Alerta de Tráfico" (ejemplo: el código 999) exactamente en la primera posición de esa secuencia, empujando todas las velocidades registradas hacia la derecha. Esto se debe evaluar para todas las horas registradas.
*/
    public static final int SEPARADOR = 0;
    public static final int AUTOS_X_HS = 5;
    public static void main(String[] args) {
        
        // Arreglo de velocidades. Cada hora es un vagón. Separados por 0.
        // La primera hora tiene 6 autos. La segunda tiene 2. La tercera tiene 6.
        int[] velocidades = {0, 120, 110, 90, 105, 130, 115, 0, 80, 90, 0, 100, 110, 120, 115, 105, 130, 0, 0, 0};
        int alerta = 999;
        
        System.out.println("Registro inicial:");
        mostrarArreglo(velocidades);
        
        int ini = 0;
        int fin = -1;

        while(ini < velocidades.length){
            ini = buscarInicio(velocidades, fin + 1);

            if(ini < velocidades.length){
                fin = buscarFin(velocidades, ini);

                int tamaño = fin - ini + 1;

                if(tamaño > AUTOS_X_HS){
                    corrimientoDerecha(velocidades, ini);
                    velocidades[ini] = alerta;
                    fin = fin + 1;
                }
            }
        }
        
        System.out.println("\nRegistro despues de las alertas:");
        mostrarArreglo(velocidades);
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
