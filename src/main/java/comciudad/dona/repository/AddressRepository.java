package comciudad.dona.repository;

import java.util.UUID; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comciudad.dona.entity.Address;
import comciudad.dona.entity.User;
@Repository
public interface AddressRepository extends  JpaRepository<Address,UUID> {
	Address findByidUser (User idUser);
}
