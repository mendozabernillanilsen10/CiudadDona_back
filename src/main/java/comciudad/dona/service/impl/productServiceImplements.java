package comciudad.dona.service.impl;
import org.apache.commons.codec.binary.Base64;  
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import comciudad.dona.entity.Product;
import comciudad.dona.entity.Store;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.productRepository;
import comciudad.dona.service.fileService;
import comciudad.dona.service.productService;
import comciudad.dona.utils.RandomStringGenerator;
import comciudad.dona.utils.Rutas;
import comciudad.dona.validadors.ArticuloValidator;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class productServiceImplements implements productService {

	@Autowired
	private productRepository repository;
	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;
	@Autowired
	private fileService servicefile;
	RandomStringGenerator x = new RandomStringGenerator();
	private String saveImageToFileSystem(byte[] imageBytes) throws IOException {
		String categoryFolder = Rutas.IMG_PRODUCT;
		String fileName = x.generate(20) + ".png";
		Path folderPath = Paths.get(uploadPath, categoryFolder);
		Path filePath = folderPath.resolve(fileName);
		Files.write(filePath, imageBytes);
		return fileName;
	}
	@Override
	public Product save(Product articulo) {
		try {
			ArticuloValidator.save(articulo);
			if (articulo.getId() == null) {
				String encodedImage = articulo.getFotoUrlPrincipal().split(",")[1];
				byte[] decodedImage = Base64.decodeBase64(encodedImage);
				articulo.setFotoUrlPrincipal(saveImageToFileSystem(decodedImage));
				articulo.setActivo(true);
				articulo.setCualidad(articulo.getCualidad());
				articulo.setShortDescription(articulo.getShortDescription());
				Product nuevoRegistro = repository.save(articulo);
				return nuevoRegistro;
			}
			Product existeRegistro = repository.findById(articulo.getId())
					.orElseThrow(() -> new NoDataFoundException("No existe el registro"));
			String previousPhotoUrl = existeRegistro.getFotoUrlPrincipal();

			if (previousPhotoUrl != null) {
				servicefile.deleteFoto(previousPhotoUrl, Rutas.IMG_PRODUCT);
				String encodedImage = articulo.getFotoUrlPrincipal().split(",")[1];
				byte[] decodedImage = Base64.decodeBase64(encodedImage);
				articulo.setFotoUrlPrincipal(saveImageToFileSystem(decodedImage));
				existeRegistro.setActivo(true);
				existeRegistro.setCualidad(articulo.getCualidad());
				existeRegistro.setShortDescription(articulo.getShortDescription());
				repository.save(existeRegistro);
			}
			String encodedImage = articulo.getFotoUrlPrincipal().split(",")[1];
			byte[] decodedImage = Base64.decodeBase64(encodedImage);
			articulo.setFotoUrlPrincipal(saveImageToFileSystem(decodedImage));
			existeRegistro.setActivo(true);
			existeRegistro.setCualidad(articulo.getCualidad());
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
		try {
			Product existeRegistro= repository.findById(id)
					.orElseThrow(()->new NoDataFoundException("No Existe el Registro")); 
			return existeRegistro;
		}catch(ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		}catch(Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void delete(UUID id) {

	}
	@Override
	public List<Product> listaProductosTienda(Store store) {
		try {
			List<Product> articulo = repository.findBystore(store);
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
