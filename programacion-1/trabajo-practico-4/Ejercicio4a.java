/*
4. Para los siguientes métodos verificar su funcionamiento por medio
de algunas de las técnicas aprendidas y corregir los errores si
hubiesen:

a. public static int obtenerFactorial(int numero){
// obtiene el factorial de numero
int resultado=numero;
while (numero>0)
resultado*=--numero;
return resultado;
}

NOTA: NO RETORNA EL FACTORIAL, RETORNA 0
*/

public class Ejercicio4a{

    public static void main(String[] args) {
        
        System.out.println(obtenerFactorial(3));
    }

    public static int obtenerFactorial(int numero){
        int resultado=numero;
        
        // CORRECCION CAMBIAMOS EL 0 POR EL 1 PARA QUE NO ENTRE UNA ULTIMA VEZ
        while (numero>1)
        resultado*=--numero;
        return resultado;
    }

}