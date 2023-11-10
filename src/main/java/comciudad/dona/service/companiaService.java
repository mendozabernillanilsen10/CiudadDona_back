package comciudad.dona.service;


import java.util.List;
import java.util.UUID;

import comciudad.dona.entity.Address;
import comciudad.dona.entity.Company;
import comciudad.dona.entity.User;

import org.springframework.data.domain.Pageable;


public interface companiaService {
	public List<Company> findAll(Pageable page);
	public List<Company> finByNombre(String nombre,Pageable page); 
	public Company findById(UUID id); 
	public Company save(Company articulo); 
	public void delete(UUID id); 
	public Company finByIdUser(User idUser); 
}

