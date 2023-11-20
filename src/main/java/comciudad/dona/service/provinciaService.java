package comciudad.dona.service;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import comciudad.dona.entity.ubdepartamento;
import comciudad.dona.entity.ubprovincia;
@Service
public interface provinciaService {
	public List<ubprovincia> findAll(Pageable page);
	public List<ubprovincia> finByNombre(String nombre,Pageable page);
	public ubprovincia findById(Long id);
	public ubprovincia save(ubprovincia articulo);
	public void delete(Long id);
	List<ubprovincia> findByidDepa(ubdepartamento p);
}
