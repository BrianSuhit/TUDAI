public class Ejercicio12 {
/*
Escribir un programa que solicite al usuario un número de mes
válido (entero) entre 1 y 12 inclusive, muestre por pantalla la
cantidad de días del mes ingresado (suponer febrero de 28 días)
(Mostrar por pantalla la cantidad de días del mes debería
realizarse con un método).
*/
    public static final int MIN = 1;
    public static final int MAX = 12;

    public static void main(String[] args) {
        
        int numeIngresado = validarNumero();

        obtenerDiasMesIngresado(numeIngresado);
        
    }

    public static void obtenerDiasMesIngresado(int numeIngresado) {
        switch (numeIngresado) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                System.out.println("El mes tiene 31 dias");
                break;
            case 4: case 6: case 9: case 11:
                System.out.println("El mes tiene 30 dias");
                break;
            case 2:
                    obtenerDiasExactosFebrero();
                break;
            default:
                break;
        }
    }

    public static void obtenerDiasExactosFebrero() {
        int anio = 0;
        
        System.out.println("Ingrese el año");
        anio = Utils.leerInt();

        if((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))){
            System.out.println("Febrero tiene 29 dias");
        }
        else{
            System.out.println("Febrero tiene 28 dias");
        }
    }

        public static int validarNumero(){

        int numero = MIN -1;
        
        while(numero < MIN || numero > MAX){
            System.out.println("Ingrese un numero entre " + MIN + " y " + MAX);
            numero = Utils.leerInt();
        }
        return numero;
    }

}
