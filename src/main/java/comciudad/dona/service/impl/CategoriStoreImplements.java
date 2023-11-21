package comciudad.dona.service.impl;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import comciudad.dona.entity.CategoriStore;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.CategoriStoreRepository;
import comciudad.dona.service.CategoriStoreService;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class CategoriStoreImplements implements CategoriStoreService{
	@Autowired
	CategoriStoreRepository repository;
	@Override
	public List<CategoriStore> findAll() {
		try {
			List<CategoriStore> compani = repository.findAll();
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
	public CategoriStore findById(UUID id) {
		try {
			CategoriStore existeRegistro = repository.findById(id)
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
	public CategoriStore save(CategoriStore objet) {
		try {
			if (objet.getId() == null) {
				CategoriStore nuevoRegistro = repository.save(objet);
				return nuevoRegistro;
			}
			CategoriStore existeRegistro = repository.findById(objet.getId())
					.orElseThrow(() -> new NoDataFoundException("No existe el registro"));
			existeRegistro.setCategory(objet.getCategory());
			existeRegistro.setStore(objet.getStore());
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
			CategoriStore existeRegistro = repository.findById(id)
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
