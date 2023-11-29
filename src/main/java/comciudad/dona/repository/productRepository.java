package comciudad.dona.repository;

import java.util.List; 
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import comciudad.dona.entity.Brand;
import comciudad.dona.entity.Product;
import comciudad.dona.entity.Store;

public interface productRepository extends  JpaRepository<Product,UUID>{
	List<Product> findBybrand(Brand brand);
	List<Product> findBystore(Store store);
}
