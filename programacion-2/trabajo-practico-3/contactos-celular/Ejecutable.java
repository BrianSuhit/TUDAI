import java.time.LocalDate;

public class Ejecutable {
    
    public static void main(String[] args) {

    Contacto contacto1 = new Contacto("Juan", "Perez", LocalDate.of(1990, 5, 15), "123456789", "Calle Falsa 123", "juan.perez@email.com");

    Contacto contacto2 = new Contacto("Maria", "Gomez", LocalDate.of(1992, 8, 20), "987654321", "Avenida Siempre Viva 456", "maria.gomez@email.com");

    Contacto contacto3 = new Contacto("Juan", "Perez", LocalDate.of(1990, 5, 15), "123456789", "Calle Falsa 123", "juan.perez@email.com");

    Celular celular = new Celular(3);

    celular.agregarContacto(contacto1);
    celular.agregarContacto(contacto2);
    celular.agregarContacto(contacto3);
    System.out.println("Cantidad de contactos: " + celular.getCantidadContactos());

    celular.getContactosRepetidos();
    System.out.println("Cantidad de contactos repetidos: " + celular.getContactosRepetidos());

    celular.getPromedioEdad();
    System.out.println("El promedio de edad es: " + celular.getPromedioEdad());
    }
}
