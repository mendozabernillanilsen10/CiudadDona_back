package comciudad.dona.service.impl;

import java.util.List;  
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import comciudad.dona.entity.DescripcionAgua;
import comciudad.dona.entity.MedidasProducto;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.DescripcionAguaRepository;
import comciudad.dona.service.DescripcionAguaService;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class DescripcionAguaServiceImplements implements DescripcionAguaService {
	@Autowired
	DescripcionAguaRepository repository;
	@Override
	public List<DescripcionAgua> findAll() {

		try {
			List<DescripcionAgua> compani = repository.findAll();
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
	public DescripcionAgua findById(UUID id) {
		try {
			DescripcionAgua existeRegistro = repository.findById(id)
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
	public DescripcionAgua save(DescripcionAgua objet) {
		try {
			//AddressValid.save(adres);
			if (objet.getId() == null) {
				objet.setActivo(true);
				DescripcionAgua nuevoRegistro = repository.save(objet);
				return nuevoRegistro;
			}
			DescripcionAgua existeRegistro = repository.findById(objet.getId())
					.orElseThrow(() -> new NoDataFoundException("No Existe aseessel Registro"));
			existeRegistro.setStock(objet.getStock());
			existeRegistro.setDetalleEnbase(objet.getDetalleEnbase());
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
			DescripcionAgua existeRegistro = repository.findById(id)
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


	@Override
	public List<DescripcionAgua> listaDescripMedida(MedidasProducto des) {
		try {    

			List<DescripcionAgua> compani = repository.findByMedidasProducto(des);
			return compani;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());

			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

}
