public class Ejercicio12 {
/*
12. Hacer un programa que verifique en un arreglo si tiene al
menos N números primos. N debe ser ingresado por el usuario.
Reutilizar los métodos ya desarrollados.
*/
    public static final int MIN = 1;
    public static final int TAM = 10;

    public static void main(String[] args) {
        
        int[] arreglo = {7, 5, 9, 8, 9, 6, 10, 7, 5, 4};

        int numero = validarNumero();

        verificarPrimos(arreglo, numero);
       
    }

    public static void verificarPrimos(int[] arreglo, int numero){
        int pos = 0;
        int primosEncontrados = 0;
        while(pos < TAM && primosEncontrados < numero){

            if(esPrimo(arreglo[pos])){
                primosEncontrados++;
            }
            pos++;
        }

        if(primosEncontrados == numero) {
            System.out.println("El arreglo tiene al menos " + numero + " numero/s primo/s.");
        } else {
            System.out.println("El arreglo NO tiene al menos " + numero + " numero/s primo/s (solo tiene " + primosEncontrados + ").");
        }
    }

    public static int validarNumero(){

        int numero = MIN -1;
            
        while(numero < MIN){
            System.out.println("Ingrese un numero arriba de: " + MIN);
            numero = Utils.leerInt();
        }
        return numero; 
    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= numero / 2; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
