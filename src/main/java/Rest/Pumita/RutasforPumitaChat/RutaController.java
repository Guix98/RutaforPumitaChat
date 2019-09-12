package Rest.Pumita.RutasforPumitaChat;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class RutaController {
    private final BddRutas repository;

    RutaController(BddRutas repository) {
        this.repository = repository;
    }

    @GetMapping("/rutas")
    List<Ruta> all() {
        return repository.findAll();
    }

    @PostMapping("/rutas")
    Ruta newRuta(@RequestBody Ruta newRuta) {
        return repository.save(newRuta);
    }

    @GetMapping("/rutas/{id}")
    Ruta one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RutaNotFoundException(id));
    }

    @PutMapping("/rutas/{id}")
    Ruta replaceRuta(@RequestBody Ruta newRuta, @PathVariable Long id) {

        return repository.findById(id)
                .map(ruta -> {
                    ruta.setNombre(newRuta.getNombre());
                    ruta.setParadas(newRuta.getParadas());
                    ruta.setPrimerp(newRuta.getPrimerp());
                    ruta.setUltip(newRuta.getUltip());

                    return repository.save(ruta);
                })
                .orElseGet(() -> {
                    newRuta.setId(id);
                    return repository.save(newRuta);
                });
    }

    @DeleteMapping("/rutas/{id}")
    void deleteRuta(@PathVariable Long id) {
        repository.deleteById(id);
    }
}