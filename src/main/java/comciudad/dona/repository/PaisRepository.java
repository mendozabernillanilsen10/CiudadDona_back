package comciudad.dona.repository;
import java.util.List; 
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comciudad.dona.entity.Pais;
@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer>{
	List<Pais> findBynombreContaining(String nombre, Pageable page);

}
