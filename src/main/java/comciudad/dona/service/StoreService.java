package comciudad.dona.service;
import java.util.List; 
import java.util.UUID;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import comciudad.dona.entity.Category;
import comciudad.dona.entity.Store;
import comciudad.dona.entity.Subcategory;
@Service
public interface StoreService {
	public List<Store> findAll(Pageable page);
	public Store findById(UUID id); 
	public Store save(Store estore  , MultipartFile foto); 
	public void delete(UUID id); 
	public Store listarCategorias(Category categoria); 
	public Store listarSubCategorias(Subcategory subcategoria); 
	public List<Category> obtenerCategoriasPorDistrito(Long idDistrito);
	public List<Subcategory> obtenerSubcategoriasPorTiendaDistritoYCategoria(Long idDistrito, UUID idCategoria) ;
	public List<Store> obtenerTiendasPorDistritoYCategoria(Long idDistrito, UUID idCategoria);
	

	public List<Store> obtenerTiendasPorDistrito(Long pIdDistrito,
			UUID pIdCategoria ,UUID pIdSubcategoria);
}
