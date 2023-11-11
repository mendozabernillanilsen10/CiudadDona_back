package comciudad.dona.service;
import java.util.List; 
import java.util.UUID;
import org.springframework.data.domain.Pageable;
import comciudad.dona.entity.Address;

import comciudad.dona.entity.User;

public interface AddressService {
	public List<Address> findAll(Pageable page);
	public Address findById(UUID id); 
	public Address save(Address adres); 
	public void delete(UUID id); 
	public Address finByIdUser(User idUser); 

	
	
	
}
