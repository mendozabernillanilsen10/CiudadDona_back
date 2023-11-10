package comciudad.dona.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;

import comciudad.dona.entity.Responsible;

public interface ResponsiService {
	public List<Responsible> findAll(Pageable page);
	public Responsible findById(UUID id);
	public Responsible save(Responsible articulo);
	public void delete(UUID id);
}
