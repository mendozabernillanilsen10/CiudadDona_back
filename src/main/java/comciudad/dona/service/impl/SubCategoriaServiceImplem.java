package comciudad.dona.service.impl;
import java.util.List;  
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import comciudad.dona.entity.Category;
import comciudad.dona.entity.Subcategory;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.service.SubCategoriaService;
import comciudad.dona.validadors.SubCategoriavalidad;
import lombok.extern.slf4j.Slf4j;
import comciudad.dona.repository.SubCategoriaRepository;
@Service
@Slf4j
public class SubCategoriaServiceImplem  implements SubCategoriaService{
	@Autowired
	SubCategoriaRepository repository;

	@Override
	public List<Subcategory> findAll(Pageable page) {
		try {
			 List<Subcategory> compani = repository.findAll(page).toList(); 
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
	public Subcategory findById(UUID id) {
		try {
			Subcategory existeRegistro= repository.findById(id)
					.orElseThrow(()->new NoDataFoundException("No Existe el Registro ")); 
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
	public Subcategory save(Subcategory adres) {
		try {
			SubCategoriavalidad.save(adres); 
			if(adres.getId()==null) {
				adres.setActivo(true);
				Subcategory existe= repository.findByname(adres.getName());
				if( existe !=null) {
	                throw new ValidateServiceException("Categoria Existente  " + existe.getName() );
				}else {
				Subcategory nuevoRegistro= repository.save(adres); 
				return nuevoRegistro;
				}
			}
			Subcategory existeRegistro= repository.findById(adres.getId())
					.orElseThrow(()->new NoDataFoundException("No Existe aseessel Registro"));
			existeRegistro.setName(adres.getName());
		   existeRegistro.setCategory(adres.getCategory());
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
			Subcategory existeRegistro= repository.findById(id)
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
	@Override
	public Subcategory finByCategory(Category categoria) {

		try {
			Subcategory articulo= repository.findBycategory(categoria);
		
			return articulo;
		}catch(ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		}catch(Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceException(e.getMessage(), e);
		}
		
		
	}

}
