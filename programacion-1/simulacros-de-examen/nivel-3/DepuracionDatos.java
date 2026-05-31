public class DepuracionDatos {
/*
📝 SIMULACRO 8 (Nivel 3): "Depuración de datos" (Eliminación Condicional)
El Dominio: Tenés un arreglo simple con mediciones de temperatura. Las mediciones erróneas en este sensor siempre dan números negativos. Los ceros al final son espacio libre.
La Consigna: Tenés que recorrer el arreglo y eliminar todas las mediciones negativas haciendo un corrimiento a la izquierda.
Acá practicás lo que te trabó en el Simulacro 5: Como recorres y modificas el mismo arreglo, tu main necesita un while(i < arr.length). Si el número es negativo, llamás al corrimiento a izquierda y NO avanzás la i (porque al borrar, la fila avanzó hacia vos). Si el número es positivo, avanzás la i++ normalmente.
*/
    public static void main(String[] args) {
        
        // Temperaturas. Hay negativos sueltos y dos negativos pegados (-5, -2)
        int[] temperaturas = {12, -8, 14, 22, -5, -2, 19, 0, 0, 0};
        
        System.out.println("Mediciones iniciales:");
        mostrarArreglo(temperaturas);
        
        int i = 0;

        while(i < temperaturas.length){
            if(temperaturas[i] < 0){
                corrimientoIzquierda(temperaturas, i);
            }
            else{
                i++;
            }
        }
        
        System.out.println("\nMediciones depuradas:");
        mostrarArreglo(temperaturas);
    }

    // EL MÉTODO DE ACCIÓN: Corrimiento a izquierda
    // (Escribilo vos, acordate que pisa y va para adelante)
    public static void corrimientoIzquierda(int[] arr, int pos){
        for(int i = pos; i < arr.length -1; i++){
            arr[i] = arr[i + 1];
        }
    }
    
    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
    }
}
