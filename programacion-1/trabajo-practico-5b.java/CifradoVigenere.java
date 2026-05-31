public class CifradoVigenere {
/*
9. Encriptación de mensajes con cifrado Vigenére
Dos naciones están en guerra y necesitan comunicarse de manera segura para evitar que el enemigo
intercepte y lea sus mensajes. Para lograrlo, deciden encriptar sus mensajes utilizando el cifrado de Vigenère.
Este cifrado utiliza una clave con la que se puede encriptar o desencriptar un mensaje, haciendo que solo con
la clave se pueda leer el mensaje.
El cifrado de Vigenère consiste en recorrer el mensaje (de a secuencias) y adelantar en el abecedario cada
caracter según la clave, por ejemplo si nos encontramos una “A” y en la clave hay un “3” el resultado seria “D”
una vez se usó toda la clave se vuelve desde el principio y así sucesivamente hasta terminar con el mensaje.
Por ejemplo, con el siguiente mensaje (arreglo) y con la clave [1,2,3]:

Desgraciadamente, este algoritmo tiene una debilidad, la cual es que si de alguna forma se consigue el
mensaje original sin encriptar y este tiene una secuencia de caracteres iguales de longitud igual o mayor al de
la clave se puede deducir la misma, comprometiendo todo el sistema. Por ende, aunque quede algo del
mensaje sin encriptar se tomó la decisión de no encriptar la secuencia que tenga varios caracteres seguidos
iguales que iguale o supere la longitud de la clave.
*/

    public static final int SEPARADOR = ' ';

    public static void main(String[] args) {
        
        char[] V = {' ', 'h', 'o', 'l', 'a', ' ', 'c', 'o', 'm', 'o', ' ', 'e', 's', 't', 'a', 's', ' '};

        /* resultado que se debe verificar:
            |   | i | q | o | b |   | e | r | n | q |   | h | t | v | d | t |
        */
       procesarCifrado(V);
    }

    public static void procesarCifrado(char[] arr){
        int ini = 0, fin = -1;

        while(ini < arr.length){
            ini = buscarInicio(arr, fin + 1);

            if(ini < arr.length){
                fin = buscarFin(arr, ini);


            }
        }

    }

    public static boolean elementosRepetidos(int[] mensaje, int ini, int fin, int[] clave){
        if(fin - ini + 1 != clave.length){
            return false;
        }

        int repetidos = 0;

        while(ini < fin && fin - ini + 1 >= clave.length && repetidos < clave.length){
            if(mensaje[ini] == mensaje[ini + 1]){
                repetidos++;
            }
            else{
                repetidos = 0;
                ini++;
            }
        }
        return ini == fin;
    }

    public static int buscarInicio(char[] arr, int pos) {
        while(pos < arr.length && arr[pos] < SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(char[] arr, int pos) {
        while(pos < arr.length && arr[pos] >= SEPARADOR){
            pos++;
        }
        return pos - 1;
    }
}
