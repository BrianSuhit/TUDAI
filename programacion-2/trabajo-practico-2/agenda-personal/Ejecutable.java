import java.time.LocalDateTime;

public class Ejecutable {
    public static void main(String[] args) {

        Asistente asistente1 = new Asistente("brian", "249-4209378", "braisuhit@gmail.com");

        Reunion reunionTP2 = new Reunion("trabajo practico 2", 
        "facultad de exactas", 
        3, 
        1, 
        LocalDateTime.of(2026, 8, 18, 15, 0));

        Reunion reunionNueva = new Reunion("TP de Objetos", "Casa", 3, 1,LocalDateTime.of(2026, 8, 18, 11, 0));

        Agenda agenda = new Agenda(2);

        reunionTP2.AgregarAsistente(asistente1, 0);

        agenda.AgregarReunion(reunionTP2, 0);

        if(!agenda.TieneConflicto(reunionNueva)){
            agenda.AgregarReunion(reunionNueva, 1);
            System.out.println("Reunion agendada con exito");
        }else{
            System.out.println("No se pudo agendar la reunion");
        }
    }
}
