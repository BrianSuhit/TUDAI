public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("         PRUEBA DE NUESTRA PILA DE PLATOS        ");
        System.out.println("=================================================");
        System.out.println();

        // 1. Creamos la pila vacía
        PilaDePlatos miPila = new PilaDePlatos();

        // 2. Apilamos (push) tres platos de distintos colores
        System.out.println("📥 Apilando platos: Rojo, luego Azul, y finalmente Verde...");
        miPila.push(new Plato("Rojo"));
        miPila.push(new Plato("Azul"));
        miPila.push(new Plato("Verde"));

        // 3. Comprobamos el tamaño actual
        System.out.println("📊 Cantidad de platos en la pila (size): " + miPila.size());
        System.out.println();

        // 4. Espiamos el tope (top) sin retirarlo
        System.out.println("👁️  Espiando el tope de la pila...");
        System.out.println("El plato de arriba es: " + miPila.top());
        System.out.println("📊 El tamaño sigue siendo: " + miPila.size() + " (porque top() no lo saca)");
        System.out.println();

        // 5. Desapilamos (pop) todos los platos uno por uno
        System.out.println("📤 Desapilando platos (pop) uno por uno:");
        
        Plato primero = miPila.pop();
        System.out.println("-> Salió: " + primero); // Debería ser el Verde!

        Plato segundo = miPila.pop();
        System.out.println("-> Salió: " + segundo); // Debería ser el Azul!

        Plato tercero = miPila.pop();
        System.out.println("-> Salió: " + tercero); // Debería ser el Rojo!

        System.out.println();

        // 6. Comprobamos el tamaño final
        System.out.println("📊 Cantidad final de platos en la pila (size): " + miPila.size());
        System.out.println("=================================================");

        // 7. Comprobamos el copy
        PilaDePlatos pilaCopiada = miPila.copy();
        System.out.println("Copia - Plato del tope: " + pilaCopiada.top());

        // 8. Comprobamos el reverse
        PilaDePlatos pilaInvertida = miPila.reverse();
        System.out.println("Reversa - Plato del tope: " + pilaInvertida.top());
    }
}