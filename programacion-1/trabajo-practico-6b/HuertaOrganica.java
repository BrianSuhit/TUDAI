public class HuertaOrganica {
/*
1. Huerta Orgánica
Una huerta orgánica desea combatir las malezas con un innovador sistema robótico. Dicho sistema utiliza inteligencia
artificial para detectar la especie de cada ejemplar vegetal que crece en la huerta. La huerta está organizada en N
surcos. El sistema recorre cada surco y registra las especies a las que pertenece cada ejemplar vegetal que encuentra a
su paso. Por cada ejemplar vegetal, registra, en una matriz V de N x M, su especie, utilizando un carácter alfabético
minúscula o mayúscula. Las plantas cultivadas se identifican con letras minúsculas mientras que el resto de la
vegetación, tanto las plantas beneficiosas como las malezas, se identifican con letras mayúsculas. A modo de ejemplo, la
siguiente matriz representa una huerta de 3 surcos de longitud 20, en cuyo primer surco se cultiva Solanum lycopersicum
(tomate, ‘t’) y Ocimum basilicum (albahaca, ‘a’). Además, se pueden ver otras plantas identificadas: Calendula officinalis
(calendula, ‘C’), Ocimum basilicum (chamico, ‘M’) y Urtica dioica (ortiga, ‘O’) . Además, cada fila comienza y termina con
uno o más caracteres ‘x’ para facilitar el procesamiento (no corresponde a ninguna especie).
Para eliminar las malezas, el robot posee un láser que destruye las plantas indicadas. Para preservar los cultivos, el
láser sólo puede accionarse cuando existen más de R especies vegetales no cultivadas consecutivas. No obstante, en
estas situaciones, no todas las plantas no cultivadas son destruidas, sino sólo aquellas que no son beneficiosas para la
huerta. Para ello, se cuenta con un arreglo B (de tamaño MAXB) que indica al sistema cuáles se consideran plantas
beneficiosas.
Se pide implementar un programa en Java que indique cómo quedaría la huerta, representada por una matriz V, luego
de aplicar el láser del robot, considerando un arreglo de plantas beneficiosas B y un valor R. Además, se debe informar
la cantidad total de malezas eliminadas en toda la huerta.
Continuando con el ejemplo anterior, dado B={‘C’, ‘O’, ‘L’} de tamaño MAXB = 3 y un valor R=2 la cantidad total de malezas eliminadas fue 9.
*/
    public static void main(String[] args) {
        
        char[][] matrizV = {
            {'x', 't', 'a', 'C', 'M', 'O', 't', 'a', 'a', 't', 'O', 'C', 't', 't', 'a', 'O', 'M', 'C', 't', 'x'},
            {'x', 'r', 'r', 'r', 'C', 'C', 'O', 'O', 'r', 'r', 'C', 'r', 'G', 'G', 'G', 'r', 'r', 'x', 'x', 'x'},
            {'x', 'm', 'G', 'm', 'h', 'h', 'L', 'G', 'G', 'O', 'h', 'h', 'm', 'm', 'O', 'B', 'M', 'C', 'x', 'x'}
        };
    
        char[] arregloB = {'C', 'O', 'L'};
        int r = 2;

        int totalEliminadas = procesarHuerta(matrizV,arregloB,r);
        System.out.println("LA CANTIDAD DE MALEZA ELIMINADA ES: "+totalEliminadas);
    }

    public static int procesarHuerta(char[][] mat, char[] arrB, int r){
        int totalMalezas = 0;
        for(int fila = 0; fila < mat.length; fila++){

            totalMalezas += procesarSurco(mat[fila], arrB, r);
        }
        return totalMalezas;
    }

    public static int procesarSurco(char[] fila, char[] arregloB, int r) {
        int malezasEliminadasFila = 0;
        int ini = 0;
        int fin = -1;

        while (ini < fila.length) {
            ini = buscarInicio(fila, fin + 1);

            if (ini < fila.length) {
                fin = buscarFin(fila, ini); 
                
                int tamaño = fin - ini + 1;

                if (tamaño > r) {
                    
                    int eliminadas = aplicarLaserNivel5(fila, ini, fin, arregloB);
                    malezasEliminadasFila += eliminadas;
                    fin -= eliminadas;
                }
            }
        }
        return malezasEliminadasFila;
    }

    public static int aplicarLaserNivel5(char[] fila, int ini, int fin, char[] arrB){
        int eliminadas = 0;
        
        while(ini <= fin){ 
            
            if (esMayuscula(fila[ini]) && !esBeneficiosa(fila[ini], arrB)) {
                corrimientoIzquierda(fila, ini);
                fin--;
                eliminadas++; 
            } else {
                ini++;
            }
        }
        return eliminadas;
    }

    public static void corrimientoIzquierda(char[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
    }

    public static boolean esBeneficiosa(char letra, char[] arrB){
        int i = 0;
        boolean loEncontre = false;

        while(i < arrB.length && !loEncontre){
            if (arrB[i] == letra) {
                loEncontre = true;
            }
            i++;
        }
        return loEncontre;
    }

    public static boolean esMayuscula(char letra){
        return letra >='A' && letra <= 'Z' && letra != 'x';
    }

    public static int buscarInicio(char[] arr, int pos){
        while(pos < arr.length && !esMayuscula(arr[pos])){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(char[] arr, int pos){
        while(pos < arr.length && esMayuscula(arr[pos])){
            pos++;
        }
        return pos - 1;
    }
}
