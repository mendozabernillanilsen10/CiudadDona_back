package comciudad.dona.service.impl;

import java.util.List; 
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import comciudad.dona.entity.Product;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.productRepository;
import comciudad.dona.service.productService;
import comciudad.dona.validadors.ArticuloValidator;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class productServiceImplements implements productService {

	@Autowired
	private productRepository repository;

	@Override
	public List<Product> findAll() {
		try {
			List<Product> compani = repository.findAll();
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
	public Product findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product save(Product articulo) {
		
		try {
			ArticuloValidator.save(articulo);
			if(articulo.getId()==null) {
				articulo.setActivo(true);
				Product nuevoRegistro=repository.save(articulo);
				return nuevoRegistro;
			}
			Product existeRegistro=repository.findById(articulo.getId())
					.orElseThrow(()->new NoDataFoundException("No existe el registro"));
			existeRegistro.setActivo(true);
			existeRegistro.setShortDescription(articulo.getShortDescription());
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

}
