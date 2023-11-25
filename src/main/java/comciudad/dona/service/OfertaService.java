package comciudad.dona.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import comciudad.dona.entity.Oferta;
@Service
public interface OfertaService {
	public List<Oferta> findAll();

	public Oferta findById(UUID id);

	public Oferta save(Oferta objet);

	public void delete(UUID id);
	
	
}
