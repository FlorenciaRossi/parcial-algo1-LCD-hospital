
public class EstudioRX extends Estudio{
    private String zona;

    public EstudioRX(String zona){
        super();
        this.zona = zona;
        setNombre("RX");
        setDetalle("Estudio de imagen RX de "+ zona);
    }

}
