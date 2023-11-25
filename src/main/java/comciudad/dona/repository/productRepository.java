package comciudad.dona.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import comciudad.dona.entity.Product;

public interface productRepository extends  JpaRepository<Product,UUID>{

}
