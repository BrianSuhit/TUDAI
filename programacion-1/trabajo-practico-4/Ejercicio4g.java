public class Ejercicio4g {
/*
g. public static int divisorComunMaximo(int num1, int num2){
// determina el divisor común máximo de dos número
enteros

int dcm = 1;
int divisor = 2;
while (divisor < num1 && divisor < num2) {
if (num1 % divisor == 0 && num2 % divisor == 0) {
dcm = divisor;
}
divisor++;
}
return dcm;
}
*/
    public static void main(String[] args) {
        
       System.out.println(divisorComunMaximo(4, 8));
    }

    // el operador tenia que ser <= para que considere el 4 por ejemplo y no corte en el 2 como divisor
    public static int divisorComunMaximo(int num1, int num2){
        int dcm = 1;
        int divisor = 2;
        while (divisor <= num1 && divisor <= num2) {
            if (num1 % divisor == 0 && num2 % divisor == 0) {
                dcm = divisor;
            }
            divisor++;
        }
        return dcm;
    }
}