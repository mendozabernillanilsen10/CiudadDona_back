package comciudad.dona.service;

import java.util.List; 
import java.util.UUID;

import org.springframework.stereotype.Service;
import comciudad.dona.entity.Brand;
import comciudad.dona.entity.Category;
@Service
public interface BrandService {
	public List<Brand> findAll();

	public Brand findById(UUID id);

	public Brand save(Brand objet);

	public void delete(UUID id);

	public List<Brand> finByIdUser(Category categori);

}
