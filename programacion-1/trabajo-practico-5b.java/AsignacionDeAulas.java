public class AsignacionDeAulas {
    
public static void main(String[] args) {
        
        int[] arregloM = {0, 0, 34, 2, 12, 25, 0, 32, 55, 12, 3, 88, 14, 0, 0, 17, 36, 19, 0, 0};
        int[] arregloA = {2, 3, 6};

        int ini = 0;
        int fin = -1;

        int numeroMateria = 1; 
        int aulasOcupadas = 0;
        boolean hayAulasDisponibles = true; 

        while(ini < arregloM.length && hayAulasDisponibles){
            
            ini = buscarInicio(arregloM, fin + 1);

            if(ini < arregloM.length){
                fin = buscarFin(arregloM, ini);

                int cantAlumnos = fin - ini + 1;
                
                int indiceAula = buscarAulaDisponible(arregloA, cantAlumnos);

                if(indiceAula != -1){
                    arregloA[indiceAula] = arregloA[indiceAula] * -1; 
                    System.out.println("La materia " + numeroMateria + " se asignó al aula " + indiceAula);
                    aulasOcupadas++;
                    
                    for (int i = 0; i < cantAlumnos; i++) {
                        corrimientoIzquierda(arregloM, ini);
                    }
                    
                    fin = fin - cantAlumnos;
                }
                else{
                    System.out.println("La materia " + numeroMateria + " no se puede asignar");
                }
                
                numeroMateria++;
                
                if(aulasOcupadas == arregloA.length){
                    System.out.println("No quedan más aulas para asignar materias");
                    hayAulasDisponibles = false;
                }
            }
        }
    }
    
    public static void corrimientoIzquierda(int[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
    }

    public static int buscarAulaDisponible(int[] arrA, int cantAlumnos){
        int pos = 0;
        while(pos < arrA.length && (arrA[pos] < 0 || arrA[pos] < cantAlumnos)){
            pos++;
        }
        if(pos < arrA.length){
            return pos;
        } else {
            return -1;
        }
    }

    public static int buscarInicio(int[] arr, int pos){
        while(pos < arr.length && arr[pos] == 0){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos){
        while(pos < arr.length && arr[pos] != 0){
            pos++;
        }
        return pos - 1;
    }
}
