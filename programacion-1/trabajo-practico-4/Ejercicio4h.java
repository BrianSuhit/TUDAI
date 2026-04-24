public class Ejercicio4h {
/*
h. public static String decimalABinario(int num) {
// convierte un número decimal a su representación
binaria
String binario = "";
while (num > 0) {
int resto = num % 2;
binario = resto + binario;
num = num / 2;
}
return binario;
}
*/
    public static void main(String[] args) {
        
        System.out.println(decimalABinario(0));
    
    }

    public static String decimalABinario(int num) {
        // hacemos un if para el 0 sino devuelve nada, vacio
        if (num == 0) {
            return "0";
        }
        
        String binario = "";
        while (num > 0) {
            int resto = num % 2;
        
            binario = resto + binario;
            num = num / 2;
        }
        return binario;
    }
}