package comciudad.dona.service.impl;

import java.util.List;  
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comciudad.dona.entity.Oferta;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.OfertaRepository;
import comciudad.dona.service.OfertaService;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class OfertaServiceimple implements OfertaService {

	@Autowired
	private OfertaRepository repository;

	@Override
	public List<Oferta> findAll() {
		try {
			List<Oferta> compani = repository.findAll();
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
	public Oferta findById(UUID id) {
		try {
			Oferta existeRegistro = repository.findById(id)
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
	public Oferta save(Oferta objet) {
		try {
			//AddressValid.save(adres);
			if (objet.getId() == null) {
				objet.setActivo(true);
				Oferta nuevoRegistro = repository.save(objet);
				return nuevoRegistro;
			}
			Oferta existeRegistro = repository.findById(objet.getId())
					.orElseThrow(() -> new NoDataFoundException("No Existe aseessel Registro"));
			existeRegistro.setCantidad(objet.getCantidad());
			existeRegistro.setFechafin(objet.getFechaIncio());
			existeRegistro.setFechafin(objet.getFechafin());
			existeRegistro.setNombre(objet.getNombre());
			existeRegistro.setPrice(objet.getPrice());
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
			Oferta existeRegistro = repository.findById(id)
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
