package comciudad.dona.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import comciudad.dona.entity.Address;
import comciudad.dona.entity.Responsible;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.ResponsibleRepository;
import comciudad.dona.service.ResponsiService;
import comciudad.dona.validadors.AddressValid;
import comciudad.dona.validadors.ResponsibleValid;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ResponsiServiceImplement implements ResponsiService{
	@Autowired
	ResponsibleRepository repository;
	@Override
	public List<Responsible> findAll(Pageable page) {
		try {
			 List<Responsible> compani = repository.findAll(page).toList(); 
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
	public Responsible findById(UUID id) {
		try {
			Responsible existeRegistro= repository.findById(id)
					.orElseThrow(()->new NoDataFoundException("No Existe el Registro adrees")); 
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
	public Responsible save(Responsible dato) {
		try {
			ResponsibleValid.save(dato); 
			if(dato.getId()==null) {
				Responsible nuevoRegistro= repository.save(dato); 
				return nuevoRegistro;
			}
			Responsible existeRegistro= repository.findById(dato.getId())
					.orElseThrow(()->new NoDataFoundException("No Existe aseessel Registro"));
			existeRegistro.setName(dato.getName());
			existeRegistro.setCelular(dato.getCelular());
			existeRegistro.setCompany(dato.getCompany());
			existeRegistro.setSurName(dato.getSurName());
			existeRegistro.setWhatsapp(dato.getWhatsapp());
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
			Responsible existeRegistro= repository.findById(id)
					.orElseThrow(()->new NoDataFoundException("No Existe el Registro"));
			//existeRegistro.setActivo(false);
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
