package comciudad.dona.service;
import java.util.List;
import org.springframework.data.domain.Pageable;

import comciudad.dona.entity.ubdepartamento;
import comciudad.dona.entity.ubprovincia;

public interface provinciaService {
	public List<ubprovincia> findAll(Pageable page);
	public List<ubprovincia> finByNombre(String nombre,Pageable page);
	public ubprovincia findById(Long id);
	public ubprovincia save(ubprovincia articulo);
	public void delete(Long id);
	List<ubprovincia> findByidDepa(ubdepartamento p);
}
