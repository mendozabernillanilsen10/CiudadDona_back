package comciudad.dona.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import comciudad.dona.entity.UnidadMedida;
public interface UnidadMedidaRepository  extends JpaRepository< UnidadMedida, UUID >{



}
