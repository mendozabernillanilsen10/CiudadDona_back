package comciudad.dona.service;

import java.util.List; 
import java.util.UUID;

import org.springframework.stereotype.Service;

import comciudad.dona.entity.CategoriStore;
@Service
public interface CategoriStoreService {
	public List<CategoriStore> findAll();
	public CategoriStore findById(UUID id); 
	public CategoriStore save(CategoriStore objet); 
	public void delete(UUID id); 
	//public SubCategoriStore finByIdUser(User idUser); 

}
