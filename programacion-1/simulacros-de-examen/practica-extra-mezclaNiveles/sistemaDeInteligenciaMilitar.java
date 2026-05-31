public class sistemaDeInteligenciaMilitar {
/*
1. Sistema de Censura de Inteligencia Militar
La central de inteligencia intercepta mensajes de radio enemigos. Estos mensajes se almacenan en un arreglo M de caracteres de tamaño MAXM. Cada palabra interceptada es una secuencia de letras minúsculas separada por uno o más espacios (' '). El arreglo siempre empieza y termina con uno o más espacios.
Los analistas descubrieron que el enemigo esconde un "código de ataque" secreto incrustado adentro de palabras comunes para pasar desapercibido. Este código secreto se encuentra almacenado en un arreglo C de tamaño MAXC, el cual contiene una ÚNICA secuencia de caracteres rodeada también de espacios al inicio y al final [cite: 387, 388].
Se pide implementar un programa en Java que recorra el arreglo de mensajes M. Por cada palabra, se debe verificar si contiene el código secreto de C escondido en su interior [cite: 388].
Si lo contiene: la palabra representa una amenaza y debe ser eliminada por completo del arreglo M. Además, se debe imprimir por consola: "Se censuró la palabra número X" (donde X es el orden de aparición de la palabra en el mensaje original: 1, 2, 3...).
Si no lo contiene: la palabra se deja intacta.
Un ejemplo de arreglo de mensaje M puede ser (MAXM = 22): {' ', 'e', 'l', ' ', 'p', 'i', 'r', 'a', 't', 'a', ' ', 'a', 't', 'a', 'c', 'a', ' ', 'h', 'o', 'y', ' ', ' '} (Palabras: 1="el", 2="pirata", 3="ataca", 4="hoy").
Y un arreglo de código C (MAXC = 5): {' ', 'a', 't', 'a', ' '} (Código a buscar: "ata").
Para este caso, el arreglo M resultante quedaría de la siguiente forma: {' ', 'e', 'l', ' ', 'h', 'o', 'y', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
Por consola se debió imprimir: Se censuró la palabra número 2 Se censuró la palabra número 3
IMPORTANTE: El ejemplo es meramente ilustrativo, la solución planteada debe ser válida para cualquier arreglo. Aplicar TODAS las buenas prácticas vistas en la materia. No usar estructuras auxiliares
*/
    public static final char SEPARADOR = ' ';
    public static void main(String[] args) {
        
        char[] M = {' ', 'e', 'l', ' ', 'p', 'i', 'r', 'a', 't', 'a', ' ', 'a', 't', 'a', 'c', 'a', ' ', 'h', 'o', 'y', ' ', ' '};

        char[] C = {' ', 'a', 't', 'a', ' '};

        procesarSecuencia(M, C);
        mostrarArreglo(M);
    }

    public static void procesarSecuencia(char[] arr, char[] arrB){
        int iniA = 0;
        int finA = -1;
        int contadorDePalabras = 0;

        int iniB = buscarInicio(arrB, 0);
        int finB = buscarFin(arrB, iniB);

        while(iniA < arr.length){
            iniA = buscarInicio(arr, finA + 1);

            if(iniA < arr.length){
                finA = buscarFin(arr, iniA);

                contadorDePalabras++;

                if(cumplePatron(arr, iniA, finA, arrB, iniB, finB)){

                    int tamaño = finA - iniA + 1;

                    for(int i = 0; i < tamaño; i++){
                        corrimientoIzquierda(arr, iniA);
                    }
                    finA = finA - tamaño;

                    System.out.println("se sencuro la palabra numero: " + contadorDePalabras);
                }
            }
        }
    }

    public static void corrimientoIzquierda(char[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
    }

    public static boolean cumplePatron(char[] arrA, int iniA, int finA, char[] arrB, int iniB, int finB){
        if(finB - iniB + 1 > finA - iniA + 1){
            return false;
        }

        int ancla = iniA;
        boolean loEncontre = false;

        while(ancla <= finA && !loEncontre){
            int tempA = ancla;
            int tempB = iniB;

            while(tempA <= finA && tempB <= finB && arrA[tempA] == arrB[tempB]){
                tempA++;
                tempB++;
            }

            if(tempB > finB){
            loEncontre = true;
            }
            else{
                ancla++;
                }
        }
        return loEncontre;
    }

    public static int buscarInicio(char[] arr, int pos){
        while(pos < arr.length && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(char[] arr, int pos){
        while(pos < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos - 1;
    }

    public static void mostrarArreglo(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }
}
