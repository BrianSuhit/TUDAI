import java.time.LocalDate;

public class Ejecutable {
    public static void main(String[] args) {

        LocalDate fechaVencimiento = LocalDate.of(2026, 8, 25);
        LocalDate fechaEnvasado = LocalDate.of(2026, 2, 10);

        System.out.println("=================================================");
        System.out.println("       SISTEMA DE CONTROL AVÍCOLA - TEST         ");
        System.out.println("=================================================");
        System.out.println();

        ProductoFrio quesoRefrigerado = new ProductoFrio(
            fechaVencimiento, 
            fechaEnvasado, 
            "Granja La Campiña", 
            10542,
            4.5,
            99823
        );

        CongeladoAgua merluzaCongelada = new CongeladoAgua(
            fechaVencimiento, 
            fechaEnvasado, 
            "Pesquera del Sur", 
            20891,
            -18.0,  // Temperatura recomendada
            44102,
            35.2 
        );

        System.out.println("Prueba 1: Etiqueta de Producto Refrigerado");
        System.out.println(quesoRefrigerado.getEtiqueta());
        System.out.println();

        System.out.println("Prueba 2: Etiqueta de Producto Congelado por Agua");
        System.out.println(merluzaCongelada.getEtiqueta());
        System.out.println();
        System.out.println("=================================================");
    }
}
