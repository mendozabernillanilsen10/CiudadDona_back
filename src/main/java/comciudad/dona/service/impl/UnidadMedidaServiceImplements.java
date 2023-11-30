package comciudad.dona.service.impl;

import java.util.List;  
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import comciudad.dona.entity.UnidadMedida;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.UnidadMedidaRepository;
import comciudad.dona.service.UnidadMedidaService;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class UnidadMedidaServiceImplements implements UnidadMedidaService {

	@Autowired
	UnidadMedidaRepository repository;

	@Override
	public List<UnidadMedida> findAll() {
		try {
			List<UnidadMedida> compani = repository.findAll();
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
	public UnidadMedida findById(UUID id) {
		try {
			UnidadMedida existeRegistro = repository.findById(id)
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
	public UnidadMedida save(UnidadMedida objet) {
		try {
			//AddressValid.save(adres);
			if (objet.getId() == null) {
				UnidadMedida nuevoRegistro = repository.save(objet);
				return nuevoRegistro;
			}
			UnidadMedida existeRegistro = repository.findById(objet.getId())
					.orElseThrow(() -> new NoDataFoundException("No"));
			
			existeRegistro.setMedida(objet.getMedida());

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
			UnidadMedida existeRegistro = repository.findById(id)
					.orElseThrow(() -> new NoDataFoundException("No Existe el Registro"));
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
