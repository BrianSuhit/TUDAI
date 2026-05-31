public class Ejercicio41 {
/*
41. El algoritmo de Luhn o fórmula de Luhn, es una fórmula de
suma de verificación, utilizada para validar una diversidad de
números de identificación; como números de tarjetas de crédito,
números IMEI, etc. Implementar un programa que determine si un
número almacenado digito a digito (de 0 a 9) en un arreglo de
tamaño 16 corresponde a un número correcto según el algoritmo
de Luhn. Dicho algoritmo consiste en duplicar cada dígito en
posición par comenzando de derecha a izquierda. Por ejemplo,
dado el siguiente arreglo de dígitos:

7 9 9 2 7 3 9 8 7 1 3

Se debe comenzar de derecha a izquierda con el 1 y
duplicarlo, luego con el 8, 3, 2 y 9 (en negrita). Luego de
este primer paso el arreglo resultante será:

7 18 9 4 7 6 9 16 7 2 3

Como segundo paso, si alguno de los números duplicados
tuviese dos dígitos se los debe sumar y obtener así un
solo dígito:

7 9 9 4 7 6 9 7 7 2 3

Por último, se debe sumar todos los valores del arreglo
(7+9+9+4+7+6+9+7+7+2+3=70). Si dicha suma es múltiplo de
10 el número es correcto, caso contrario es incorrecto.
*/
    public static void main(String[] args) {
        
        int[] arreglo = {7, 9, 9, 2, 7, 3, 9, 8, 7, 1, 3};

        for(int i = arreglo.length - 1; i >= 0; i--){

            if(i % 2 != 0){
                int duplicado = arreglo[i] * 2;
                if(duplicado >= 10){
                    arreglo[i] = (duplicado/10) + (duplicado%10);
                }
                else{
                    arreglo[i] = duplicado;
                }
            }
        }

        int contador = 0;

        for(int i = 0; i < arreglo.length; i++){
            contador = contador + arreglo[i];
        }

        if(contador % 10 == 0){
            mostrarArreglo(arreglo);
        }
    }

    public static void mostrarArreglo(int[] arr) {
        for (int pos = 0; pos < arr.length; pos++)
            System.out.print(" | " + arr[pos]);
        System.out.println();
    }
}
