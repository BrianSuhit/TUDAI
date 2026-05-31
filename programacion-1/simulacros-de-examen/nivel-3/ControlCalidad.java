public class ControlCalidad {
/*
📝 SIMULACRO 5 (Nivel 3): "Control de Calidad" (Eliminación Masiva y la Trampa de los Índices)
El Dominio: Tenés una cinta transportadora en una fábrica (representada por un arreglo simple) con los códigos de los productos recién fabricados. Los ceros son espacios vacíos al final. El escáner detectó que la máquina falló y produjo varios artículos defectuosos con el código 44.
La Consigna: Tenés que recorrer todo el arreglo y eliminar TODAS las ocurrencias del producto defectuoso 44
. Cada vez que encuentres uno, debés hacer un corrimiento a izquierda para tapar el hueco.
⚠️ LA TRAMPA (Leela con atención antes de codificar): Fijate que en el arreglo de prueba puse dos 44 seguidos (... 44, 44, ...). Si vos venís recorriendo con tu iterador i, borrás el primer 44 y toda la fila avanza un paso. ¿Qué pasa con el segundo 44? ¡Cae exactamente en la posición i donde estás parado ahora! Si tu ciclo avanza ciegamente al próximo paso (haciendo un i++), vas a saltarte el segundo 44 sin revisarlo.
*/
    public static void main(String[] args) {
        
        // Cinta transportadora. Hay tres 44, dos de ellos están pegados.
        int[] cinta = {10, 44, 44, 25, 44, 99, 12, 0, 0, 0};
        int codigoFalla = 44; 
        
        System.out.println("Cinta inicial:");
        mostrarArreglo(cinta);
        
        // 1. EL MOTOR DE RECORRIDO (¡Todo tuyo!)
        // Tenés que recorrer la cinta elemento por elemento.
        // Si el elemento es igual a codigoFalla -> Hacés el corrimiento a izquierda.
        // ¡OJO! Pensá bien cómo manejar tu iterador para no saltearte el 
        // elemento que acaba de caer en tu posición luego del corrimiento.
        eliminarDefectuosos(cinta, codigoFalla);
        
        System.out.println("\nCinta después del control de calidad:");
        mostrarArreglo(cinta);
    }

    public static void eliminarDefectuosos(int[] cinta, int codigoFalla){
         int i = 0;

        while(i < cinta.length){

            if(cinta[i] == codigoFalla){
                corrimientoIzquierda(cinta, i);
            }
            else{
                i++;
            }
        }
    }

    // LA ACCIÓN: Tu corrimiento a izquierda de siempre
    public static void corrimientoIzquierda(int[] arr, int pos) {
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
    }

    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
    }
}
