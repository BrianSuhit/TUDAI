public class AsignacionDeAulas {
/*
Asignación de aulas
La Facultad de Exactas debe asignar aulas para una fecha de examen en la cual hay distintas materias que
tomarán finales en el mismo horario. Dicha asignación se realiza en base a la cantidad de alumnos y a la
capacidad de las aulas disponibles. Para ello, se almacena en un arreglo M de tamaño MAXM el número de
legajo de los inscriptos a cada una de las materias. Para separar cada materia, se utiliza uno o más ceros
(dado que ningún alumno posee un cero como número de legajo). Además, el arreglo M siempre comienza y
termina también con uno o más ceros. Por ejemplo, el siguiente arreglo M muestra que hay 3 materias que
tomarán examen en un mismo horario: en la primera hay 4 inscriptos, en la segunda 6 inscriptos y en la
tercera solo 3.
0 0 34 2 12 25 0 32 55 12 3 88 14 0 0 17 36 19 0 0
La facultad posee un conjunto de aulas, numeradas desde 0, disponibles para tomar exámenes según su
capacidad. La capacidad se almacena en un arreglo A de tamaño MAXA ordenado ascendentemente. En este
arreglo, el valor almacenado en la posición i se corresponde con la capacidad del aula número i. Por ejemplo,
en el siguiente arreglo A de tamaño 3, el aula nro. 1, posee capacidad para 3 alumnos.
2 3 6
Se pide implementar un programa en Java que asigne a cada materia almacenada en el arreglo M, un aula
del arreglo A. La asignación debe realizarse en el orden en que aparecen las materias en el arreglo M y
considerando, una asignación eficiente del espacio, esto es, el aula asignada debe ser aquella que deje
menos cantidad de lugares sin ocupar (y que ya no haya sido asignada). Para indicar que un aula ya ha sido
asignada, la capacidad debe ser cambiada por el valor original pero negativo. Una vez realizada la asignación
se debe eliminar la secuencia del arreglo M. En caso de no existir un aula disponible con la capacidad
necesaria, se debe informar que no se pudo asignar y se debe conservar la secuencia.
Si la cantidad de materias fuera superior a la cantidad de aulas disponibles, se debe informar que no quedan
más aulas cuando éstas hayan sido todas asignadas. Siguiendo el ejemplo, el arreglo A resultante sería:
2 -3 -6
Las asignaciones deben ser impresas por consola. En este ejemplo, las asignaciones serían: “La materia 1 se
asignó al aula 2”, “La materia 2 no se puede asignar” y “La materia 3 se asignó al aula 1.
El arreglo M resultante sería:
0 0 0 32 55 12 3 88 14 0 0 0 0 0 0 0 0 0 0 0
*/
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
