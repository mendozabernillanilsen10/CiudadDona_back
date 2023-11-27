package comciudad.dona.repository;

import java.util.List; 
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import comciudad.dona.entity.ContainerType;
import comciudad.dona.entity.MedidasProducto;
public interface MedidasProductoRepository extends JpaRepository<MedidasProducto, UUID >{

}
