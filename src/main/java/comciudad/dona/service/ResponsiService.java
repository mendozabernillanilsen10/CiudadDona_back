package comciudad.dona.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import comciudad.dona.entity.Responsible;
@Service
public interface ResponsiService {
	public List<Responsible> findAll(Pageable page);
	public Responsible findById(UUID id);
	public Responsible save(Responsible articulo);
	public void delete(UUID id);
}
