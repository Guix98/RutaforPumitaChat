package Rest.Pumita.RutasforPumitaChat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Data
@Entity
class Ruta {
    private @Id @GeneratedValue Long id;
    private String nombre;
    private int paradas;
    private String primerp;
    private String ultip;
    Ruta() {}

    Ruta(String nombre, int paradas, String primerp, String ultip) {
        this.nombre = nombre;
        this.paradas = paradas;
        this.primerp = primerp;
        this.ultip = ultip;
    }

}

