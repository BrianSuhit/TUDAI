public class Parcial2025 {
/*
Misión 10 (Jefe Final Absoluto) - Parcial 2025: "Monitoreo de Estudiantes"
El Dominio (Consigna Pura): Un sistema de una plataforma educativa registra los minutos que tarda un estudiante en leer secciones de un curso en un arreglo T [cite: 365].
Los tiempos de lectura siempre son números enteros positivos [cite: 365].
Para separar las lecturas de un estudiante de las de otro, se insertan uno o más valores negativos a modo de delimitador [cite: 365, 366]. El arreglo también empieza y termina con números negativos.
El Filtro: Se considera que un estudiante pierde concentración si sus tiempos de lectura disminuyen gradualmente en cada sección (ej: 23, 21, 20, 19, 15 viene en bajada).
La Acción: Si el estudiante NO evidencia falta de concentración (es decir, NO viene en bajada), tenés que calcular su tiempo total invertido (sumar el vagón) y transformarlo al formato Horas y Minutos [cite: 366].
El Reemplazo: Reemplazás los dos primeros lugares de esa secuencia con las Horas y los Minutos, y borrás el resto de esa secuencia [cite: 366]. (Nota matemática: Horas = suma / 60. Minutos = suma % 60).
*/
    public static final int MINUTOS_X_HS = 60;
    public static void main(String[] args) {
        
        int[] T = {-6, 23, 21, 20, 19, 15, -15, 14, 13, 16, -8, -10, -30, 28, 26, 12, 35, 16, 32, 54, 60, -5, -5, -5};

        System.out.println("Tiempos Originales:");
        mostrarArreglo(T);

        int ini = 0;
        int fin = -1;

        while(ini < T.length){
            ini = buscarInicio(T, fin + 1);

            if(ini < T.length){
                fin = buscarFin(T, ini);

                int tamaño = fin - ini + 1;

                if(esDescendente(T, ini, fin)){
                    System.out.println("el estudiante: " + tamaño + " presenta un comportamiento descendiente");
                }
                else{
                        int sumaTotal = calcularSuma(T, ini, fin);

                        T[ini] = sumaTotal / MINUTOS_X_HS;
                        T[ini + 1] = sumaTotal % MINUTOS_X_HS;

                        for(int i = 0; i < tamaño - 2; i++){
                            corrimientoIzquierda(T, ini + 2);
                        }
                    fin = fin - tamaño + 2;
                }
                
            }
        }

        System.out.println("\nTiempos Actualizados:");
        mostrarArreglo(T);
    }
    
    public static int calcularSuma(int[] arr, int ini, int fin){
        int suma = 0;

        for(int i = ini; i <= fin; i++){
            suma = suma + arr[i];
        }
        return suma;
    }

    public static boolean esDescendente(int[] arr, int ini, int fin){
        while(ini < fin && arr[ini] > arr[ini + 1]){
            ini++;
        }
        return ini == fin;
    }

    public static void corrimientoIzquierda(int[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
    }

    public static int buscarInicio(int[] arr, int pos){
        while(pos < arr.length && arr[pos] < 0){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos){
        while(pos < arr.length && arr[pos] > 0){
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
