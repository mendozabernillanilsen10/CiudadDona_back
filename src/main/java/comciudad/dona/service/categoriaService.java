package comciudad.dona.service;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import comciudad.dona.entity.Category;
@Service

public interface categoriaService {
	public List<Category> findAll();
	public List<Category> finByNombre(String nombre,Pageable page); 
	public Category findById(UUID id) ; 
	public Category save(Category articulo, MultipartFile foto); 
	public void delete(UUID id);


}
