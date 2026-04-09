public class DominioReal1 {
/*
Implementar un juego de adivinación en el que la computadora
“piense” un número entre 0 y 99 (puede usar la siguiente
sentencia: int numeroSecreto = (int)(Math.random() * 1000) %
100;) y el usuario intente adivinarlo. El usuario deberá ingresar un
número por teclado y el juego deberá responder si acertó o no. En
caso de no acertar, el juego deberá indicar si el número ingresado
es menor o mayor al número secreto. Este proceso continuará
hasta que el usuario acierte. Al finalizar, el juego deberá informar
la cantidad de intentos que le llevó al jugador acertar el número.
*/
    public static void main(String[] args) {

        int numIngresado = 0;
        int contador = 1;
        
        int numeroSecreto = ((int)(Math.random() * 1000) % 100);

        System.out.println("ingrese un numero");
        numIngresado = Utils.leerInt();

        while(numIngresado != numeroSecreto){

            if(numIngresado > numeroSecreto){
                System.out.println("Incorrecto,el numero ingresado es mayor");
            }
            else{
                System.out.println("Numero equivocado, el numero ingresado es menor");
            }

            System.out.println("ingrese otro numero");
            numIngresado = Utils.leerInt();
        }

        System.out.println("¡acertaste! era el numero: " + numeroSecreto);
        System.out.println("lo lograste en: " + contador + " intentos");
    }
}
