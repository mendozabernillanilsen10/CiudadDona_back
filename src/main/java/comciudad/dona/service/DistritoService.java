package comciudad.dona.service;

import java.util.List; 

import org.springframework.data.domain.Pageable;

import comciudad.dona.entity.ubdistrito;
import comciudad.dona.entity.ubprovincia;

public interface DistritoService {
	public List<ubdistrito> findAll(Pageable page);
	public List<ubdistrito> finByNombre(String nombre,Pageable page);
	public ubdistrito findById(Long id);
	public ubdistrito save(ubdistrito articulo);
	public void delete(Long id);
	List<ubdistrito> findByidProv(ubprovincia p);
}
