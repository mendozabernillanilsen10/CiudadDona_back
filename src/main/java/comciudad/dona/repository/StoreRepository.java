package comciudad.dona.repository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import comciudad.dona.entity.Store;
public interface StoreRepository extends JpaRepository < Store  ,UUID >{

	
	
	
}
