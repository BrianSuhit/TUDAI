public class Ejercicio5 {
    
    public static void main(String[] args) {
                
        int numero = 0;

        System.out.println("ingrese un numero");
        numero = Utils.leerInt();

        while(numero > 1 && numero < 100){

            if((numero % 2 == 0) && (numero % 3 == 0)){
                System.out.println("el numero es multiplo de 2 y 3");
            }
            else{
                System.out.println("el numero no es multiplo de 2 y 3");
            }
            System.out.println("ingrese un numero");
            numero = Utils.leerInt();
        }
    }
}
