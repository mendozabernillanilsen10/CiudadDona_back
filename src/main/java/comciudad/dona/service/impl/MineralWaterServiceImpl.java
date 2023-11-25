package comciudad.dona.service.impl;

import java.util.List;  
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comciudad.dona.entity.DescripcionAgua;
import comciudad.dona.entity.Product;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.MineralWaterRepository;
import comciudad.dona.service.MineralWaterService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MineralWaterServiceImpl implements MineralWaterService {
	@Autowired
	MineralWaterRepository repository;
	
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
	public DescripcionAgua save(DescripcionAgua objet) {
		try {
			//AddressValid.save(adres);
			if (objet.getId() == null) {
				DescripcionAgua nuevoRegistro = repository.save(objet);
				return nuevoRegistro;
			}
			DescripcionAgua existeRegistro = repository.findById(objet.getId())
					.orElseThrow(() -> new NoDataFoundException("No Existe aseessel Registro"));
			
			//existeRegistro.setShort_Description(objet.getShort_Description());
			
			
			
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public DescripcionAgua finByproduc(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
