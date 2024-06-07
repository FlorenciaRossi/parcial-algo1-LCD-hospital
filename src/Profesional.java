
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


}
