public class Ejercicio1 {
    
    public static void main(String[] args) {
        
        final int CONDICION_A = 0;
        final int CONDICION_B = 100;
        int numero = 0;

        System.out.println("Ingrese un numero entero");

        numero = Utils.leerInt();

        if(numero > CONDICION_A){
            System.out.println("el numero es positivo");
        }
        else if (numero == CONDICION_A){
            System.out.println("el numero es cero");
        }
        else {
            System.out.println("el numero es negativo");
        }

        if(numero > CONDICION_B){
            System.out.println("Grande");
        }
        else{
            System.out.println("Chico");
        }

    //-----------------------------------------------------------
        int numeroAdeterminar = 0;

        System.out.println("ingrese un numero del 1 al 7");
        numeroAdeterminar = Utils.leerInt();

        switch (numeroAdeterminar) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miercoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sabado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default:
                System.out.println("ingrese un numero del 1 al 7 por favor");
                numeroAdeterminar = Utils.leerInt();
                break;
        }

    //-----------------------------------------------------------
    // D -
        char letra = ' ';

        System.out.println("Ingrese una letra");
        letra = Utils.leerChar();

        switch (letra) {
            case 'a':
                System.out.println("Es la vocal A");
                break;
            case 'e':
                System.out.println("Es la vocal E");
                break;
            case 'i':
                System.out.println("Es la vocal I");
                break;
            case 'o':
                System.out.println("Es la vocal O");
                break;
            case 'u':
                System.out.println("Es la vocal U");
                break;
            default:
                System.out.println("ingreso la consonante: " + letra);
                break;
        }
    
    //----------------------------------------------------------------------
    // E -
        int a = 0;
        int b = 0;
        int c = 0;

        System.out.println("Ingrese el primer numero");
        a = Utils.leerInt();

        System.out.println("Ingrese el segundo numero");
        b = Utils.leerInt();

        System.out.println("Ingrese el tercer numero");
        c = Utils.leerInt();

        if(a < b && b < c){
            System.out.println("Creciente");
        }
        else if(a > b && b > c){
            System.out.println("Decreciente");
        }
        else{
            System.out.println("error");
        }

    }
}
