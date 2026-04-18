public class Ejercicio10 {
/*
10. Escribir un programa que simule 1000 lanzamientos de un dado
y muestre por pantalla cuántas veces salió el valor del dado
correspondiente al número entero N ingresado por el usuario.
Considerar que el valor N ingresado se corresponda a un valor
posible para un dado. Usar la sentencia Math.random() que
devuelve un valor aleatorio real entre 0 y 1.
Para asignar un posible valor a la variable dado entero:
dado = (int) (6 * Math.random() + 1)
*/
    public static final int LANZAMIENTOS = 1000;

    public static final int MULTIPLICADOR = 6;

    public static void main(String[] args) {
            
        int n = obtenerNumero();


        int contador = 0;

        for(int c = 0; c < LANZAMIENTOS; c++){

            if(lanzarDado() == n){
                contador++;
            }
        }
        System.out.println("el numero " + n + " salio " + contador + " veces");
    }

    public static int obtenerNumero(){

        int n = 0;
        System.out.println("ingrese un numero aleatorio entre 1 y " + MULTIPLICADOR);
        n = Utils.leerInt();

        return n;
    }

    public static int lanzarDado(){

      return (int) (MULTIPLICADOR * Math.random() + 1);
    }
}
