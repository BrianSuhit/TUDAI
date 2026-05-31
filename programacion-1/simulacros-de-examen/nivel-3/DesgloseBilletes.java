public class DesgloseBilletes {
/*
📝 SIMULACRO 9 (Nivel 3): "Desglose de billetes" (Reemplazo con expansión)
El Dominio: Tenés el cajón de una caja registradora representado por un arreglo de enteros. Los ceros al final son espacio vacío. El cajero necesita cambio, por lo que cada vez que encuentre un billete de 100, debe desglosarlo (cambiarlo) por dos billetes de 50.
*/
    public static void main(String[] args) {
        
        // Caja registradora. Hay dos billetes de 100 para desglosar.
        int[] caja = {20, 100, 10, 100, 50, 0, 0, 0, 0, 0};

        int billeteARomper = 100;
        int billeteNuevo = 50;
        
        System.out.println("Caja inicial:");
        mostrarArreglo(caja);
        
        int i = 0;
        while(i < caja.length){

            if(caja[i] == billeteARomper){
                caja[i] = billeteNuevo;
                corrimientoDerecha(caja, i + 1);
                caja[i + 1] = billeteNuevo;
                i+=2;
            }
            else{
                i++;
            }
        }
        
        System.out.println("\nCaja después del desglose:");
        mostrarArreglo(caja);
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
