package hospital;
import java.util.Objects;

public class Paciente {
    private int dni;
    private String nombre;

    public Paciente(String string, int i) {
        dni = i;
        nombre = string;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " [" + dni + "]";
    }

    //Pedro [35234111]
    @Override
    public boolean equals(Object obj) {
        if( this == obj){
            return true;
        }
        if( obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        Paciente otro2 = (Paciente)obj;
        return dni == otro2.dni;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}
