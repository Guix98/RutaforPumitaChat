package Rest.Pumita.RutasforPumitaChat;

public class RutaNotFoundException extends RuntimeException {

    RutaNotFoundException(Long id) {
        super("La ruta " + id+"no existe");
    }
}
