package hospital;
import java.util.ArrayList;
import java.util.List;

import hospital.estudios.Estudio;
import hospital.excepciones.SystemException;

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
        Profesional nuevo = new Profesional(string, i);
        if( profesionalRegistrado(nuevo)){
            throw new SystemException("El profesional ya se encuentra registrado.");
        }
        return nuevo;
    }


    public Paciente registrarPaciente(String string, int i) {
        Paciente nuevo =new Paciente(string, i);
        if( pacienteRegistrado(nuevo)){
            throw new SystemException("El paciente ya se encuentra registrado.");
        }
        pacientes.add(nuevo);
        return nuevo; 
    }

    public Receta cargarReceta(Profesional profesional, Paciente paciente, Estudio[] estudios) {
        if(!profesionalRegistrado(profesional)){
            throw new SystemException("El profesional no está registrado.");
        }
        if(!pacienteRegistrado(paciente)){
            throw new SystemException("El paciente no está registrado.");
        }
        Receta r = new Receta(profesional, paciente, estudios);
        recetas.add(r);
        return r;
    }

    public void procesar(Receta receta) {
        if(receta.getEstado() == Estado.REALIZADO){
            throw new SystemException("La receta ya fue procesada.");
        }   
        receta.procesar(); 
    }

    private boolean profesionalRegistrado(Profesional p) {
        Boolean registrado = false;
        for (Profesional profesional : profesionales){
            if ( profesional.equals(p)){
                registrado = true;
            }
        }
        return registrado;
    }

    private boolean pacienteRegistrado(Paciente p) {
        Boolean registrado = false;
        for (Paciente paicente : pacientes){
            if ( paicente.equals(p) ){
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
            if (receta.getPaciente().equals(paciente)){
                r.add(receta);
            }
        }
        return r;
    }



}
