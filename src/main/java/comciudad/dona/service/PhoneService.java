
package comciudad.dona.service;

import java.util.List; 
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import comciudad.dona.entity.Phone;
import comciudad.dona.entity.User;
@Service
public interface PhoneService {
	public List<Phone> findAll(Pageable page);
	public Phone findById(UUID id); 
	public Phone save(Phone phone ); 
	public void delete(UUID id); 
	public Phone finByIdUser(User idUser); 
	
	
	
}
