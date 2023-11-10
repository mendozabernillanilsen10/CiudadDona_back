package comciudad.dona.repository;
import java.util.UUID; 
import org.springframework.data.jpa.repository.JpaRepository;
import comciudad.dona.entity.Responsible;
public interface ResponsibleRepository extends JpaRepository< Responsible,UUID> {

}
