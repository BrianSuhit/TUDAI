public class Ejercicio11 {
/*
Pedir al usuario una cantidad en dólares y el tipo de cambio actual
(cuántos pesos equivale 1 dólar). Mostrar por pantalla el
equivalente en pesos.
*/
    public static void main(String[] args) {
        
        int dolares = 0;
        int tipoDeCambio = 0;

        int totalPesos = 0;

        System.out.println("Ingrese la cantidad de dolares que tiene");
        dolares = Utils.leerInt();

        System.out.println("Ingrese el tipo de cambio");
        tipoDeCambio = Utils.leerInt();

        totalPesos = dolares * tipoDeCambio;

        System.out.println("El total en pesos es: " + totalPesos);
    }
}
