public class Ejecutable {
    
    public static void main(String[] args) {
        
        double[] impuestosC1 = {20000.0, 15000.0, 30000.0, 10000.0, 15000.0}; // Recauda: 90.000
        double[] impuestosC2 = {5000.0, 10000.0, 8000.0, 12000.0, 5000.0};    // Recauda: 40.000
        double[] impuestosC3 = {2000.0, 3000.0, 1500.0, 4000.0, 1500.0}; 

        Ciudad c1 = new Ciudad("Tandil", 120000, 80000.0, impuestosC1);
        Ciudad c2 = new Ciudad("Mar del Plata", 150000, 55000.0, impuestosC2);
        Ciudad c3 = new Ciudad("Rauch", 80000, 20000.0, impuestosC3);

        Provincia provincia = new Provincia("Buenos Aires", 3);

        provincia.AgregarCiudad(c1, 0);
        provincia.AgregarCiudad(c2, 1);
        provincia.AgregarCiudad(c3, 2);

        Pais pais = new Pais("Argentina", 1);
        pais.AgregarProvincia(provincia, 0);

         System.out.println("--- SISTEMA DE CONTROL DE GASTOS PUBLICOS ---");
        System.out.println("Pais: " + pais.nombre());
        System.out.println("Provincia: " + provincia.nombre());
        System.out.println("Cantidad de ciudades grandes en deficit: " + provincia.CiudadesEnDeficit());
        System.out.println("¿La provincia tiene deficit provincial?: " + provincia.TieneDeficitProvincia());
        System.out.println("Cantidad de provincias en deficit en el pais: " + pais.ProvinciasEnDeficit());

    }
}
