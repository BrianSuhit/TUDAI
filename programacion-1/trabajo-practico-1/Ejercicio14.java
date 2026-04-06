public class Ejercicio14 {
/*
Dados los siguientes códigos, analizar y detectar los errores.
Justificar en cada caso.
a. Suponiendo dos números enteros dados, se pide imprimir:
i. si ambos son positivos y el primero es múltiplo de 5 y
el segundo múltiplo de 7.
ii. si el primero es mayor a 3 veces el segundo o es
múltiplo del segundo.
iii. si el primero es menor al segundo y la suma es par
*/
    public static void main(String[] args) {
        
        int numero1=34, numero2=67; // valores de ejemplo
        boolean resultado1, resultado2, resultado3;

        // resultado1=(numero1&&numero2 >0) && numero1/5==0 &&
        // numero2/7==0;
        // resultado2=(numero2<3*numero1)||numero1%numero2==1;
        // resultado3=numero1<numero2 && numero2+numero1%2==0;

        resultado1=(((numero1 > 0) && (numero2 >0)) && ((numero1 % 5==0) && (numero2 / 7==0))); //operador de % 
        resultado2=((numero1 < (3 * numero2)) || (numero1 % numero2==0)); //invertir variables num1 y num2 - resto 0 al final
        resultado3=((numero1 < numero2) && ((numero2+numero1) %2==0));

        System.out.println ("Inciso i: " + resultado1);
        System.out.println ("Inciso ii: " + resultado2);
        System.out.println ("Inciso iii: " + resultado3);
    }
}
