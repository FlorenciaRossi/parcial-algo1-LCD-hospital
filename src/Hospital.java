import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String nombre;
    private List<Profesional> profesionales;
    private List<Paciente> pacientes;
    private List<Receta> recetas;

    public Hospital(String string) {
        nombre = string;
        profesionales = new ArrayList<>();
        pacientes = new ArrayList<>();
        recetas = new ArrayList<>();
    }

    public Profesional registrarProfesional(String string, int i) {
        if( profesionalRegistrado(i)){
            throw new UnsupportedOperationException("el profesional ya se encuentra registrado");
        }
        return new Profesional(string, i);
    }


    public Paciente registrarPaciente(String string, int i) {
        if( pacienteRegistrado(i)){
            throw new UnsupportedOperationException("el profesional ya se encuentra registrado");
        }
        Paciente nuevo =new Paciente(string, i);
        pacientes.add(nuevo);
        return nuevo; 
    }

    public Receta cargarReceta(Profesional profesional, Paciente paciente, Estudio[] estudios) {
        Receta r = new Receta(profesional, paciente, estudios);
        recetas.add(r);
        return r;
    }

    public void procesar(Receta receta) {
        if(receta.getEstado() == Estado.REALIZADO){
            throw new UnsupportedOperationException("la receta ya fue procesada");
        }   
        receta.procesar(); 
    }

    private boolean profesionalRegistrado(int i) {
        Boolean registrado = false;
        for (Profesional profesional : profesionales){
            if ( profesional.getMatricula() == i ){
                registrado = true;
            }
        }
        return registrado;
    }

    private boolean pacienteRegistrado(int i) {
        Boolean registrado = false;
        for (Paciente paicente : pacientes){
            if ( paicente.getDni() == i ){
                registrado = true;
            }
        }
        return registrado;
    }

    public void mostrarRecetas() {
        int i =0;
        System.out.println("Recetas de " + nombre);
        for(Receta receta: recetas){
            System.out.println("Receta "+ i);
            System.out.println(receta);
            i++;
        }
    }
  // Recetas de Pura Salud:
    // Receta 1:

    public void mostrarRecetasProcesadas() {
        int i =0;
        System.out.println("Recetas de " + nombre);
        for(Receta receta: recetas){
            System.out.println("Receta "+ i);
            System.out.println(receta);
            i++;
        }
    }

    public void mostrarPacientesConEstudios(int i) {
        System.out.println("Pacientes con al menos "+i+" estudios realizados en "+ nombre+": ");
        for (Paciente paciente : pacientes){
            if (cantidadDeEstudios(recetasDe(paciente)) >= i){
                System.out.println(paciente);
            };
        }
    }

    private int cantidadDeEstudios(List<Receta> recetas) {
        int suma = 0;
        for ( Receta receta : recetas){
            suma += receta.getEstudios().length;
        }
        return suma;
    }

    private List<Receta> recetasDe(Paciente paciente) {
        List<Receta> r = new ArrayList<>();
        for ( Receta receta: recetas){
            if (receta.getPaciente().getDni() == paciente.getDni()){
                r.add(receta);
            }
        }
        return r;
    }



}
