package comciudad.dona.service;

import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;


import comciudad.dona.entity.Category;

public interface categoriaService {
	void init();

	public List<Category> findAll(Pageable page);
	public List<Category> finByNombre(String nombre,Pageable page); 
	public Category findById(UUID id); 
	public Category save(Category articulo, MultipartFile foto); 
	public void delete(UUID id);
    Resource loadAsResource(String filename);
    Path load(String filename);

}
