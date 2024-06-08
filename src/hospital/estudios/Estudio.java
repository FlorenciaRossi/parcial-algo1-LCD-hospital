package hospital.estudios;

import hospital.Estado;
import hospital.Notificador;
import hospital.Paciente;
import hospital.Profesional;

public abstract class Estudio {
    private Estado estado;
    private String nombre;
    private String detalle;

    public Estudio(String nombre, String detalle){
        estado = Estado.PENDIENTE;
        this.nombre = nombre;
        this.detalle = detalle;
    }

    public void relizarse(Paciente paciente, Profesional profesional) {
        estado = Estado.REALIZADO;
        Notificador.notificarPaciente(paciente, this);
        Notificador.notificarProfesional(profesional, this);
    }

    public String nombre(){
        return nombre;
    }

    public String detalle(){
        return detalle;
    }
    public Estado estado(){
        return estado;
    }
    
    @Override
    public String toString() {
        return "- "+ nombre + ": " + detalle + " (" + estado + ")";
    }
     // - RX: Estudio de imagen RX de columna (REALIZADO)

}
