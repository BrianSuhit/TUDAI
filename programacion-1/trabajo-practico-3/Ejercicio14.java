public class Ejercicio14 {
/*
El proyecto SETI analiza información proveniente de
radiotelescopios e intenta determinar si corresponde a una señal
inteligente de vida extraterrestre. Para este proyecto, se pide un
programa que permita a un operador ingresar valores enteros
positivos (si ingresa 0 termina el turno del operador) que
representan diferentes intensidades captadas por el
radiotelescopio. En el inicio del turno (antes de ingresar los
valores del radiotelescopio), el operador indica el tipo de patrón a
buscar (1 o 2) y la cantidad de repeticiones de dicho patrón. Hay
dos tipos de patrones buscados:
- Patrón primo (1): la intensidad captada es un número
primo.
- Patrón divisor (2): la intensidad captada es múltiplo de
la unidad de la propia intensidad (Ej: el 357 cumple
porque 357 es múltiplo de 7, mientras que 837 no)
El programa debe indicar que se halló el patrón buscado cuando
haya habido tantas repeticiones del patrón como lo indicó el
operador (luego de hallar un patrón las repeticiones comienzan
nuevamente desde 0). Al finalizar el turno, se debe indicar la
cantidad de patrones hallados durante el mismo.
*/
    public static void main(String[] args) {
        
        // solicitar ingreso de valores positivo - si ingresa 0 termina el turno del operador

        // solicitar el tipo de patron a buscar (1 o 2) y la cantidad de repeticiones

        /* si ingresa 1 la intensidad es primo
           si ingresa 2 la intensidad es multiplo de algo */
        
        
    }

    public static int obtenerNumero(){

        final int FLAG = 0;

        int numero = FLAG -1;

        while(numero < FLAG){
            System.out.println("ingrese un numero entero positov");
            numero = Utils.leerInt();
        }
        return numero;
    }

}
