package comciudad.dona.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import comciudad.dona.entity.Role;
@Service
public interface RolService {
	public List<Role> findAll(Pageable page);
	public List<Role> finByNombre(String nombre,Pageable page);
	public Role findById(UUID id);
	public Role save(Role articulo);
	public void delete(UUID id);
}
