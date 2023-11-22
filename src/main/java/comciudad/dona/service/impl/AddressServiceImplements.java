package comciudad.dona.service.impl;

import java.util.List; 
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import comciudad.dona.entity.Address;
import comciudad.dona.entity.User;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.AddressRepository;
import comciudad.dona.service.AddressService;
import comciudad.dona.validadors.AddressValid;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressServiceImplements implements AddressService {

	@Autowired
	AddressRepository repository;

	@Override
	public Address finByIdUser(User idUser) {
		try {
			Address articulo = repository.findByidUser(idUser);

			return articulo;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Address> findAll(Pageable page) {

		try {
			List<Address> compani = repository.findAll(page).toList();
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
	public Address findById(UUID id) {
		try {
			Address existeRegistro = repository.findById(id)
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
	public Address save(Address adres) {
		try {
			AddressValid.save(adres);
			if (adres.getId() == null) {
				Address nuevoRegistro = repository.save(adres);
				return nuevoRegistro;
			}
			Address existeRegistro = repository.findById(adres.getId())
					.orElseThrow(() -> new NoDataFoundException("No Existe aseessel Registro"));
			existeRegistro.setReference(adres.getReference());
			existeRegistro.setStreet(adres.getStreet());
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
			Address existeRegistro = repository.findById(id)
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
