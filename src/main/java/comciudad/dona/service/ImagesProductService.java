package comciudad.dona.service;

import java.util.List; 
import java.util.UUID;

import comciudad.dona.entity.DescripcionAgua;
import comciudad.dona.entity.ImagesProduct;


public interface ImagesProductService {
	public List<ImagesProduct> findAll();

	public ImagesProduct findById(UUID id);

	public ImagesProduct save(ImagesProduct objet);

	public void delete(UUID id);
	
	public List<ImagesProduct> listaDescripcionProducto(DescripcionAgua objet);

}
