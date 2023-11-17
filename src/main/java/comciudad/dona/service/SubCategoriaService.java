package comciudad.dona.service;
import java.util.List; 
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;
import comciudad.dona.entity.Category;
import comciudad.dona.entity.Subcategory;
public interface SubCategoriaService {
	public List<Subcategory> findAll();
	public Subcategory findById(UUID id); 
	public Subcategory save(Subcategory com, MultipartFile file); 
	public void delete(UUID id); 
	public Subcategory finByCategory(Category categoria); 

}
