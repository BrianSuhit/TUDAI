public class Ejercicio5 {
/*
Escribir un programa que dado tres números reales ingresados
por el usuario, divida el primero por el segundo y al resultado
obtenido le reste el tercero. Muestre por pantalla el resultado
obtenido. Puede o no usar variables auxiliares para los cálculos.
¿Puede ocurrir algún error? 
*/
    public static void main(String[] args) {
        
        double numero1 = 0.0;
        double numero2 = 0.0;
        double numero3 = 0.0;

        double resultado = 0.0;

        System.out.println("Ingrese el primer numero");
        numero1 = Utils.leerDouble();

        System.out.println("Ingrese el segundo numero");
        numero2 = Utils.leerDouble();

        System.out.println("Ingrese el tercer numero");
        numero3 = Utils.leerDouble();

        resultado = (numero1 / numero2) - numero3;

        System.out.println("El resultado es: " + resultado);
    }
}
