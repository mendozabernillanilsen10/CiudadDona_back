package comciudad.dona.service;

import java.util.List;  
import java.util.UUID;
import org.springframework.stereotype.Service;
import comciudad.dona.entity.DescripcionAgua;
import comciudad.dona.entity.MedidasProducto;

@Service
public interface DescripcionAguaService {
	public List<DescripcionAgua> findAll();
	public DescripcionAgua findById(UUID id);
	public DescripcionAgua save(DescripcionAgua objet);
	public void delete(UUID id);
	public List<DescripcionAgua> listaDescripMedida(MedidasProducto des);
}
