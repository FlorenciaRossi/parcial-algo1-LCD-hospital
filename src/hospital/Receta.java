package hospital;

import hospital.estudios.Estudio;

public class Receta {
    private Profesional profesional;
    private Paciente paciente;
    private Estudio[] estudios;
    private Estado estado;

    public Receta(Profesional profesional, Paciente paciente, Estudio[] estudios) {
        this.profesional = profesional;
        this.paciente = paciente;
        this.estudios = estudios;
        estado = Estado.PENDIENTE;
    }

    public Estado getEstado() {
        return estado;
    }

    public void procesar() {
        for(Estudio estudio: estudios){
            estudio.relizarse(paciente, profesional);
        }
        estado = Estado.REALIZADO;
    }
    
    public Paciente getPaciente() {
        return paciente;
    }

    public Estudio[] getEstudios() {
        return estudios;
    }

    @Override
    public String toString() {
        String salida = "- Profesional: " + profesional + "\n" +
                        "- Paciente: " + paciente+ "\n" +
                        "- Estado: " + estado + "\n" + 
                        "- Estudios: ";
        for (Estudio estudio : estudios){
            salida += estudio.toString() + "\n";
        }
        return salida;
    }
    // Recetas de Pura Salud:
    // Receta 1:
    // - Profesional: Juana [12345]
    // - Paciente: Pedro [35234111]
    // - Estado: PROCESADA
    // - Estudios:
    // - RX: Estudio de imagen RX de columna (REALIZADO)
    // - RX: Estudio de imagen RX de torax (REALIZADO)

}