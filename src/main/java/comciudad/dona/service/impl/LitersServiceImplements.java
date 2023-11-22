package comciudad.dona.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import comciudad.dona.entity.liters;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.LitersRepository;
import comciudad.dona.service.LitersService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LitersServiceImplements implements LitersService {
	@Autowired
	LitersRepository repository;
	@Override
	public List<liters> findAll() {
		try {
			List<liters> compani = repository.findAll();
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
	public liters findById(UUID id) {
		try {
			liters existeRegistro = repository.findById(id)
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
	public liters save(liters objet) {
		try {
			// AddressValid.save(adres);
			if (objet.getId() == null) {
				liters nuevoRegistro = repository.save(objet);
				return nuevoRegistro;
			}
			liters existeRegistro = repository.findById(objet.getId())
					.orElseThrow(() -> new NoDataFoundException("No Existe aseessel Registro"));
			existeRegistro.setCantidad(objet.getCantidad());
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
			liters existeRegistro = repository.findById(id)
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

}
