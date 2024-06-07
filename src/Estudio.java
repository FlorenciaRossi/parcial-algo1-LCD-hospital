
public class Estudio {
    private Estado estado;
    private String nombre;
    private String detalle;

    public Estudio(){
        estado = Estado.PENDIENTE;
    }

    public void relizarse(Paciente paciente, Profesional profesional) {
        estado = Estado.REALIZADO;
        notificarPaciente(paciente);
        notificarProfesional(profesional);
    }

    protected void setNombre(String nombre){
        this.nombre = nombre;
    }
    protected void setDetalle(String detalle){
        this.detalle = detalle;
    }
    //Notificando a profesional Juana [12345] sobre RX: Estudio de imagen RX de columna (REALIZADO)
    private void notificarProfesional(Profesional profesional) {
        System.out.println("Notificando a profesional " + profesional +
                            " sobre " + nombre + ": "+ detalle +
                            "(" + estado + ")");
    }

    private void notificarPaciente(Paciente paciente) {
        System.out.println("Notificando al paciente " + paciente +
                            " sobre " + nombre + ": "+ detalle +
                            "(" + estado + ")");
    }

    @Override
    public String toString() {
        return "- "+ nombre + ": " + detalle + " (" + estado + ")";
    }
     // - RX: Estudio de imagen RX de columna (REALIZADO)
 
}
