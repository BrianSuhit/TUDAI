public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("      CEREMONIA DE SELECCIÓN DE HOGWARTS        ");
        System.out.println("=================================================");

        SombreroSeleccionador sombrero = new SombreroSeleccionador();

        Casa gryffindor = new Casa("Gryffindor", 2); // Capacidad máx: 2
        gryffindor.addCualidad("Valor");
        gryffindor.addCualidad("Audacia");

        Casa slytherin = new CasaSangrePura("Slytherin", 5);
        slytherin.addCualidad("Ambicion");
        slytherin.addCualidad("Astucia");

        CasaEnemiga hufflepuffEnemiga = new CasaEnemiga("Hufflepuff Enemiga de Slytherin", 5, slytherin);
        hufflepuffEnemiga.addCualidad("Lealtad");

        sombrero.addCasa(gryffindor);
        sombrero.addCasa(slytherin);
        sombrero.addCasa(hufflepuffEnemiga);

        Alumno harry = new Alumno("Harry Potter");
        harry.addCualidad("Valor");
        harry.addCualidad("Audacia");

        Alumno hermione = new Alumno("Hermione Granger");
        hermione.addCualidad("Valor");
        hermione.addCualidad("Audacia");

        Alumno ron = new Alumno("Ron Weasley");
        ron.addCualidad("Valor");
        ron.addCualidad("Audacia");

        Alumno draco = new Alumno("Draco Malfoy");
        draco.addCualidad("Ambicion");
        draco.addCualidad("Astucia");


        harry.addFamiliar(ron);
        ron.addFamiliar(harry);

        System.out.println("\n--- Iniciando Asignaciones ---");

        // Harry entra a Gryffindor (tiene las cualidades) 
        boolean okHarry = sombrero.asignarCasa(harry);
        System.out.println(harry.getNombre() + " asignado: " + okHarry + " -> " + harry);

        // Hermione entra a Gryffindor (todavía hay cupo)
        boolean okHermione = sombrero.asignarCasa(hermione);
        System.out.println(hermione.getNombre() + " asignado: " + okHermione + " -> " + hermione);

        // Ron NO entra a Gryffindor porque ya está llena (capacidad 2) 
        boolean okRon = sombrero.asignarCasa(ron);
        System.out.println(ron.getNombre() + " asignado: " + okRon + " (Debería ser false porque Gryffindor se llenó)");

        // Draco intenta entrar a Slytherin (Sangre Pura), pero NO tiene familiares allí todavía!
        boolean okDraco = sombrero.asignarCasa(draco);
        System.out.println(draco.getNombre() + " asignado: " + okDraco + " (Debería ser false por regla de Sangre Pura)");

        // Le asignamos Slytherin a la fuerza a Lucius Malfoy (padre de Draco) para simular el linaje
        Alumno lucius = new Alumno("Lucius Malfoy");
        lucius.setCasa(slytherin); // Lo metemos directo
        draco.addFamiliar(lucius); // Draco ahora sí tiene un familiar en Slytherin

        // Ahora Draco intenta de nuevo... ¡Y ahora sí Slytherin lo acepta!
        boolean okDraco2 = sombrero.asignarCasa(draco);
        System.out.println(draco.getNombre() + " re-intento asignado: " + okDraco2 + " -> " + draco);
        System.out.println("=================================================");
    }
}