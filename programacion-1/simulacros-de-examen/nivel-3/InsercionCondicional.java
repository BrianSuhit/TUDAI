public class InsercionCondicional {
/*
SIMULACRO 10 (Nivel 3): "Inserción de separadores"
El Dominio: Tenés una línea de producción de enteros. Cada vez que detectes un número impar, tenés que insertar un 0 inmediatamente después de ese número para marcarlo.
La Consigna: Recorrer el arreglo, buscar los impares, hacer el hueco empujando todo hacia la derecha [cite: 316, 321] e insertar el 0 en la posición siguiente al impar. Controlá bien tu i para no caer en un bucle infinito leyendo el cero que acabás de insertar o volviendo a evaluar el mismo impar.
*/
        public static void main(String[] args) {
        
        int[] linea = {4, 7, 2, 9, 8, 0, 0, 0, 0, 0};

        System.out.println("linea de produccion inicial:");
        mostrarArreglo(linea);

        int separadorAInsertar = 0;
        
        int i = 0;
        while(i < linea.length){
            if(linea[i] % 2 != 0){
                corrimientoDerecha(linea, i + 1);
                linea[i + 1] = separadorAInsertar;
                i+=1;
            }
            i++;
        }

        System.out.println("\nlinea despues de insercion:");
        mostrarArreglo(linea);
        
    }

    public static void corrimientoDerecha(int[] arr, int pos){
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
