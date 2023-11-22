package comciudad.dona.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comciudad.dona.entity.Category;
import comciudad.dona.entity.ContainerType;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.ContainerTypeRepository;
import comciudad.dona.service.ContainerTypeService;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ContainerTypeServiceImplements  implements ContainerTypeService{
	@Autowired
	ContainerTypeRepository repository;
	
	@Override
	public List<ContainerType> findAll() {
		try {
			List<ContainerType> compani = repository.findAll();
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
	public ContainerType findById(UUID id) {
		try {
			ContainerType existeRegistro = repository.findById(id)
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
	public ContainerType save(ContainerType objet) {
		try {
			//AddressValid.save(adres);
			if (objet.getId() == null) {
				ContainerType nuevoRegistro = repository.save(objet);
				return nuevoRegistro;
			}
			ContainerType existeRegistro = repository.findById(objet.getId())
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
			ContainerType existeRegistro = repository.findById(id)
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
	public List<ContainerType> finByIdUser(Category categori) {
		try {
			List<ContainerType> articulo = repository.findBycategory(categori);
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
