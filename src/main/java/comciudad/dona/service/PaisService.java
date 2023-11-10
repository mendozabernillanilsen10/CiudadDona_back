package comciudad.dona.service;

import org.springframework.data.domain.Pageable;

import comciudad.dona.entity.Pais;

import java.util.List;

public interface PaisService {
	public List<Pais> findAll(Pageable page);
	public List<Pais> finByNombre(String nombre,Pageable page);
	public Pais findById(int id);
	public Pais save(Pais articulo);
	public void delete(int id);
}
