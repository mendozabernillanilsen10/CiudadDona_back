package comciudad.dona.service;
import java.util.List;  
import org.springframework.data.domain.Pageable;

import comciudad.dona.entity.Pais;
import comciudad.dona.entity.ubdepartamento;
public interface UbDepartamentoService {
	public List<ubdepartamento> findAll(Pageable page);
	public List<ubdepartamento> finByNombre(String nombre,Pageable page);
	public ubdepartamento findById(Long id);
	public ubdepartamento save(ubdepartamento articulo);
	public void delete(Long id);
	List<ubdepartamento> findBypaisId(Pais p);

}
