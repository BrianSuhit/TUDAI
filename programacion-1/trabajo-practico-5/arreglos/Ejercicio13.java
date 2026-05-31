public class Ejercicio13 {
/*
Dado dos arreglos de números enteros A y B determinar si
todos los números almacenados en el arreglo A están presentes
en el arreglo B.
*/
    public static void main(String[] args) {
        int[] A = {3, 9, 31};
        int[] B = {31, 2, 6, 9, 10, 3}; 
        
        if(estanTodosLosElementos(A, B)){
        System.out.println("el conjunto a esta en el conjunto b: ");
        }
        else{
            System.out.println("el conjunto a NO esta en el conjunto b: ");
        }
    }

    public static boolean estanTodosLosElementos(int[] A, int[] B){
        int pos = 0;
        while(pos < A.length && estaElementoArr(B, A[pos])){
            pos++;   
        }
        return pos == A.length;
    }

    public static boolean estaElementoArr(int[] B, int elemento){
        boolean estaEnB = false;
        int pos = 0;
        while(pos < B.length && !estaEnB){
            if(elemento == B[pos]){
                estaEnB = true;
            }
            pos++;
        }
        return estaEnB;
    }
}
