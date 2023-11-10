package comciudad.dona.repository;
import java.util.List;  
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comciudad.dona.entity.Pais;
import comciudad.dona.entity.ubdepartamento;
@Repository
public interface UbDepartamentoRepository extends JpaRepository<ubdepartamento, Long> {
	List<ubdepartamento> findBynombreContaining(String nombre, Pageable page);
	List<ubdepartamento> findBypaisId(Pais cliente);

}