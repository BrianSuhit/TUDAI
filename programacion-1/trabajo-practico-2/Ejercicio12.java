public class Ejercicio12 {
/*
Pedir por consola 15 caracteres. Imprimir la mayor cantidad de
‘a’ seguidas que se ingresaron.
*/
    public static void main(String[] args) {
        
        char caracter = '0';

        int cantidadActual = 0;
        int cantidadMaxima = 0;

        final int MAX_CARACTERES  = 15;

        for(int i = 0; i < MAX_CARACTERES ; i++)
        {
            System.out.println("ingrese un caracter");
            caracter = Utils.leerChar();

            if(caracter == 'a'){
                // necesitaba contar las seguidas asique debia hacer un if de racha actual y maxima
                cantidadActual++;
                if(cantidadActual > cantidadMaxima){
                    cantidadMaxima = cantidadActual;
                }
            }
            else{
                cantidadActual = 0;
            }
        }

        System.out.println("La mayor cantidad de 'a' seguidas fue: " + cantidadMaxima);

        //----------------------------------------------------

        for(int i = 0; i < MAX_CARACTERES; i++) {
            System.out.println("ingrese un caracter");
            caracter = Utils.leerChar();
            
            if (caracter == 'a') {
                cantidadActual++;
            } 
            else {
                if (cantidadActual > cantidadMaxima) {
                    cantidadMaxima = cantidadActual;
                }
                cantidadActual = 0;
            }
        }
        if (cantidadActual > cantidadMaxima) {
            cantidadMaxima = cantidadActual;
        }



    }
}
