public class AsignacionAulas {
/*
Simulacro 6 NIVEL 5: Asignacion de Aulas
La Facultad debe asignar aulas para materias que toman finales en el mismo horario.
Arreglo M (Materias): Almacena los legajos de los inscriptos de cada materia. Cada materia (secuencia) está separada por ceros (0) [cite: 398].
Arreglo A (Aulas): Es un arreglo simple (sin separadores) que guarda la capacidad de cada aula. Está ordenado ascendentemente. El valor en la posición i es la capacidad del aula i [cite: 399].
Reglas de negocio [cite: 399]:
A cada materia (vagón) se le debe asignar un aula.
Eficiencia: El aula asignada debe ser la que deje menos lugares vacíos. Como el arreglo A está ordenado de menor a mayor, la primera aula que encuentres cuya capacidad sea mayor o igual al tamaño del vagón, ¡es la ideal!
Acción si hay aula:
Imprimir: "La materia X se asignó al aula Y".
Marcar el aula como ocupada (multiplicar su capacidad por -1).
Eliminar por completo la materia del arreglo M (corrimiento a izquierda).
Acción si NO hay aula: Imprimir "La materia X no se puede asignar" y NO eliminar la secuencia de M.
*/
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        // Materia 1: Tamaño 4. Materia 2: Tamaño 6. Materia 3: Tamaño 3.
        int[] M = {0, 0, 34, 2, 12, 25, 0, 32, 55, 12, 3, 88, 14, 0, 0, 17, 36, 19, 0, 0};
        
        // Aulas (Posición = Nro Aula | Valor = Capacidad)
        int[] A = {2, 3, 6}; 

        System.out.println("Materias original:");
        mostrarArreglo(M);
        System.out.println("\nAulas original:");
        mostrarArreglo(A);
        System.out.println("\n--- ASIGNACIONES ---");

        // --- TU LÓGICA DEL DIRECTOR ACÁ ---
        // PISTA: Vas a necesitar una variable extra (ej: int numeroMateria = 1) 
        // para poder imprimir "La materia 1...", "La materia 2..." etc.

        int ini = 0;
        int fin = -1;
        int numeroMateria = 0;

        while(ini < M.length){
            ini = buscarInicio(M, fin + 1);

            if(ini < M.length){

                fin = buscarFin(M, ini);

                int tamaño = fin - ini + 1;
                int pos = hayAula(A, tamaño);
                numeroMateria++;

                if(pos != -1){
                    A[pos] = A[pos] * -1;
                    for(int i = 0; i < tamaño; i++){

                        corrimientoIzquierda(M, ini);
                    }
                    fin = fin - tamaño;
                    System.out.println("la materia: " + numeroMateria + " se asigno al aula: " + pos);

                }
                else{
                    System.out.println("la materia: " + numeroMateria + " no se pudo asignar.");
                }
            }
        }

        System.out.println("\n--- RESULTADOS FINALES ---");
        System.out.println("Materias filtrado:");
        mostrarArreglo(M);
        System.out.println("\nAulas ocupadas (en negativo):");
        mostrarArreglo(A);
    }

    public static int hayAula(int[] arrA, int tamaño){
        int i = 0;

        while(i < arrA.length){

            if(arrA[i] >= tamaño && arrA[i] > 0){
                return i;
            }
            i++;
        }
        return -1;

    }
    
    public static void corrimientoIzquierda(int[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
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

        public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "|");
        }
    }
}
