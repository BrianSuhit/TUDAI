public class Ejectuable {
    public static void main(String[] args) {
        Fabrica fabrica = new Fabrica();

        Mueble silla = new Mueble("Silla", 5.0, 100.0, "Roble", "Marrón");
        Mueble mesa = new Mueble("Mesa", 20.0, 300.0, "Pino", "Negro");

        fabrica.agregarStock(silla);
        fabrica.agregarStock(mesa);

        System.out.println("Costo total de fabricación: " + fabrica.costoTotalFabricacion());
        System.out.println("Precio de venta total: " + fabrica.precioVentaTotal());
    }
}
