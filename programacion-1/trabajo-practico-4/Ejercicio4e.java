public class Ejercicio4e {
/*
e. public static int contarDigitos(int n) {
int contador = 0;
while (n != 0) {
n /= 10;
contador++;
}
return contador;
}
*/
    public static void main(String[] args) {
        
        // si el usuario retorna un 0 devuelve un 0
        System.out.println(contarDigitos(0));
    }

    // se tendria que hacer un do while para que el primer valor aunque sea 0 cuente como 1 al contador
    public static int contarDigitos(int n) {
        int contador = 0;
        while (n != 0) {
            n /= 10;
            contador++;
        }
        // return contador;

        do{
            n /= 10;
            contador++;
        }while(n!=0);
        return contador;
    
    }

}