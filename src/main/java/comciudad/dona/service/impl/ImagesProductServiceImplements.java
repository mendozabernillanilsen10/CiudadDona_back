package comciudad.dona.service.impl;

import java.io.IOException; 
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import comciudad.dona.entity.DescripcionAgua;
import comciudad.dona.entity.ImagesProduct;

import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.ImagesProductRepository;
import comciudad.dona.service.ImagesProductService;
import comciudad.dona.service.fileService;
import comciudad.dona.utils.RandomStringGenerator;
import comciudad.dona.utils.Rutas;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImagesProductServiceImplements implements ImagesProductService {

	@Autowired
	private ImagesProductRepository repository;
	
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
	public List<ImagesProduct> findAll() {
		try {
			List<ImagesProduct> catego = repository.findAll();
			return catego;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());

			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	@Override
	public ImagesProduct findById(UUID id) {
		try {
			ImagesProduct existeRegistro = repository.findById(id)
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
	public ImagesProduct save(ImagesProduct articulo) {
	    try {
	    	if (articulo.getId() == null) {
				String encodedImage = articulo.getFoto_url().split(",")[1];
				byte[] decodedImage = Base64.decodeBase64(encodedImage);
				articulo.setFoto_url(saveImageToFileSystem(decodedImage));
				ImagesProduct nuevoRegistro = repository.save(articulo);
				return nuevoRegistro;
			}
	    	ImagesProduct existeRegistro = repository.findById(articulo.getId())
					.orElseThrow(() -> new NoDataFoundException("No existe el registro"));
			String previousPhotoUrl = existeRegistro.getFoto_url();

			if (previousPhotoUrl != null) {
				servicefile.deleteFoto(previousPhotoUrl, Rutas.IMG_PRODUCT);
				String encodedImage = articulo.getFoto_url().split(",")[1];
				byte[] decodedImage = Base64.decodeBase64(encodedImage);
				articulo.setFoto_url(saveImageToFileSystem(decodedImage));
				repository.save(existeRegistro);
			}
			String encodedImage = articulo.getFoto_url().split(",")[1];
			byte[] decodedImage = Base64.decodeBase64(encodedImage);
			articulo.setFoto_url(saveImageToFileSystem(decodedImage));
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
			ImagesProduct existeRegistro = repository.findById(id)
					.orElseThrow(() -> new NoDataFoundException("No Existe el Registro"));
			String previousPhotoUrl = existeRegistro.getFoto_url();

			if (previousPhotoUrl != null) {
				servicefile.deleteFoto(previousPhotoUrl,Rutas.IMG_PRODUCT);
			}
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

	@Override
	public List<ImagesProduct> listaDescripcionProducto(DescripcionAgua objet) {
		try {
			List<ImagesProduct> catego = repository.findBydescripcionAgua(objet);
			return catego;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());

			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

}
