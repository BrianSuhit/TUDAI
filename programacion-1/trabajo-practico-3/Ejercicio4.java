public class Ejercicio4 {
/*
Hacer un método que dado un número entero con valor inicial 1,
haga una iteración incrementando el número de a uno hasta un
valor MAX = 4 (constante). Mientras itera deberá imprimir el
número. Luego invocarlo desde el programa principal y cuando
termina, imprimir por pantalla “terminó”.

*/
    public static final int MAX = 4;

    public static void main(String[] args) {
        
        iterarValor();
        System.out.println("Termino");
    }

    public static void iterarValor(){

        for(int valor = 1; valor <= MAX; valor++){
            System.out.println("El valor es: " + valor);
        }
    }
}
