package comciudad.dona.service.impl;

import java.util.List;  
import java.util.UUID;

import comciudad.dona.entity.Company;
import comciudad.dona.entity.User;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.companyrespository;
import comciudad.dona.service.companiaService;
import comciudad.dona.validadors.CompanyValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class CompanyServiceImpl implements  companiaService{
	@Autowired
	private companyrespository repository;


	@Override
	public Company finByIdUser(User idUser) {
		try {
			Company articulo= repository.findByidUser(idUser);
		
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
	public List<Company> findAll(Pageable page) {
		try {
			 List<Company> compani = repository.findAll(page).toList(); 
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
	public List<Company> finByNombre(String nombre, Pageable page) {
		try {
			List<Company> articulo= repository.findByBusinessNameContaining(nombre, page);
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
	public Company findById(UUID id) {
		try {
			Company existeRegistro= repository.findById(id)
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
	public Company save(Company com) {
		try {
			CompanyValidador.save(com); 
			if(com.getId()==null) {
				com.setActivo(true);
				Company nuevoRegistro= repository.save(com); 
				return nuevoRegistro;
			}
			Company existeRegistro= repository.findById(com.getId())
					.orElseThrow(()->new NoDataFoundException("No Existe el Registro"));
			existeRegistro.setRuc(com.getRuc());
			existeRegistro.setBusinessName(com.getBusinessName());
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
			Company existeRegistro= repository.findById(id)
					.orElseThrow(()->new NoDataFoundException("No Existe el Registro"));
			existeRegistro.setActivo(false);
			repository.save(existeRegistro);
			
		//repository.delete(existeRegistro);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	
	
	
}
