package comciudad.dona.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import comciudad.dona.entity.Oferta;

public interface OfertaRepository extends JpaRepository <Oferta,UUID>{

}
