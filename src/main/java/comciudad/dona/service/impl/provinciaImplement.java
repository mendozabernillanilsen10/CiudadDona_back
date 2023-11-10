package comciudad.dona.service.impl;

import java.util.List;

import comciudad.dona.entity.ubdepartamento;
import comciudad.dona.entity.ubprovincia;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.provinciaRepository;
import comciudad.dona.service.provinciaService;
import comciudad.dona.validadors.provinciavalid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class provinciaImplement implements provinciaService{
	@Autowired
	provinciaRepository repository;
	
	@Override
	public List<ubprovincia> findAll(Pageable page) {
		try {
			 List<ubprovincia> compani = repository.findAll(page).toList(); 
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
	public List<ubprovincia> finByNombre(String nombre, Pageable page) {
		try {
			List<ubprovincia> articulo= repository.findBynombreContaining(nombre, page);
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
	public ubprovincia findById(Long id) {
		try {
			ubprovincia existeRegistro= repository.findById(id)
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
    @Transactional(readOnly = true)
	public List<ubprovincia> findByidDepa(ubdepartamento p) {
	    return repository.findByidDepa(p);
	}

	@Override
	public ubprovincia save(ubprovincia com) {
		try {
			provinciavalid.save(com); 
			if(com.getId()==0) {
				ubprovincia nuevoRegistro = repository.save(com); 	
				return nuevoRegistro;
			}
			ubprovincia existeRegistro = repository.findById(com.getId())
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
			ubprovincia existeRegistro= repository.findById(id)
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
