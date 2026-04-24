public class Ejercicio4f {
/*
f. public static boolean buscarDigito(int num, int digito) {
// determina si en num está presente un determinado
dígito
boolean encontrado = false;
int resto;
while (num > 0) {
resto = num % 10;
if (resto == digito) {
encontrado = true;
} else {
encontrado = false;
}
num = num / 10;
}
return encontrado;
}
*/
    public static void main(String[] args) {
        
        System.out.println(buscarDigito(456, 5 ));
    }

    public static boolean buscarDigito(int num, int digito) {
        boolean encontrado = false;
        int resto;
        // tambien ponemos la condicion en el while, no podemos usar break
        while (num > 0 && !encontrado) {
            resto = num % 10;
            if (resto == digito) {
                encontrado = true;
            } // } else {
            //     encontrado = false;
            // }
            num = num / 10;
        }
    return encontrado;
}
}