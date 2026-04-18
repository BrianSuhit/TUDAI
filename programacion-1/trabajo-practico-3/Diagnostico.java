public class Diagnostico {
    

    /*
    solicitar un numero entero positivo y calcular su factorial el factorial de un numero n es el producto de todos los numeros enteros positivos desde 1 hasta n.
    
    // solicitar un numero positivo al usuario

    calcular el factorial ( desde 1 hasta n y multiplicar todos)
    
    */
   public static void main(String[] args) {
    
        int resultado = 1;


        System.out.println("ingese un numero positivo");
        int numero = Utils.leerInt();

        for(int i = numero; i >= 1; i--){

            resultado = resultado * i;
        }
        System.out.println("el factorial de " + numero + " es: " + resultado);
   }
}
