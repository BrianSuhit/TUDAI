public class FoodTruck{
/*
4. Food Truck
Un food truck almacena los importes de sus ventas en un evento gastronómico en una matriz de NxM, en donde cada fila
representa las ventas de un día (el evento puede durar varios días). Dentro de cada día, la información es almacenada
en secuencias separadas por 0 (uno o más) donde cada secuencia representa las ventas realizadas durante una
determinada hora. Por ejemplo, la siguiente tabla muestra las ventas realizadas durante el feriado largo del Día de la
Bandera (4 días), en el cual durante la primera hora de trabajo del primer día del evento se realizaron las siguientes
ventas: $625, $815 y $900.
El dueño del food truck está analizando la incorporación de más personal, por lo tanto, desea conocer si al menos en X
días consecutivos, el promedio de ventas por hora, se incrementó crecientemente (en forma ascendente).
En ejemplo anterior, con un X = 2 se deberá informar que SÍ hubo al menos 2 días cuyo promedio de ventas por hora se
incrementó crecientemente. Esto es así porque en el día 2 (fila 1) los promedios de cada hora fueron: $324,5; $606,33 y
$820 respectivamente, mientras que en el día 3 (fila 2) los promedios de cada hora fueron: $478,5; $733,33 y $907.

Se pide implementar en Java un programa que informe lo solicitado por el dueño del food truck. IMPORTANTE: el
ejemplo es meramente ilustrativo, la solución planteada debe ser válida para cualquier matriz y valor de X. Aplicar
TODAS las buenas prácticas vistas en la materia. No usar estructuras auxiliares.
*/
    public static final int SEPARADOR = 0;
    public static void main(String[] args) {
        int[][] matriz = {
            {0, 625, 815, 900, 0, 562, 952, 300, 0, 365, 169, 254, 0, 0, 0},
            {0, 958, 62, 57, 221, 0, 596, 623, 600, 0, 587, 889, 984, 0, 0},
            {0, 0, 700, 257, 0, 0, 0, 854, 958, 388, 0, 954, 842, 925, 0},
            {0, 988, 899, 874, 0, 254, 258, 652, 200, 0, 568, 958, 210, 0, 0}
        };

        int x = 2;

        procesarDias(matriz, x);
    }

    public static void procesarDias(int[][] mat, int X){
        int fila = 0, contadorRachas = 0;
        boolean rachaConsecutiva = false;

        while(fila < mat.length && !rachaConsecutiva){

            boolean esCreciente = procesarHoras(mat[fila]);

            if(esCreciente){
                contadorRachas++;
                if(contadorRachas >= X){
                    rachaConsecutiva = true;
                }
            }else{
                contadorRachas = 0;
            }
            fila++;
        }
        
        if(rachaConsecutiva){
            System.out.println("hubo almenos : " + contadorRachas + " dias de rachas");
        }else{
            System.out.println("No se cumplio la racha de dias");
        }
    }

    public static boolean procesarHoras(int[] arr){
        int ini = 0, fin = -1, promedioAnterior = -1;
        boolean esCreciente = true;

        while(ini < arr.length && esCreciente){
            ini = buscarInicio(arr, fin + 1);

            if(ini < arr.length){
                fin = buscarFin(arr, ini);

                int promedioActual = calcularPromedio(arr, ini, fin);

                if(promedioAnterior != -1){
                   if(promedioActual <= promedioAnterior){
                        esCreciente = false;
                   }
                }
                promedioAnterior = promedioActual;
            }
        }
        return esCreciente;
    }

    public static int calcularPromedio(int[] arr, int ini, int fin){
        int tam = fin - ini + 1, suma = 0, promedio = 0;

        for(int i = ini; i <= fin; i++){
            suma += arr[i];
        }
        promedio = suma / tam;
        return promedio;
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
}