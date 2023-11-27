package comciudad.dona.service;
import java.util.List; 
import java.util.UUID;
import comciudad.dona.entity.MedidasProducto;

public interface MedidasProductoService {
	public List<MedidasProducto> findAll();

	public MedidasProducto findById(UUID id);

	public MedidasProducto save(MedidasProducto objet);

	public void delete(UUID id);


}
