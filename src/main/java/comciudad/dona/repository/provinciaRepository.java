package comciudad.dona.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comciudad.dona.entity.ubdepartamento;
import comciudad.dona.entity.ubprovincia;
@Repository
public interface provinciaRepository  extends JpaRepository<ubprovincia, Long>{
	List<ubprovincia> findBynombreContaining(String nombre, Pageable page);
	List<ubprovincia> findByidDepa(ubdepartamento departamento);
}


