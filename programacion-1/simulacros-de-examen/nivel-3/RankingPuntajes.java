public class RankingPuntajes {
/*
📝 SIMULACRO 4 (Nivel 3): "Ranking de puntajes" (Búsqueda + Inserción Ordenada)
El Dominio: Tenés una tabla de posiciones (ranking) de un videojuego guardada en un arreglo. Los puntajes están ordenados de MAYOR a MENOR (decrecientemente). Los ceros al final representan lugares libres en el ranking.
La Consigna: Un jugador acaba de terminar su partida y sacó un nuevoPuntaje. Tu misión es:
Buscar en qué posición exacta debería ir ese puntaje para que el arreglo siga quedando ordenado de mayor a menor.
Hacer un corrimiento a derecha a partir de esa posición descubierta para hacerle el hueco.
Insertar (asignar) el nuevo puntaje en ese hueco.
*/

    public static void main(String[] args) {
        
        // Ranking ordenado de MAYOR a MENOR. Los ceros son espacios libres.
        int[] ranking = {95, 82, 74, 60, 45, 0, 0, 0, 0, 0};
        int nuevoPuntaje = 78; 
        
        System.out.println("Ranking inicial:");
        mostrarArreglo(ranking);
        
        // ... ¡TODO TUYO! ...
        int posicion = buscarPosicionInsercion(ranking, nuevoPuntaje);
        corrimientoDerecha(ranking, posicion);
        ranking[posicion] = nuevoPuntaje;
        
        System.out.println("\nRanking actualizado:");
        mostrarArreglo(ranking);
    }

    public static int buscarPosicionInsercion(int[] arr, int valor) {
        int pos = 0;
        while(pos < arr.length && arr[pos] > valor){
            pos++;
        }
        return pos;
    }

       // LA ACCIÓN: Tu corrimiento a derecha (Traelo del Simulacro 2)
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
