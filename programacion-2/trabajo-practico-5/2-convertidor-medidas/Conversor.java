public class Conversor {
    
    public static final double CM_POR_PULGADA = 2.54;
    public static final double KG_POR_LIBRA  = 0.453592;
    public static final double LITROS_POR_GALON  = 3.78541;

    private Conversor(){

    }

    public static double centimetroAPulgada(double cm){
        return cm / CM_POR_PULGADA;
    }

    public static double kilogramoALibra(double kg){
        return kg / KG_POR_LIBRA;
    }

    public static double litroAGalon(double lt){
        return lt / LITROS_POR_GALON;
    }

    public static double pulgadaACentimetro(double pulgadas){
        return pulgadas * CM_POR_PULGADA;
    }

    public static double libraAKilogramo(double libras){
        return libras * KG_POR_LIBRA;
    }

    public static double galonALitro(double galones){
        return galones * LITROS_POR_GALON;
    }
}
