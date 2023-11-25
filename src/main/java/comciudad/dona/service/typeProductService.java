package comciudad.dona.service;

import java.util.List;
import java.util.UUID;
import comciudad.dona.entity.typeProduct;

public interface typeProductService {
	public List<typeProduct> findAll();

	public typeProduct findById(UUID id);

	public typeProduct save(typeProduct objet);

	public void delete(UUID id);
}
