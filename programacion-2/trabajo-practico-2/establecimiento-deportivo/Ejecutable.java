import java.time.LocalDate;

public class Ejecutable {
    public static void main(String[] args) {
        EstablecimientoDeportivo club = new EstablecimientoDeportivo("Club Exactas", 6);

        Cancha futbol1 = new Cancha(1, "Futbol", 400.0);
        Cancha futbol2 = new Cancha(2, "Futbol", 400.0);
        Cancha paddle1 = new Cancha(3, "Paddle", 100.0);
        Cancha paddle2 = new Cancha(4, "Paddle", 100.0);
        Cancha paddle3 = new Cancha(5, "Paddle", 100.0);
        Cancha paddle4 = new Cancha(6, "Paddle", 100.0);

        club.agregarCancha(futbol1, 0);
        club.agregarCancha(futbol2, 1);
        club.agregarCancha(paddle1, 2);
        club.agregarCancha(paddle2, 3);
        club.agregarCancha(paddle3, 4);
        club.agregarCancha(paddle4, 5);

        Usuario brian = new Usuario("brian", new Turno[1]);

        LocalDate hoy = LocalDate.now();

        Turno t1 = new Turno(hoy.minusDays(5), paddle1, brian, 2.0);
        brian.registrarTurno(t1, 0);

        Turno t2 = new Turno(hoy.minusDays(10), futbol1, brian, 1.0);
        brian.registrarTurno(t2, 1);

        Turno t3 = new Turno(hoy.minusDays(20), paddle2, brian, 1.5);
        brian.registrarTurno(t3, 2);

        Turno t4 = new Turno(hoy.minusDays(45), paddle3, brian, 2.0);
        brian.registrarTurno(t4, 3);

        System.out.println("--- CONTROL DE SOCIOS EN " + club.getNombre().toUpperCase() + " ---");
        System.out.println("Cliente: " + brian.getNombre());
        System.out.println("¿Cumple requisitos para ser Socio?: " + brian.esSocio()); 
        System.out.println();

        Turno turnoConDescuento = new Turno(hoy, futbol2, brian, 2.0);
        brian.registrarTurno(turnoConDescuento, 4);

        System.out.println("--- DETALLE DE NUEVA RESERVA ---");
        System.out.println("Deporte: Futbol 5");
        System.out.println("Duración: 2.0 horas");
        System.out.println("Precio final con descuento del 10%: $" + turnoConDescuento.getPrecioFinal()); 
    }
}
