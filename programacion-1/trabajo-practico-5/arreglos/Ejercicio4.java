public class Ejercicio4{
/*
Buscar un elemento en un arreglo de caracteres ya cargado de
tamaño 10 y mostrar la/s posición/es del elemento, en caso de no
estar indicarlo también.
*/
    public static final int TAM = 10;

    public static void main(String[] args){

        char[] arreglo = {'b', 'r', 'i', 'a', 'n', 's', 'u', 'h', 'i', 't'};

        char elemento = solicitarElemento();

        buscarElemento(arreglo, elemento);
    }

    public static void buscarElemento(char[] arreglo, char elemento){

        boolean elementoEncontrado = false;

        for(int pos = 0; pos < TAM; pos++){
            if(elemento == arreglo[pos]){
                System.out.println("se encontro el elemento " + elemento + " en la posicion: " + pos);
                elementoEncontrado = true;
            }
        }
        if(!elementoEncontrado){
            System.out.println("El elemento no se encontro");
        }
    }

    public static char solicitarElemento(){
        char elemento = ' ';
        System.out.println("ingrese un elemento para buscar en el arreglo");
        elemento = Utils.leerChar();
        return elemento;
    }
}