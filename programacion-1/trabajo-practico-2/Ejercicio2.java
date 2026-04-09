public class Ejercicio2 {
/*
Construir un programa que solicite desde teclado un número de
mes y posteriormente notifique por pantalla la cantidad de días de
ese mes. En el caso de que ingrese 2 como número de mes
(febrero) deberá además solicitar ingresar un número de año y,
dependiendo si es bisiesto o no con la siguiente sentencia:
((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0)))
imprimir la cantidad de días correspondiente.
*/
    public static void main(String[] args) {
        
        int numeroDeMes = 0;
        
        System.out.println("Ingrese el numero de mes");
        numeroDeMes = Utils.leerInt();

        switch (numeroDeMes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                System.out.println("El mes tiene 31 dias");
                break;
            case 4: case 6: case 9: case 11:
                System.out.println("El mes tiene 30 dias");
                break;
            case 2:
                int anio = 0;
                
                System.out.println("Ingrese el año");
                anio = Utils.leerInt();

                if((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))){
                    System.out.println("Febrero tiene 29 dias");
                }
                else{
                    System.out.println("Febrero tiene 28 dias");
                }
                break;
            default:
                break;
        }
    }
}
