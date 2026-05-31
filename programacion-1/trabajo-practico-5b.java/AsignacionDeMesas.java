public class AsignacionDeMesas {
    
    public static void main(String[] args) {
        
        int[] C = {4, 3, 8, 6, 2, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] M = {2, 3, 5, 6, 12};

        int posCliente = 0;
        int mesasOcupadas = 0; 
        int numeroDeClienteOriginal = 1; 

        while (posCliente < C.length && C[posCliente] != 0) {
            
            int cantPersonas = C[posCliente];
            int indiceMesa = buscarMesaLibre(M, cantPersonas);
            
            if (indiceMesa != -1) {
                M[indiceMesa] = M[indiceMesa] * -1; 
                
                System.out.println("El cliente " + numeroDeClienteOriginal + " se asignó a la mesa " + indiceMesa);
                mesasOcupadas++;
                
                corrimientoIzquierda(C, posCliente);
                                
            } else {
                System.out.println("El cliente " + numeroDeClienteOriginal + " no se puede asignar");
                posCliente++; 
            }
            
            numeroDeClienteOriginal++;
            
            if (mesasOcupadas == M.length) {
                System.out.println("No quedan más mesas para asignar clientes");
                break; 
            }
        }
        
        mostrarArreglo(C); 
    }
    
    public static int buscarMesaLibre(int[] M, int cantPersonas) {
        int pos = 0;
        while (pos < M.length && (M[pos] < 0 || M[pos] < cantPersonas)) {
            pos++;
        }
        
        if (pos < M.length) {
            return pos; 
        }
        return -1;
    }
    
    public static void corrimientoIzquierda(int[] arr, int posEliminar) {
        for(int pos = posEliminar; pos < arr.length - 1; pos++){
            arr[pos] = arr[pos + 1];
        }
    }

    public static void mostrarArreglo(int[] arr) {
        for (int pos = 0; pos < arr.length; pos++)
            System.out.print(" | " + arr[pos]);
        System.out.println();
    }
}
