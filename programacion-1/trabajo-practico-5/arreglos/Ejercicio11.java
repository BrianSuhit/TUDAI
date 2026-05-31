public class Ejercicio11 {
/*
11. Dado un arreglo de caracteres, determinar si en el arreglo
existe al menos una letra (verificar que es letra) repetida.
a. En posiciones contiguas.
b. En cualquier posición.
*/
    public static final int TAM = 4;

    public static void main(String[] args) {
        
        char[] arreglo = {'a', 'b', 'b', 'c'};


        if(hayLetraRepetidaContigua(arreglo)){
            System.out.println("hay una letra repetida contigua");
        }
        else{
            System.out.println("no hay una letra repetida contigua");
        }

        if(hayLetraRepetida(arreglo)){
            System.out.println("hay una letra repetida");
        }
        else{
            System.out.println("no hay una letra repetida");
        }
    }

    public static boolean esLetra(char caracter){
        return ((caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z'));
    }

    public static boolean hayLetraRepetidaContigua(char[] arreglo){
        int pos = 0;
        boolean esLetraRepetida = false;

        while(pos < TAM - 1 && !esLetraRepetida){
            if(arreglo[pos] == arreglo[pos + 1] && esLetra(arreglo[pos])){
                System.out.println("hay una letra repetida en la posicion: " + pos + " y en la posicion: " + (pos + 1));
                esLetraRepetida = true;
            }
            pos++;
        }
        return esLetraRepetida;
    }

    public static boolean hayLetraRepetida(char[] arreglo){
        int pivote = 0;
        boolean esLetraRepetida = false;

        while(pivote < TAM - 1 && !esLetraRepetida){

            if(esLetra(arreglo[pivote])){
                int explorador = pivote + 1;

                while(explorador < TAM && !esLetraRepetida){
                    if(arreglo[pivote] == arreglo[explorador]){
                        esLetraRepetida = true;
                        System.out.println("hay una letra repetida en la posicion: " + pivote + " y en la posicion: " + explorador);
                    }
                    explorador++;
                }
            }
            pivote++;
        }
        return esLetraRepetida;
    }
}
