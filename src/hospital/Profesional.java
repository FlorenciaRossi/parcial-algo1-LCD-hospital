package hospital;
import java.util.Objects;

public class Profesional {
    private int matricula;
    private String nombre;
    public Profesional(String string, int i) {
        matricula = i;
        nombre = string;
    }

    public int getMatricula() {
        return matricula;     
    }

    public String getNombre() {
        return nombre;
    }
    
    @Override
    public String toString() {
        return nombre + " [" + matricula+ "]";
    }

    @Override
    public boolean equals(Object obj) {
        if( this == obj){
            return true;
        }
        if( obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        Profesional otro2 = (Profesional) obj;
        return matricula == otro2.getMatricula();
    }
    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }


}
