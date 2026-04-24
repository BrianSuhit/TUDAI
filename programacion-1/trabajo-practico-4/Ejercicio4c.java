public class Ejercicio4c {
/*
c. public static boolean esPrimo(int numero) {
// devuelve si es primo el numero o no
int divisor=2;
boolean esPrimoNum=true;
if (numero < 2)
return false;
while (divisor < numero && esPrimoNum){
if (numero%divisor++==0)
esPrimoNum=true;
}
return esPrimoNum;
}
*/
    public static void main(String[] args) {
        
        esPrimo(3);

    }

    public static boolean esPrimo(int numero) {
        int divisor = 2;
        boolean esPrimoNum = true;
        
        if (numero < 2)
            return false;
        
        // RETORNA QUE ES PRIMO LOS NUMEROS QUE NO SON PRIMOS, CAMBIAR EL TRUE A FALSE
        while (divisor < numero && esPrimoNum){
            if (numero % divisor++ == 0)
                esPrimoNum = false;
        }
        return esPrimoNum;
    }
}