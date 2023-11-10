package comciudad.dona.repository;

import java.util.UUID; 
import org.springframework.data.jpa.repository.JpaRepository;
import comciudad.dona.entity.Address;
import comciudad.dona.entity.User;
public interface AddressRepository extends  JpaRepository<Address,UUID> {
	Address findByidUser (User idUser);
}
