package hospital.estudios;

public class EstudioRX extends Estudio{
    private String zona;

    public EstudioRX(String zona){
        super("RX", "Estudio de imagen RX de "+ zona);
        this.zona = zona;
    }

}
