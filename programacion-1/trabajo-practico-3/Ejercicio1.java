public class Ejercicio1 {
/*
Escribir un diseño de programa que mientras que el usuario
ingrese un número distinto de 0, pida ingresar otro número y lo
imprima.
*/
    public static void main(String[] args) {
        
        obtenerNumero();
    }

    public static int obtenerNumero(){
        int numero = -1;

        while(numero != 0){
            // FILTRO: Solo imprimimos si el número NO es el -1 inicial
            if (numero != -1) {
                System.out.println("El numero ingresado es: " + numero);
            }
            
            System.out.println("Ingrese un numero (0 para salir):");
            numero = Utils.leerInt();
        }
        return numero;
    }
}
