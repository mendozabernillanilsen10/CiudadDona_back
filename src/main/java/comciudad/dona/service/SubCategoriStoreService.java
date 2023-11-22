package comciudad.dona.service;
import java.util.List;  
import java.util.UUID;
import org.springframework.stereotype.Service;

import comciudad.dona.entity.SubCategoriStore;

@Service
public interface SubCategoriStoreService {
	public List<SubCategoriStore> findAll();
	public SubCategoriStore findById(UUID id); 
	public SubCategoriStore save(SubCategoriStore objet); 
	public void delete(UUID id); 

}
