public class Ejercicio4b {
/*
b. public static int obtenerSumatoria(int natural){
// obtiene la sumatoria de los primeros n naturales
int resultado=1;
while (natural>0)
resultado+=natural--;
return resultado;
}
*/
    public static void main(String[] args) {
        
        System.out.println(obtenerSumatoria(3));
    }

    public static int obtenerSumatoria(int natural){
        // CORRECCION DEBERIA ARRANCAR EN 0 PARA QUE LA SUMATORIA RETORNE 6 EN CASO DE INGRESAR 3 Y NO 7
        int resultado=0;
        
        while (natural>0)
        resultado+=natural--;
        return resultado;
    }
}
