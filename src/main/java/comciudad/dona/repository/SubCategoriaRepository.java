package comciudad.dona.repository;
import java.util.List;
import java.util.UUID;  
import org.springframework.data.jpa.repository.JpaRepository;

import comciudad.dona.entity.Category;
import comciudad.dona.entity.Subcategory;
public interface SubCategoriaRepository extends  JpaRepository<Subcategory, UUID>{
	public List<Subcategory> findByidcategory (Category idcategory);
    public Subcategory findByname(String name);

	
	
}
