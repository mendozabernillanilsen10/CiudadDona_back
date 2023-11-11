package comciudad.dona.repository;
import java.util.UUID;  
import org.springframework.data.jpa.repository.JpaRepository;

import comciudad.dona.entity.Category;
import comciudad.dona.entity.Subcategory;
public interface SubCategoriaRepository extends  JpaRepository<Subcategory, UUID>{
	public Subcategory findBycategory (Category categoria);
    public Subcategory findByname(String name);

	
	
}
