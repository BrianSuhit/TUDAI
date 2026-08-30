public class Main {
    public static void main(String[] args) {
        Empresa miEmpresa = new Empresa("Soluciones Informaticas");

        // 1. Juan Hernández: Empleado Común
        Empleado juan = new Empleado("Juan", "Hernandez", "27.832.123", 17000.0);
        miEmpresa.addEmpleado(juan);

        // 2. Martin: Vendedor (Sueldo 15.000 + 5% ventas)
        EmpleadoVendedor martin = new EmpleadoVendedor("Martin", "Gomez", "33.444.555", 15000.0, 5.0);
        martin.registrarVenta(100000.0); // Vendió $100.000, su extra debería ser $5.000
        miEmpresa.addEmpleado(martin);

        // 3. Pablo: Vendedor (Sueldo 13.000 + 10% ventas)
        EmpleadoVendedor pablo = new EmpleadoVendedor("Pablo", "Lopez", "35.666.777", 13000.0, 10.0);
        pablo.registrarVenta(50000.0); // Vendió $50.000, su extra debería ser $5.000
        miEmpresa.addEmpleado(pablo);

        // 4. Julian: Empleado con Bono ($1000 si supera 50 ventas)
        EmpleadoBono julian = new EmpleadoBono("Julian", "Perez", "38.999.000", 16000.0, 50, 1000.0);
        // Simulamos que hace 55 ventas (supera la meta)
        for (int i = 0; i < 55; i++) {
            julian.registrarVenta();
        }
        miEmpresa.addEmpleado(julian);

        // 5. Mauro: Empleado con Bono ($3000 si supera 100 ventas)
        EmpleadoBono mauro = new EmpleadoBono("Mauro", "Diaz", "39.111.222", 16000.0, 100, 3000.0);
        // Simulamos que hace solo 40 ventas (NO supera la meta de 100)
        for (int i = 0; i < 40; i++) {
            mauro.registrarVenta();
        }
        miEmpresa.addEmpleado(mauro);

        // --- IMPRESIÓN DE RESULTADOS ---
        System.out.println("=================================================");
        System.out.println("Sueldo de Juan (Comun - Esperado: 17000): $" + juan.getSueldoAPagar());
        System.out.println("Sueldo de Martin (Vendedor - Esperado: 20000): $" + martin.getSueldoAPagar());
        System.out.println("Sueldo de Pablo (Vendedor - Esperado: 18000): $" + pablo.getSueldoAPagar());
        System.out.println("Sueldo de Julian (Bono cobrado - Esperado: 17000): $" + julian.getSueldoAPagar());
        System.out.println("Sueldo de Mauro (Bono NO cobrado - Esperado: 16000): $" + mauro.getSueldoAPagar());
        System.out.println("-------------------------------------------------");
        System.out.println("GASTO TOTAL EN SUELDOS (Esperado: 88000): $" + miEmpresa.getSumaTotalSueldos());
        System.out.println("=================================================");
    }
}