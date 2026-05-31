public class SimulacroNaval {
/*
 Mini-Simulacro: "Desencriptación Naval" (Filtro de Basura Avanzado)
Basado en el final real del 5 de mayo de 2026
El Dominio: Un submarino envía mensajes a la base. El mensaje se guarda en un arreglo de caracteres char[] mensaje. Las secuencias de letras (el mensaje útil) están delimitadas por separadores "basura" que el radar interfiere. La trampa es que los separadores no son un único carácter. El sistema tiene un arreglo de caracteres especial llamado char[] signos = {'*', '#', '@', '&'}. Cualquier símbolo que esté en ese arreglo, se considera un separador.
La Consigna: Se pide aislar cada palabra del mensaje y contar cuántas secuencias tienen un tamaño exactamente igual a 4.
*/
    public static void main(String[] args) {
        // El mensaje tiene basura de signos mezclada
        char[] mensaje = {'*', '#', 'h', 'o', 'l', 'a', '@', 'b', 'i', 'e', 'n', '&', 'c', 'h', 'a', 'u', '*', '*', '*', '*'};
        // El arreglo de separadores
        char[] signos = {'*', '#', '@', '&'};

        System.out.println("Iniciando escaneo del mensaje naval...");
        
        // 1. El main es cobarde y delega todo al Director:
        procesarMensaje(mensaje, signos);
    }

    // --- EL DIRECTOR ---
    public static void procesarMensaje(char[] mensaje, char[] signos) {
        int ini = 0;
        int fin = -1;
        int cantPalabrasDe4 = 0;

        while(ini < mensaje.length){
            ini = buscarInicio(mensaje, fin + 1, signos);

                if(ini < mensaje.length){
                    fin = buscarFin(mensaje, ini, signos);

                        int tamaño = fin - ini + 1;

                        if(tamaño == 4){
                            cantPalabrasDe4++;
                        }
                }
        }
        System.out.println("Palabras con exactamente 4 letras encontradas: " + cantPalabrasDe4);
    }

    public static int buscarInicio(char[] mensaje, int pos, char[] signos) {
        while(pos < mensaje.length && esSeparador(signos,  mensaje[pos])){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(char[] mensaje, int pos, char[] signos) {
        while(pos < mensaje.length && !esSeparador(signos, mensaje[pos])){
            pos++;
        }
        return pos - 1;
    }

    public static boolean esSeparador(char[] signos, char c) {
        int i = 0;
        boolean loEncontre = false;

        while(i < signos.length && !loEncontre){
            if(signos[i] == c){
                loEncontre = true;
            }
            else{
                i++;
            }
        }
        return loEncontre;
    }
}
