public class CerealPastura extends Cereal {

    public CerealPastura(String nombre) {
        super(nombre);
    }
 
    @Override
    public boolean puedeSembrarseEn(Lote lote) {
        // 1. Debe cumplir los requisitos comunes del padre (tener todos los minerales)
        // 2. Y además, cumplir con la restricción física de las hectáreas
        return super.puedeSembrarseEn(lote) && lote.getSuperficie() >= 50.0;
    }
}