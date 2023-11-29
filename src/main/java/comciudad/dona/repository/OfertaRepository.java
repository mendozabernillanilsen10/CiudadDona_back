package comciudad.dona.repository;

import java.util.List; 
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import comciudad.dona.entity.DescripcionAgua;
import comciudad.dona.entity.Oferta;

public interface OfertaRepository extends JpaRepository <Oferta,UUID>{
	List<Oferta> findBydescripcionAgua (DescripcionAgua descripcionAgua);

}
