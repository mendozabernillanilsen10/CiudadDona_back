package comciudad.dona.service.impl;

import java.util.List; 
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import comciudad.dona.entity.Phone;
import comciudad.dona.entity.User;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.PhoneRepository;
import comciudad.dona.service.PhoneService;
import comciudad.dona.validadors.PhoneValid;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class PhoneServiceImplements implements PhoneService {
	@Autowired
	PhoneRepository repository ; 
	@Override
	public List<Phone> findAll(Pageable page) {
		try {
			 List<Phone> compani = repository.findAll(page).toList(); 
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
	public Phone findById(UUID id) {
		try {
			Phone existeRegistro= repository.findById(id)
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
	public Phone save(Phone phone) {
		try {
			PhoneValid.save(phone); 
			if(phone.getId()==null) {
				
		/*
		   Phone validPhone = repository.findBycelular(phone.getCelular());
		   Phone validwhasap = repository.findBywhatsapp(phone.getWhatsapp());
		   
		   if(validPhone != null ) {
	            throw new ValidateServiceException("Numero de telefono ya  esta Registrado");
           }else if (validwhasap !=null) {
	            throw new ValidateServiceException("Numero whatsapp ya  esta Registrado");
          }else {
          }*/
				Phone nuevoRegistro= repository.save(phone); 
				return nuevoRegistro;
		}
			Phone existeRegistro= repository.findById(phone.getId())
					.orElseThrow(()->new NoDataFoundException("No Existe el Registro phpne"));
			existeRegistro.setCelular(phone.getCelular());
			existeRegistro.setWhatsapp(phone.getWhatsapp());
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
	public Phone finByIdUser(User idUser) {
		try {
			Phone articulo= repository.findByidUser(idUser);
		
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
	public void delete(UUID id) {
		try {
			Phone existeRegistro= repository.findById(id)
					.orElseThrow(()->new NoDataFoundException("No Existe el Registro"));
			
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
