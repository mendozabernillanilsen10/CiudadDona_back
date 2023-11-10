package comciudad.dona.service.impl;
import java.util.List; 
import java.util.UUID;

import comciudad.dona.entity.Role;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.RolRepository;
import comciudad.dona.service.RolService;
import comciudad.dona.validadors.RolesValid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class RolServiceImplement implements RolService {
	@Autowired
	RolRepository repository; 
	@Override
	public List<Role> findAll(Pageable page) {
		try {
			 List<Role> compani = repository.findAll(page).toList(); 
	  	      return compani;
		}catch(ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		}catch(Exception e) {
			log.error(e.getMessage());
			
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	
	
	
	
	
	
	
	@Override
	public List<Role> finByNombre(String nombre, Pageable page) {
		try {
			List<Role> articulo= repository.findByNameContaining(nombre, page);
		      return articulo;
		}catch(ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		}catch(Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	@Override
	public Role findById(UUID id) {
		try {
			Role existeRegistro= repository.findById(id)
					.orElseThrow(()->new NoDataFoundException(" NO existe el rol ")); 
			return existeRegistro;
		}catch(ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		}catch(Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	public Role save(Role com) {
		try {
			RolesValid.save(com); 
			if(com.getId()==null) {
				Role nuevoRegistro = repository.save(com); 	
				return nuevoRegistro;
			}
			
			Role existeRegistro= repository.findById( com.getId())
					.orElseThrow(()->new NoDataFoundException("No Existe el Registro"));	
		        existeRegistro.setName(com.getName());
			repository.save(existeRegistro); 
			return existeRegistro;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	@Override
	public void delete(UUID id) {
		try {
			Role existeRegistro= repository.findById(id)
					.orElseThrow(()->new NoDataFoundException("No Existe el Registro"));	
			//repository.save(existeRegistro);
		       repository.delete(existeRegistro);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
}
