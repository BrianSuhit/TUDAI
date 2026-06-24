public class PatentesEnLaReservaNatural {
/*
Patentes en la reserva natural
La reserva natural Sierra del Tigre desea controlar el ingreso y egreso de vehículos. Para ello, dispone de
cámaras que identifican las patentes de los vehículos que ingresan y egresan del predio. Los ingresos y
egresos se registran en dos arreglos arrI y arrE respectivamente. Ambos arreglos son de tamaño MAXA y
almacenan las patentes como secuencias de caracteres separados por uno o más espacios.
Por ejemplo, en los siguientes arreglos la patente del primer vehículo en ingresar al predio fue AA 123 ZZ, y el
primero en egresar fue AB 987 EX.
ArrI:
A A 1 2 3 Z Z P R G 0 1 0 A B 9 8 7 E X
ArrE:
A B 9 8 7 E X A A 1 2 3 Z Z F O R 0 0 1
Se debe implementar un programa que verifique, al finalizar el día, que todos los autos que ingresaron hayan
también egresado del predio. En caso de detectar algún vehículo que no haya egresado se debe almacenar la
patente en un arreglo arrNoE.
De igual manera, puede ocurrir que al ingreso del vehículo la patente no quede registrada pero si al egresar.
En estos casos, se debe almacenar las patentes de los autos que no hayan quedado registrados en el arreglo
arrI pero si en el arrE, en un arreglo arrNoI.
Nota: los arreglos arrNoE y arrNoI son de tamaño MAXA y deben almacenar las patentes separadas por uno
o más espacios.
Siguiendo con el ejemplo anterior, los arreglos resultantes quedarían de la siguiente forma:
ArrNoE
P R G 0 1 0
ArrNoI:
F O R 0 0 1
Aclaración: Asumir que cada vehículo puede ingresar o egresar una vez al día.
*/

    public static final char SEPARADOR = '0';
    public static void main (String[] args){

        char arrI[] = {'0', 'A', 'A', '1', '2', '3', 'Z', 'Z', '0', 'P', 'R', 'G', '0', '1', '0', '0', 'A', 'B', '9', '8', '7', 'E', 'X', '0', '0'};
        char arrE[] = {'0', '0', 'A', 'B', '9', '8', '7', 'E', '0', 'X', 'A', 'A', '1', '2', '3', 'Z', 'Z', '0', 'F', 'O', 'R', '0', '0', '1', '0'};

        char arrNoE[] = new char[arrI.length];
        inicializarArreglo(arrNoE); 

        int iniI = 0;
        int finI = -1;
        int posNoE = 0; 

        while(iniI < arrI.length){
            iniI = buscarInicio(arrI, finI + 1);

            if(iniI < arrI.length){
                finI = buscarFin(arrI, iniI);

                boolean patenteEncontrada = false;
                int iniE = 0;
                int finE = -1;

                while(iniE < arrE.length && !patenteEncontrada){
                    iniE = buscarInicio(arrE, finE + 1);
                    
                    if(iniE < arrE.length){
                        finE = buscarFin(arrE, iniE);

                        if (sonSecuenciasIguales(arrI, iniI, finI, arrE, iniE, finE)) {
                            patenteEncontrada = true; 
                        }
                    }
                }

                if(!patenteEncontrada){
                    posNoE = guardarNoEgresados(arrI, iniI, finI, arrNoE, posNoE);
                }
            }
        }
       
    }

    public static boolean sonSecuenciasIguales(char[] arr1, int ini1, int fin1, char[] arr2, int ini2, int fin2){
        int tam1 = fin1 - ini1 + 1;
        int tam2 = fin2 - ini2 + 1;
        
        if (tam1 != tam2) {
            return false;
        }

        int i = ini1;
        int j = ini2;

        while(i <= fin1){
            if(arr1[i] != arr2[j]){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public static int guardarNoEgresados(char[] origen, int ini, int fin, char[] destino, int posDestino){
        for(int i = ini; i <= fin; i++){ 
            destino[posDestino] = origen[i];
            posDestino++;
        }

        destino[posDestino] = SEPARADOR;
        posDestino++; 
        
        return posDestino; 
    }

    public static int buscarInicio(char[] arr, int pos){
        while(pos < arr.length && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(char[] arr, int ini){
        while(ini < arr.length && arr[ini] != SEPARADOR){
            ini++;
        }
        return ini - 1;
    }
    
    public static void inicializarArreglo(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = SEPARADOR;
        }
    }    
}
