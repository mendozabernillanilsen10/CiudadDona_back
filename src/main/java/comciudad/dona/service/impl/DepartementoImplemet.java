package comciudad.dona.service.impl;

import java.util.List;

import comciudad.dona.entity.Pais;
import comciudad.dona.entity.ubdepartamento;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.UbDepartamentoRepository;
import comciudad.dona.service.UbDepartamentoService;

import comciudad.dona.validadors.departamentoValidado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DepartementoImplemet implements UbDepartamentoService{
	@Autowired
	UbDepartamentoRepository repository;
	@Override
	public List<ubdepartamento> findAll(Pageable page) {
		try {
			 List<ubdepartamento> compani = repository.findAll(page).toList(); 
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
	public List<ubdepartamento> finByNombre(String nombre, Pageable page) {
		try {
			List<ubdepartamento> articulo= repository.findBynombreContaining(nombre, page);
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
    @Transactional(readOnly = true)
    public List<ubdepartamento> findBypaisId(Pais cliente) {
        return repository.findBypaisId(cliente);
    }
    
	
	
	
	@Override
	public ubdepartamento findById(Long id) {
		try {
			ubdepartamento existeRegistro= repository.findById(id)
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
	public ubdepartamento save(ubdepartamento com) {
		try {
			departamentoValidado.save(com); 
			if(com.getId()==0) {
				ubdepartamento nuevoRegistro = repository.save(com); 
				return nuevoRegistro;
			}
			ubdepartamento existeRegistro = repository.findById(com.getId())
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
			ubdepartamento existeRegistro= repository.findById(id)
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
