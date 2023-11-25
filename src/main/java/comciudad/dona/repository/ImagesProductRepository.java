package comciudad.dona.repository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import comciudad.dona.entity.ImagesProduct;

public interface ImagesProductRepository   extends JpaRepository<ImagesProduct, UUID > {

	
	
}
