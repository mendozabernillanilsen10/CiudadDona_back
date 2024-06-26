package comciudad.dona.repository;
import java.util.List; 
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comciudad.dona.entity.DescripcionAgua;
import comciudad.dona.entity.ImagesProduct;
@Repository
public interface ImagesProductRepository   extends JpaRepository<ImagesProduct, UUID > {
	List<ImagesProduct> findBydescripcionAgua (DescripcionAgua descripcionAgua);

}
