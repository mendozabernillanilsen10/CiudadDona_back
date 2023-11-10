package comciudad.dona.service.impl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import comciudad.dona.entity.ubdistrito;
import comciudad.dona.entity.ubprovincia;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.DistritoRepository;
import comciudad.dona.service.DistritoService;
import comciudad.dona.validadors.DistritoValid;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class DistritoServiceImplements implements DistritoService{
	@Autowired
	DistritoRepository repository;
	@Override
	public List<ubdistrito> findAll(Pageable page) {
		try {
			 List<ubdistrito> compani = repository.findAll(page).toList(); 
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
	public List<ubdistrito> finByNombre(String nombre, Pageable page) {
		try {
			List<ubdistrito> articulo= repository.findBynombreContaining(nombre, page);
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
	public ubdistrito findById(Long id) {
		try {
			ubdistrito existeRegistro= repository.findById(id)
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
	public ubdistrito save(ubdistrito com) {
		try {
			DistritoValid.save(com); 
			if(com.getId()==0) {
				ubdistrito nuevoRegistro = repository.save(com); 	
				return nuevoRegistro;
			}
			ubdistrito existeRegistro = repository.findById(com.getId())
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
	public void delete(Long id) {
		try {
			ubdistrito existeRegistro= repository.findById(id)
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

	@Override
    @Transactional(readOnly = true)
	public List<ubdistrito> findByidProv(ubprovincia p) {
	    return repository.findByidProv(p);

	}


}
