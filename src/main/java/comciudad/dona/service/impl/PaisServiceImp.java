package comciudad.dona.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import comciudad.dona.entity.Pais;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.PaisRepository;
import comciudad.dona.service.PaisService;
import comciudad.dona.validadors.paisValidador;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class PaisServiceImp implements  PaisService {
	@Autowired
	PaisRepository repository;
	@Override
	public List<Pais> findAll(Pageable page) {
		try {
			 List<Pais> compani = repository.findAll(page).toList(); 
	  	      return compani;
		}catch(ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		}catch(Exception e) {
			log.error(e.getMessage());
			
			throw new GeneralServiceException(e.getMessage(), e);
		}	}

	@Override
	public List<Pais> finByNombre(String nombre, Pageable page) {
		try {
			List<Pais> articulo= repository.findBynombreContaining(nombre, page);
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
	public Pais findById(int id) {
		try {
			Pais existeRegistro= repository.findById(id)
					.orElseThrow(()->new NoDataFoundException("No Existe el Registro")); 
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
	public Pais save(Pais com) {
		try {
			paisValidador.save(com); 
			if(com.getId()==0) {
				Pais nuevoRegistro = repository.save(com); 
				return nuevoRegistro;
			}
			Pais existeRegistro = repository.findById(com.getId())
					.orElseThrow(()->new NoDataFoundException("No Existe el Registro"));
			existeRegistro.setNombre(com.getNombre());
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
	public void delete(int id) {

		try {
			Pais existeRegistro= repository.findById(id)
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
