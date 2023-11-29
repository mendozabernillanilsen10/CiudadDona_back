package comciudad.dona.repository;

import java.util.List; 
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import comciudad.dona.entity.DescripcionAgua;
import comciudad.dona.entity.Product;
@Repository
public interface DescripcionAguaRepository  extends JpaRepository<DescripcionAgua, UUID >{
	List<DescripcionAgua> findByproduct (Product product);

	

}
