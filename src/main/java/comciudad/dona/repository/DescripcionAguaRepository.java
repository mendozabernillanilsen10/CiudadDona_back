package comciudad.dona.repository;  
import java.util.List; 
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comciudad.dona.entity.DescripcionAgua;
import comciudad.dona.entity.MedidasProducto;


@Repository
public interface DescripcionAguaRepository  extends JpaRepository<DescripcionAgua, UUID >{
    List<DescripcionAgua> findByMedidasProducto(MedidasProducto medidasProducto);

	

}
