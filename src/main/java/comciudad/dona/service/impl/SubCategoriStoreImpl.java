package comciudad.dona.service.impl;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import comciudad.dona.entity.SubCategoriStore;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.SubCategoriStoreRepository;
import comciudad.dona.service.SubCategoriStoreService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SubCategoriStoreImpl implements SubCategoriStoreService {
	@Autowired
	SubCategoriStoreRepository repository;

	@Override
	public List<SubCategoriStore> findAll() {
		try {
			List<SubCategoriStore> compani = repository.findAll();
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
	public SubCategoriStore findById(UUID id) {
		try {
			SubCategoriStore existeRegistro = repository.findById(id)
					.orElseThrow(() -> new NoDataFoundException("No Existe el Registro"));
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
	public SubCategoriStore save(SubCategoriStore objet) {
		try {
			// ArticuloValidator.save(articulo);
			if (objet.getId() == null) {
				SubCategoriStore nuevoRegistro = repository.save(objet);
				return nuevoRegistro;
			}
			SubCategoriStore existeRegistro = repository.findById(objet.getId())
					.orElseThrow(() -> new NoDataFoundException("No existe el registro"));

			existeRegistro.setIdcategorystore(objet.getIdcategorystore());
			existeRegistro.setStore(objet.getStore());
			existeRegistro.setSubcategory(objet.getSubcategory());
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
			SubCategoriStore existeRegistro = repository.findById(id)
					.orElseThrow(() -> new NoDataFoundException("No existe el registro"));

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
