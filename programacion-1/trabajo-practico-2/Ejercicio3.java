public class Ejercicio3 {
    
    public static void main(String[] args) {
        
        int numero = 0;

        System.out.println("Ingrese un numero mayor a 50");
        numero = Utils.leerInt();

        if((numero > 50) && ((numero % 2 == 0) || (numero % 3 ==0))){
            System.out.println("su numero ingresado es: " + numero);
        }
        else{
            System.out.println("error");
        }
    }
}
