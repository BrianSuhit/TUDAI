import java.time.LocalDate;

public class tp1 {
    
    public static void main(String[] args) {

        Persona alumno = new Persona(41324969, "Brian", "Suhit");

        alumno.setEdad(30);
        alumno.setPeso(62);
        alumno.setAltura(1.65);
        alumno.setSexo("Masculino");
        alumno.setFechaDeNacimiento(LocalDate.of(1995, 8, 18));

        String fichaAlumno = alumno.ObetenerFichaPersona(); 

        System.out.println(fichaAlumno);

        /* ------------------------------------------------------------ */

        // Punto_geométrico origen = new Punto_geométrico();

        // Punto_geométrico esquina1 = new Punto_geométrico();

        // Punto_geométrico esquina2 = new Punto_geométrico();

        // esquina1.Desplazar(4.0, 3.0);

        // esquina2.Desplazar(2.0, 1.5);


        // Rectangulo rectangulo1 = new Rectangulo(origen, esquina1);

        // Rectangulo rectangulo2 = new Rectangulo(origen, esquina2);

        // int comparacion = rectangulo1.CompararRectangulo(rectangulo2);

        // System.out.println(comparacion);

        // boolean esCuadrado = rectangulo1.GetAlto() == rectangulo1.GetAncho();
        // System.out.println("es un cuadrado?: " + esCuadrado);

        // double largoSuperior = rectangulo1.GetAncho();
        // System.out.println("cual es el largo superior: " + largoSuperior);

        // boolean estaAcostado = rectangulo1.GetAlto() > rectangulo1.GetAncho();
        // System.out.println("esta acostado?: " + estaAcostado);

        Punto_geométrico origen = new Punto_geométrico();

        Rectangulo rectangulo = new Rectangulo(origen, 15.0, 5.0);

        System.out.println("Área del rectángulo: " + rectangulo.CalcularArea());
        System.out.println("Es cuadrado?: " + rectangulo.EsCuadrado());
        System.out.println("Largo superior: " + rectangulo.GetLargoSuperior());
        System.out.println("Está acostado?: " + rectangulo.EstaAcostado());
    }
}