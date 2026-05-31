public class MonitoreoDeHornos {
/*
📝 SIMULACRO NIVEL 1: "Alerta de Sobrecalentamiento"
La Consigna: Una planta industrial monitorea las temperaturas de sus hornos a lo largo del día. Las lecturas (en grados) se guardan en un arreglo de secuencias separadas por ceros (0). Cada secuencia representa un ciclo de horneado.
El sistema de seguridad debe disparar una alerta si detecta que la temperatura en un ciclo subió sin control. Se considera que un ciclo está en "Sobrecalentamiento Peligroso" si cumple simultáneamente estas dos condiciones:
Tamaño: El ciclo tuvo al menos 2 lecturas registradas (tamaño >= 2).
Patrón Interno: Las temperaturas fueron estrictamente ascendentes de principio a fin de la secuencia. Es decir, cada temperatura registrada fue mayor a la temperatura inmediatamente anterior. (Ojo: si dos temperaturas seguidas son iguales, ya no es "estrictamente" ascendente y se considera seguro).
Se te pide recorrer el arreglo y contar cuántos ciclos entraron en sobrecalentamiento. Al finalizar, el programa debe imprimir: "Se detectaron X ciclos en peligro".
*/
    public static final int SEPARADOR = 0;
    public static final int TAMANIO_MIN = 2;

    public static void main(String[] args) {
        
        // Ciclo 1: 40, 42, 45 (Tamaño 3. Cumple tamaño y 40 < 42 < 45). -> ¡PELIGRO!
        // Ciclo 2: 50, 55, 55, 60 (Tamaño 4. Cumple tamaño, pero falla patrón porque 55 no es menor a 55).
        // Ciclo 3: 80 (Tamaño 1. Falla por tamaño).
        // Ciclo 4: 60, 65, 70, 72 (Tamaño 4. Cumple tamaño y es todo ascendente). -> ¡PELIGRO!
        // Resultado esperado final: "Se detectaron 2 ciclos en peligro"
        
        int[] arrTemperaturas = {0, 40, 42, 45, 0, 50, 55, 55, 60, 0, 80, 0, 60, 65, 70, 72, 0, 0};

        int ini = 0;
        int fin = -1;
        int contadorPeligro = 0;

        while(ini < arrTemperaturas.length){
            ini = buscarInicio(arrTemperaturas, fin + 1);

            if(ini < arrTemperaturas.length){
                fin = buscarFin(arrTemperaturas, ini);

                int tamaño = fin - ini + 1;

                if(tamaño >= TAMANIO_MIN && esAscendente(arrTemperaturas, ini, fin)){
                    contadorPeligro++;
                }
            }
        }
        System.out.println("Se detectaron: " + contadorPeligro + " ciclos en peligro");
    }

    public static boolean esAscendente(int[] arr, int ini, int fin){

        while(ini < fin && arr[ini] < arr[ini + 1]){
            ini++;
        }
        return ini == fin;
    }

    public static int buscarInicio(int[] arr, int pos){
        while(pos < arr.length && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos){
        while( pos < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos - 1;
    }
}
