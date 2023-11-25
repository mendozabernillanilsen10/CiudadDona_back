package comciudad.dona.repository;
import java.util.List;  
import java.util.UUID; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comciudad.dona.entity.typeProduct;
import comciudad.dona.entity.Brand;
@Repository
public interface BrandRepository extends JpaRepository<Brand, UUID >{
	List<Brand> findBytypeProduct (typeProduct typeProduct);
}
