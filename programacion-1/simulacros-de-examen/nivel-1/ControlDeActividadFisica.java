public class ControlDeActividadFisica {
    
    public static final int SEPARADOR = 0;
    public static final int META = 60;

    public static void main(String[] args) {
        
        int[] arrActividad = {0, 30, 20, 0, 45, 20, 0, 15, 15, 10, 0, 70, 0, 0, 0};

        int ini = 0;
        int fin = -1;
        int contadorDeRachas = 0;

        while( ini < arrActividad.length){
            ini = buscarInicio(arrActividad, fin + 1);

            if(ini < arrActividad.length){
                fin = buscarFin(arrActividad, ini);

                int cantidadDeMinutosTotales = sumarDias(arrActividad, ini, fin);

                if(cantidadDeMinutosTotales > META){
                    contadorDeRachas++;
                }
            }
        }
        System.out.println("el usuario cumplio la meta " +  contadorDeRachas + " días");
    }

    public static int sumarDias(int[] arr, int ini, int fin){
        int i = ini;
        int suma = 0;
        for(i = ini; i <= fin; i++){
            suma = suma + arr[i];
        }

        return suma;
    }

    public static int buscarInicio(int[] arr, int pos){
        while(pos < arr.length && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos){
        while(pos < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos - 1;
    }
}
