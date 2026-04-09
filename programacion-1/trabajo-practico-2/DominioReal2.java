public class DominioReal2 {
/*
Implementar el juego “falso BlackJack”. Este juego consiste en
dos etapas. En la primera etapa juega el usuario (jugador). Para
ello, el juego genera números aleatorios enteros entre 1 y 10.
Cada número se va acumulando hasta que el usuario se planta
(en cada iteración el sistema debe preguntarle al usuario si quiere
seguir sacando números). La etapa del jugador continúa hasta
que se plante ó la suma de los números obtenidos supere 21. Si el
jugador superó los 21 pierde el juego, en caso contrario continúa
la etapa de la banca (la computadora). La computadora genera
números aleatorios para sí misma hasta que la acumulación sea
mayor a 16 o supere los 21. Si la banca supera los 21, gana el
jugador, en caso contrario gana quien obtuvo el puntaje mayor (si
ambos terminan con el mismo puntaje, hay empate).
*/ 
    public static void main(String[] args) {
        

        int puntajeJugador = 0;
        int puntajeBanca = 0;
        char quiereSeguir = 's';

        final int BLACK_JACk = 21;

        System.out.println("--- INICIO DE FALSO BLACKJACJ ---");

        System.out.println("\nTurno del Jugador...");
        while(quiereSeguir == 's' && puntajeJugador <= BLACK_JACk){

            int carta = (int)(Math.random() * 10) + 1;

            puntajeJugador += carta;
            System.out.println("Te salio un: " + carta + ". Tu puntaje es: " + puntajeJugador);

            if (puntajeJugador <= BLACK_JACk) {
                System.out.println("¿Querés otra carta? (s/n):");
                quiereSeguir = Utils.leerChar();
            }
        }

        if (puntajeJugador <= BLACK_JACk) {
            System.out.println("\nTurno de la Banca...");
            
            while (puntajeBanca <= 16) {
                int carta = (int)(Math.random() * 10) + 1;
                puntajeBanca = puntajeBanca + carta;
                System.out.println("La banca saco un: " + carta + ". Puntaje banca: " + puntajeBanca);
            }
        }

        System.out.println("\n--- RESULTADOS FINALES ---");

        if(puntajeJugador > BLACK_JACk){
            System.out.println("te pasaste de 21. !GANO LA BANCA!");
        }
        else if(puntajeBanca > BLACK_JACk){
            System.out.println("La banca se pasó de 21. ¡GANASTE!");
        }
        else if(puntajeJugador == puntajeBanca){
            System.out.println("Tienen el mismo puntaje. EMPATE.");
        }
        else if(puntajeJugador > puntajeBanca){
            System.out.println("¡GANASTE por tener mayor puntaje!");
        }
        else{
            System.out.println("¡GANO LA BANCA!");
        }
    }
}
