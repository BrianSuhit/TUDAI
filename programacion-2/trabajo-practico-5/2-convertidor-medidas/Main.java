
public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("          PRUEBA DE CONVERSOR DE MEDIDAS         ");
        System.out.println("=================================================");
        System.out.println();

        // 1. Probar conversión de Centímetros a Pulgadas
        double cm = 10.0;
        double pulgadas = Conversor.centimetroAPulgada(cm);
        System.out.println(cm + " cm equivalen a: " + pulgadas + " pulgadas");

        // 2. Probar conversión de Kilogramos a Libras
        double kg = 5.0;
        double libras = Conversor.kilogramoALibra(kg);
        System.out.println(kg + " kg equivalen a: " + libras + " libras");

        // 3. Probar conversión de Litros a Galones
        double lt = 10.0;
        double galones = Conversor.litroAGalon(lt);
        System.out.println(lt + " litros equivalen a: " + galones + " galones");

        System.out.println();
        System.out.println("=================================================");
        
        //Conversor prueba = new Conversor(); -> esto daria error porque la clase es static
    }
}