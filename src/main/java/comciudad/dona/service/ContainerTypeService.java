package comciudad.dona.service;
import java.util.List; 
import java.util.UUID;
import org.springframework.stereotype.Service;
import comciudad.dona.entity.ContainerType;
import comciudad.dona.entity.typeProduct;
@Service
public interface ContainerTypeService {
	public List<ContainerType> findAll();
	public ContainerType findById(UUID id);
	public ContainerType save(ContainerType objet);
	public void delete(UUID id);
	public List<ContainerType> finByIdUser(typeProduct typeProduct);
}
