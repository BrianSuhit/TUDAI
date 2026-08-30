import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Jardin miJardin = new Jardin();

        Planta plantaA = new Planta("Monstera deliciosa", "Costilla de Adán", "México", LocalDate.of(2026, 2, 10));
        Planta plantaB = new Planta("Ficus lyrata", "Pandurata", "África", LocalDate.of(2026, 2, 11));
        Planta plantaC = new Planta("Sansevieria", "Lengua de suegra", "África", LocalDate.of(2026, 2, 12));

        miJardin.agregarPlanta(plantaA);
        miJardin.agregarPlanta(plantaB);
        miJardin.agregarPlanta(plantaC);

        System.out.println("--- COMPROBACIÓN DE IDS AUTOGENERADOS ---");
        System.out.println("Planta A: " + plantaA.getNombreComun() + " | ID asignado: " + plantaA.getId());
        System.out.println("Planta B: " + plantaB.getNombreComun() + " | ID asignado: " + plantaB.getId());
        System.out.println("Planta C: " + plantaC.getNombreComun() + " | ID asignado: " + plantaC.getId());
    }
}