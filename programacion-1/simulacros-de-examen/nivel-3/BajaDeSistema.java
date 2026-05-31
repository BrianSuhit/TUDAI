public class BajaDeSistema {
/*
📝 SIMULACRO 3 (Nivel 3): "Baja de sistema" (Búsqueda + Eliminación Única)
El Dominio: Tenés una base de datos de un sistema representada por un arreglo simple con los números de DNI de los usuarios registrados. Los lugares vacíos al final son ceros.
La Consigna: Un usuario se da de baja del sistema. Tenés que buscar en qué posición está su DNI.
Si el DNI existe, lo eliminás haciendo un corrimiento a izquierda para no dejar huecos.
Si el DNI no existe, informás que no se encontró.
*/
    public static void main(String[] args) {
        
        // Base de datos de DNIs
        int[] dnis = {45678912, 12345678, 78912345, 23456789, 56789123, 0, 0, 0, 0, 0};
        int dniABorrar = 78912345; 
        
        System.out.println("Base de datos inicial:");
        mostrarArreglo(dnis);
        
        // 1. Obrero buscador: ¿Dónde está el DNI?
        int pos = buscarPosicion(dnis, dniABorrar);
        
        // 2. Acción: Si lo encontré, lo borro
        if (pos != -1) {
            corrimientoIzquierda(dnis, pos);
            System.out.println("\nSe dio de baja el DNI: " + dniABorrar);
        } else {
            System.out.println("\nEl DNI " + dniABorrar + " no existe en el sistema.");
        }
        
        System.out.println("Base de datos actualizada:");
        mostrarArreglo(dnis);
    }

    // EL BUSCADOR (Nivel 1): Recorre y retorna la posición, o -1 si no está
    public static int buscarPosicion(int[] arr, int valor) {
        int pos = 0;
        while(pos < arr.length && valor != arr[pos]){
            pos++;
        }
       
        if(pos < arr.length){
            return pos;
        }
        else{
            return -1;
        }
    }

    // LA ACCIÓN: Tu corrimiento a izquierda de siempre, pero usando arr.length
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
