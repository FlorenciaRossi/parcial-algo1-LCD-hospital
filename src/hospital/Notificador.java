package hospital;

import hospital.estudios.Estudio;

public class Notificador {
    public static void notificarProfesional(Profesional profesional, Estudio estudio) {
        System.out.println("Notificando a profesional " + profesional +
                            " sobre " + estudio.nombre() + ": "+ estudio.detalle() +
                            "(" + estudio.estado() + ")");
    }
    public static void notificarPaciente(Paciente paciente, Estudio estudio) {
        System.out.println("Notificando al paciente " + paciente +
                            " sobre " + estudio.nombre()  + ": "+ estudio.detalle() +
                            "(" + estudio.estado() + ")");
    }
}
