import java.util.ArrayList;

public class Celular {
    
    private ArrayList<Contacto> contactos;

    public Celular() {
        this.contactos = new ArrayList<Contacto>();
    }

    public void agregarContacto(Contacto c) {
        if(!contactos.contains(c)){
            contactos.add(c);
        }
    }

    public int getCantidadContactos() {
        return contactos.size();
    }

    public int getContactosRepetidos() {
        int suma = 0;
        for(int i = 0; i < contactos.size(); i++){
            for(int j = i + 1; j < contactos.size(); j++){
                if(contactos.get(i).esIgualA(contactos.get(j))){
                    suma++;
                }
            }
        }
        return suma;
    }

    public int getPromedioEdad() {
        if(contactos.isEmpty()){
            return 0;
        }
        int suma = 0;
        for(int i = 0; i < contactos.size(); i++){
            suma += contactos.get(i).getEdad();
        }
        return suma / contactos.size();
    }
}