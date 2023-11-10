package comciudad.dona.service.impl;

import java.util.List; 
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import comciudad.dona.entity.Address;
import comciudad.dona.entity.Category;
import comciudad.dona.entity.Pais;
import comciudad.dona.entity.Person;
import comciudad.dona.entity.Role;
import comciudad.dona.entity.User;
import comciudad.dona.entity.ubdepartamento;
import comciudad.dona.entity.ubprovincia;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.personRepository;
import comciudad.dona.service.PersonService;
import comciudad.dona.validadors.AddressValid;
import comciudad.dona.validadors.PersonaValid;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class PersonServiceImp implements PersonService {
	@Autowired
	personRepository repository;
	
	
	@Override
    @Transactional(readOnly = true)
	public Person findByidUser(User p) {
		  return repository.findByidUser(p);
	}

	@Override
	public List<Person> findAll(Pageable page) {
		try {
			 List<Person> compani = repository.findAll(page).toList(); 
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
	public List<Person> finByNombre(String nombre, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person save(Person persona) {
	try {	
		PersonaValid.save(persona); 
		if(persona.getId()==null) {
	            persona.setState(true);
				Person nuevoRegistro = repository.save(persona); 
				return nuevoRegistro;
			}
		
		Person existeRegistro= repository.findById(persona.getId())
				.orElseThrow(()->new NoDataFoundException("No Existe el Registro persona"));
		existeRegistro.setDNI(persona.getDNI());
		existeRegistro.setDate_of_Birth(persona.getDate_of_Birth());
		existeRegistro.setIdUser(persona.getIdUser());
		existeRegistro.setSurName(persona.getSurName());
		existeRegistro.setName(persona.getName());
		repository.save(existeRegistro); 
		return existeRegistro;
	} catch (ValidateServiceException e) {
        throw e; // Puedes relanzar la excepción específica UserAlreadyExistsException
    } catch (NoDataFoundException e) {
        throw e;
    } catch (Exception e) {
        throw new GeneralServiceException(e.getMessage(), e);
    }
	}
	
	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Person findById(UUID id) {
		try {
			Person existeRegistro= repository.findById(id)
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

	
	

}
