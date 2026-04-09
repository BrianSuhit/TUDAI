public class Ejercicio13 {
/*
Construir un programa que solicite desde teclado un número de
mes válido y posteriormente notifique por pantalla la cantidad de
días de ese mes. En el caso de que ingrese 2 como número de
mes (febrero) deberá además solicitar ingresar un número de año
entre 2000 y 2024 inclusive (no debe seguir si no está en ese
rango), y dependiendo de si es bisiesto o no imprimir la cantidad
de días correspondiente.
*/
    public static void main(String[] args) {
        
        int mesIngresado = 0;

        while(mesIngresado < 1 || mesIngresado > 12){

            System.out.println("ingrese un numero de mes");
            mesIngresado = Utils.leerInt();

            switch (mesIngresado) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    System.out.println("El mes tiene 31 dias");
                    break;
                case 4: case 6: case 9: case 11:
                    System.out.println("El mes tiene 30 dias");
                    break;
                case 2:
                    int anio = 0;
                    
                    System.out.println("Ingrese el año, tiene que ser entre 2000 y 2024");
                    anio = Utils.leerInt();

                    // era un while no un if con break - era mala practica eso
                    while (anio < 2000 || anio > 2024) {
                        System.out.println("Error. Ingrese el año (2000 - 2024):");
                        anio = Utils.leerInt();
                    }

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
}
