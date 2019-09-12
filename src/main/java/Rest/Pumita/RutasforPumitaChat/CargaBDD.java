package Rest.Pumita.RutasforPumitaChat;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class CargaBDD {

    @Bean
    CommandLineRunner initDatabase(BddRutas repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Ruta("linea1",5, "Achumani","San Pedro")));
            log.info("Preloading " + repository.save(new Ruta("linea2",8, "Chasquipampa","PUC")));
        };
    }
}