package comciudad.dona.repository;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comciudad.dona.entity.ubdistrito;
import comciudad.dona.entity.ubprovincia;

@Repository
public interface DistritoRepository2 extends JpaRepository<ubdistrito, Long> {
	List<ubdistrito> findBynombreContaining(String nombre, Pageable page);
	List<ubdistrito> findByidProv(ubprovincia cliente);
}
