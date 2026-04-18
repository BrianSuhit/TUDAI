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

    public static final int PATRON_PRIMO = 1;
    public static final int PATRON_DIVISOR = 2;
    public static final int FIN_TURNO = 0;

    public static void main(String[] args) {
        
        int tipoPatron = obtenerTipoPatron();
        int repeticionesBuscadas = obtenerRepeticiones();

        int intensidad = obtenerIntensidad();
        
        int contadorRepeticiones = 0;
        int patronesHallados = 0;
        
        while (intensidad != FIN_TURNO) {
            boolean cumple = false;
            
            if (tipoPatron == PATRON_PRIMO) {
                cumple = esPrimo(intensidad);
            } else if (tipoPatron == PATRON_DIVISOR) {
                cumple = esPatronDivisor(intensidad);
            }
            
            if (cumple) {
                contadorRepeticiones++;
                if (contadorRepeticiones == repeticionesBuscadas) {
                    System.out.println("Se halló el patrón buscado.");
                    patronesHallados++;
                    contadorRepeticiones = 0;
                }
            }
            
            intensidad = obtenerIntensidad();
        }
        
        System.out.println("Fin del turno. Cantidad de patrones hallados: " + patronesHallados);
    }

    public static int obtenerTipoPatron() {
        int patron = 0;
        while (patron != PATRON_PRIMO && patron != PATRON_DIVISOR) {
            System.out.println("Ingrese el tipo de patrón a buscar (" + PATRON_PRIMO + ": Primo, " + PATRON_DIVISOR + ": Divisor):");
            patron = Utils.leerInt();
        }
        return patron;
    }

    public static int obtenerRepeticiones() {
        int rep = 0;
        while (rep <= 0) {
            System.out.println("Ingrese la cantidad de repeticiones del patrón (mayor a 0):");
            rep = Utils.leerInt();
        }
        return rep;
    }

    public static int obtenerIntensidad() {
        int intensidad = -1;
        while (intensidad < FIN_TURNO) {
            System.out.println("Ingrese la intensidad captada (entero positivo) o " + FIN_TURNO + " para terminar:");
            intensidad = Utils.leerInt();
        }
        return intensidad;
    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= numero / 2; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean esPatronDivisor(int numero) {
        int unidad = numero % 10;
        if (unidad == 0) {
            return false;
        }
        return numero % unidad == 0;
    }

}
