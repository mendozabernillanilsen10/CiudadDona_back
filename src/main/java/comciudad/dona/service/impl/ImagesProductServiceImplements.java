package comciudad.dona.service.impl;

import java.io.InputStream;  
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	public ImagesProduct save(ImagesProduct objet, List<MultipartFile> files) {
	    try {

	    	DescripcionAgua product = objet.getDescripcionAgua();
	        if (files.isEmpty()) {
	            throw new Exception("ERROR: no se pudo crear la carpeta ");
	        }

	        List<ImagesProduct> newRecords = new ArrayList<>();

	        for (MultipartFile file : files) {
	            ImagesProduct existingRecord = new ImagesProduct(); // Nueva instancia para cada archivo

	            if (objet.getId() != null) {
	                existingRecord = repository.findById(objet.getId())
	                        .orElseThrow(() -> new NoDataFoundException("No Existe el Registro"));

	                String previousPhotoUrl = existingRecord.getFoto_url();

	                if (previousPhotoUrl != null) {
	                    servicefile.deleteFoto(previousPhotoUrl);
	                }
	            }
	            String categoryFolder = Rutas.IMG_PRODUCT;
	            String fileName = x.generate(18) + ".png";
	            Path folderPath = Paths.get(uploadPath, categoryFolder);
	            Path filePath = folderPath.resolve(fileName);
	            if (!Files.exists(folderPath)) {
	                servicefile.init();
	            }
	            try (InputStream inputStream = file.getInputStream()) {
	                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
	            }
	            existingRecord.setId(null); // Para asegurarse de que sea una nueva entidad
	            existingRecord.setDescripcionAgua(product);
	            existingRecord.setFoto_url(fileName);
	            newRecords.add(repository.save(existingRecord));
	        }
	        // Puedes retornar la lista de nuevas entidades creadas si es necesario
	        return newRecords.isEmpty() ? null : newRecords.get(0);
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
				servicefile.deleteFoto(previousPhotoUrl);
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

}
