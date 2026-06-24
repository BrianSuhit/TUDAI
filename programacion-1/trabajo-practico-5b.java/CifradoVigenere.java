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
        
        char[] mensaje = {' ', 'h', 'o', 'l', 'a', ' ', 'c', 'o', 'm', 'o', ' ', 'e', 's', 't', 'a', 's', ' '};
        int[] clave = {1, 2, 3};
        
        System.out.println("Mensaje Original:");
        mostrarArreglo(mensaje);

        procesarMensaje(mensaje, clave);

        System.out.println("Mensaje Encriptado:");
        mostrarArreglo(mensaje);
    }

    public static void procesarMensaje(char[] mensaje, int[] clave) {
        int ini = 0;
        int fin = -1;
        int posclave = 0;

        while (ini < mensaje.length) {
            ini = buscarInicio(mensaje, fin + 1);
            
            if (ini < mensaje.length) {
                fin = buscarFin(mensaje, ini);
                
                if (!elementosRepetidos(mensaje, ini, fin, clave.length)) {
                    posclave = encriptar(mensaje, ini, fin, clave, posclave);
                }
            }
        }
    }

    public static boolean elementosRepetidos(char[] mensaje, int ini, int fin, int tamanioClave) {
        int tamanio = fin - ini + 1;
        if (tamanio < tamanioClave) return false;

        int repetidos = 1;
        boolean rachaEncontrada = false;
        int i = ini;

        while (i < fin && !rachaEncontrada) {
            if (mensaje[i] == mensaje[i + 1]) {
                repetidos++;
                if (repetidos == tamanioClave) {
                    rachaEncontrada = true; 
                }
            } else {
                repetidos = 1;
            }
            i++;
        }
        
        return rachaEncontrada;
    }

    public static int encriptar(char[] mensaje, int ini, int fin, int[] clave, int posclave) {
        for (int i = ini; i <= fin; i++) {
            mensaje[i] = (char) (mensaje[i] + clave[posclave]);
            posclave++;
            
            if (posclave == clave.length) {
                posclave = 0;
            }
        }
        return posclave;
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

    public static void mostrarArreglo(char[] arr) {
        for (int pos = 0; pos < arr.length; pos++)
            System.out.print(" | " + arr[pos]);
        System.out.println();
    }
}
