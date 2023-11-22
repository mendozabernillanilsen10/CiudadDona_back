package comciudad.dona.service.impl;

import java.util.List; 
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import comciudad.dona.entity.Category;
import comciudad.dona.entity.Brand;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.BrandRepository;
import comciudad.dona.service.BrandService;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class BrandServiceImplement  implements BrandService{
	@Autowired
	BrandRepository repository;
	@Override
	public List<Brand> findAll() {
		try {
			List<Brand> compani = repository.findAll();
			return compani;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());

			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	@Override
	public Brand findById(UUID id) {
		try {
			Brand existeRegistro = repository.findById(id)
					.orElseThrow(() -> new NoDataFoundException("No Existe el Registro adrees"));
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
	public Brand save(Brand objet) {
		try {
			//AddressValid.save(adres);
			if (objet.getId() == null) {
				Brand nuevoRegistro = repository.save(objet);
				return nuevoRegistro;
			}
			Brand existeRegistro = repository.findById(objet.getId())
					.orElseThrow(() -> new NoDataFoundException("No Existe aseessel Registro"));
			existeRegistro.setName(objet.getName());
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
			Brand existeRegistro = repository.findById(id)
					.orElseThrow(() -> new NoDataFoundException("No Existe el Registro"));
			// existeRegistro.setActivo(false);
			// repository.save(existeRegistro);
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
	public List<Brand> finByIdUser(Category categori) {
		try {
			List<Brand> articulo = repository.findBycategory(categori);

			return articulo;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	
	
	
	
	
	
	
	
	

}
