package comciudad.dona.repository;

import comciudad.dona.entity.*;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LitersRepository extends JpaRepository<liters, UUID> {

}
