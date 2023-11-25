package comciudad.dona.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import comciudad.dona.entity.MedidasProducto;
import comciudad.dona.entity.typeProduct;

public interface MedidasProductoRepository extends JpaRepository<MedidasProducto, UUID >{
	List<MedidasProducto> findBytypeProduct (typeProduct typeProduct);

}
