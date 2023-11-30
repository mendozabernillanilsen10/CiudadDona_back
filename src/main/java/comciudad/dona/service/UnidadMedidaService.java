package comciudad.dona.service;
import java.util.List; 
import java.util.UUID;
import comciudad.dona.entity.UnidadMedida;

public interface UnidadMedidaService {
	public List<UnidadMedida> findAll();
	public UnidadMedida findById(UUID id);
	public UnidadMedida save(UnidadMedida objet);
	public void delete(UUID id);
}
