package comciudad.dona.service;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import comciudad.dona.entity.Brand;
import comciudad.dona.entity.liters;
@Service
public interface LitersService {
	public List<liters> findAll();
	public liters findById(UUID id);
	public liters save(liters objet);
	public void delete(UUID id);

	//public List<liters> finByIdUser(Category categori);
}
