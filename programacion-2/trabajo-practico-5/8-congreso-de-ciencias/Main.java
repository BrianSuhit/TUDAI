public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("       SISTEMA DE ASIGNACIÓN DEL CONGRESO        ");
        System.out.println("=================================================");

        Congreso congreso = new Congreso();

        // 1. Cargamos los Temas Expertos (específicos) del Congreso
        congreso.addTemaExperto("Agentes");
        congreso.addTemaExperto("Visualizacion");
        congreso.addTemaExperto("Redes");

        // 2. Creamos Evaluadores
        Evaluador ana = new Evaluador("Ana (General)");
        ana.addTema("Algoritmos");
        ana.addTema("Lenguajes");

        Evaluador luis = new Evaluador("Luis (Experto)");
        luis.addTema("Algoritmos");
        luis.addTema("Agentes"); // Tema específico

        congreso.addEvaluador(ana);
        congreso.addEvaluador(luis);

        // 3. Creamos Trabajos
        Trabajo articulo = new Trabajo("Articulo de Agentes y Algoritmos");
        articulo.addPalabraClave("Algoritmos");
        articulo.addPalabraClave("Agentes");

        Poster poster = new Poster("Poster de Visualizacion e Interfaces");
        poster.addPalabraClave("Visualizacion");
        poster.addPalabraClave("Interfaces");

        congreso.addTrabajo(articulo);
        congreso.addTrabajo(poster);

        System.out.println("\n--- 4) Clasificación de Evaluadores (Esperado: Ana General, Luis Experto) ---");
        System.out.println("Ana es Experta? " + congreso.esExperto(ana) + " | Es General? " + congreso.esGeneral(ana));
        System.out.println("Luis es Experto? " + congreso.esExperto(luis) + " | Es General? " + congreso.esGeneral(luis));

        System.out.println("\n--- 1) Evaluadores aptos para el Artículo (Requiere Ambos - Esperado: Solo Luis) ---");
        System.out.println("Aptos: " + congreso.getEvaluadoresAptosPara(articulo));

        System.out.println("\n--- 1) Evaluadores aptos para el Poster (Requiere Al menos Uno - Esperado: Solo Luis por Visualizacion) ---");
        System.out.println("Aptos: " + congreso.getEvaluadoresAptosPara(poster));

        // Simulamos asignación de trabajo
        luis.asignarTrabajo(articulo);
        System.out.println("\n--- 3) Cantidad de trabajos de Luis (Esperado: 1) ---");
        System.out.println("Trabajos de Luis: " + congreso.getCantTrabajosDe(luis));
        System.out.println("=================================================");
    }
}