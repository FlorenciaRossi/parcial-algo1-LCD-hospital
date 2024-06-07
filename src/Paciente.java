
public class Paciente {
    private int dni;
    private String nombre;

    public Paciente(String string, int i) {
        dni = i;
        nombre = string;
    }

    public int getDni() {
        return dni;
    }
    public String getNombre(){
        return nombre;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return nombre + " [" + dni + "]";
    }
    //Pedro [35234111]

}
