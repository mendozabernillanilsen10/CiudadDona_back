package comciudad.dona.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import comciudad.dona.entity.Category;
import comciudad.dona.entity.Subcategory;
public interface SubCategoriaService {
	public List<Subcategory> findAll(Pageable page);
	public Subcategory findById(UUID id); 
	public Subcategory save(Subcategory adres); 
	public void delete(UUID id); 
	public Subcategory finByCategory(Category categoria); 

}
