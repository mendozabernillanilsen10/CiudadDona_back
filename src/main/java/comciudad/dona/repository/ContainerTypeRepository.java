package comciudad.dona.repository;

import java.util.List;  
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comciudad.dona.entity.ContainerType;
import comciudad.dona.entity.typeProduct;
@Repository
public interface ContainerTypeRepository extends  JpaRepository<ContainerType,UUID>{
	List<ContainerType> findBytypeProduct (typeProduct typeProduct);

}
