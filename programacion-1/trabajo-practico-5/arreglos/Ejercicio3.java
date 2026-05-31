public class Ejercicio3 {
/*
3-Con el mismo arreglo del ejercicio anterior informe por pantalla
cuantos elementos del mismo están por encima del promedio
calculado.
*/
    public static final int TAM = 10;

    public static void main(String[] args) {
        
        int[] arreglo = {2, 5, 9, 8, 9, 6, 10, 7, 5, 4};

        double promedio = promedioArreglo(arreglo);
        System.out.println("El promedio del arreglo es: " + promedio);

        posArribaDelPromedio(arreglo, promedio);
    }

    public static double promedioArreglo(int[] arreglo){
        int suma = 0;
        for(int pos = 0; pos < TAM; pos++){
            suma = suma + arreglo[pos];
        }
        return ((double) suma / TAM);
    }

    public static void posArribaDelPromedio(int[] arreglo, double promedio){

        for(int pos = 0; pos < TAM; pos++){
            if(arreglo[pos] > promedio){
                System.out.println("La posicion: " + pos + " esta por encima del promedio");
            }
        }
    }
}
