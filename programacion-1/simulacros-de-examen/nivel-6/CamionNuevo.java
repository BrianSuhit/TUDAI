public class CamionNuevo {
/*
Como hablamos ayer, la trampa mortal de pasar datos a un arreglo nuevo es que no podés usar el mismo iterador del arreglo original (i) para escribir en el nuevo, porque si la caja 3 estaba rota y te la salteaste, la caja 4 no la podés poner en el asiento 4 del camión; tiene que ir en el 3 para no dejar huecos [cite: 468, 469].
Vamos a bajar esta lógica a tierra con un arreglo SIN SECUENCIAS. Puro Nivel 3 básico [cite: 504].
El Dominio: Tenés un arreglo simple de temperaturas registradas por un sensor: int[] temperaturas = {22, 150, 24, 21, -10, 23, 19, 99};
El sistema nos pide extraer solo las temperaturas válidas (entre 0 y 40 grados inclusive) y guardarlas de forma continua en un arreglo nuevo. Al finalizar, el método debe retornar ese arreglo nuevo al main
*/
    public static final int MIN = 0;
    public static final int MAX = 40;

    public static void main(String[] args) {
        
        int[] temperaturas = {22, 150, 24, 21, -10, 23, 19, 99};

        //int[] tempValidas = new int[temperaturas.length];

        //tempValidas = filtrarTemperaturas(tempValidas);

        int[] tempValidas = filtrarTemperaturas(temperaturas);

        mostrarArreglo(tempValidas);
    }
    
    public static int[] filtrarTemperaturas(int[] temp){
        int indexNuevo = 0;

        int[] validas = new int[temp.length];

        for(int i = 0; i < temp.length; i++){

            if(temp[i] >= MIN && temp[i] <= MAX){

                validas[indexNuevo] = temp[i];
                indexNuevo++;
            }
        }
        return validas;
    }

    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }
}
