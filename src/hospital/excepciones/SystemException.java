package hospital.excepciones;

public class SystemException extends UnsupportedOperationException {
    public SystemException(String mensaje){
        super(mensaje);
    }
}
