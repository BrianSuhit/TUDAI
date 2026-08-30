import java.time.LocalDateTime;

public class Agenda {
    // agenda -> reuniones : tema - lugar - duracion -> asistente : telefono - mail

    Reunion[] reuniones;
    
    public Agenda(int reuniones){
        this.reuniones = new Reunion[reuniones];
    }

    public void AgregarReunion(Reunion nuevaReunion, int pos){
        if(pos >= 0 && pos < reuniones.length){
            this.reuniones[pos] = nuevaReunion;
        }
    }

    public boolean TieneConflicto(Reunion nuevaReunion){
        for(int i = 0; i < reuniones.length; i++){
            Reunion existente  = this.reuniones[i];

            if(existente != null){
                LocalDateTime inicioNueva = nuevaReunion.getFechayHoraInicio();
                LocalDateTime finNueva = nuevaReunion.getFechayHoraFin();

                LocalDateTime inicioExistente = existente.getFechayHoraInicio();
                LocalDateTime finExistente = existente.getFechayHoraFin();


                if(inicioNueva.isBefore(finExistente) && finNueva.isAfter(inicioExistente)){
                    return true;
                }
            }
        }
        return false;
    }
}
