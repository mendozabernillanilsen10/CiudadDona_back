package comciudad.dona.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import comciudad.dona.entity.Category;
import comciudad.dona.entity.Subcategory;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.service.SubCategoriaService;
import comciudad.dona.service.fileService;
import comciudad.dona.utils.RandomStringGenerator;
import comciudad.dona.utils.Rutas;
import lombok.extern.slf4j.Slf4j;
import comciudad.dona.repository.SubCategoriaRepository;

@Service
@Slf4j
public class SubCategoriaServiceImplem implements SubCategoriaService {
	@Autowired
	SubCategoriaRepository repository;

	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;
	@Autowired
	private fileService servicefile;
	RandomStringGenerator x = new RandomStringGenerator();
	String otp = x.generate(6);

	public void deleteFoto(String fotoUrl) {
		if (fotoUrl != null) {

			Path filePath = Paths.get(uploadPath, Rutas.IMG_SUB_CATEGORIA, fotoUrl);
			try {
				Files.deleteIfExists(filePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Subcategory> finByCategory(Category categoria) {

		try {
			List<Subcategory> articulo = repository.findByidcategory(categoria);
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
	public List<Subcategory> findAll() {
		try {
			List<Subcategory> compani = repository.findAll();
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
	public Subcategory findById(UUID id) {
		try {
			Subcategory existeRegistro = repository.findById(id)
					.orElseThrow(() -> new NoDataFoundException("No Existe el Registro "));
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
	public Subcategory save(Subcategory com, MultipartFile file) {
		try {
			if (file.isEmpty()) {
				throw new Exception("ERROR: no se pudo crear la carpeta ");
			}
			Subcategory existingRecord = new Subcategory();
			Subcategory newRecord = new Subcategory();
			if (file != null && !file.isEmpty()) {

				if (com.getId() != null) {
					existingRecord = repository.findById(com.getId())
							.orElseThrow(() -> new NoDataFoundException("No Existe el Registro"));
					String previousPhotoUrl = existingRecord.getFoto_url();

					if (previousPhotoUrl != null) {
						deleteFoto(previousPhotoUrl);
						String categoryFolder = Rutas.IMG_SUB_CATEGORIA;
						Path folderPath = Paths.get(uploadPath, categoryFolder);
						Path filePath = folderPath.resolve(previousPhotoUrl);
						if (!Files.exists(folderPath)) {
							servicefile.init();
						}
						try (InputStream inputStream = file.getInputStream()) {
							Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
						}
						existingRecord.setId(com.getId());
						existingRecord.setFoto_url(previousPhotoUrl);
						existingRecord.setName(com.getName());
						existingRecord.setIdcategory(com.getIdcategory());

						newRecord = repository.save(existingRecord);
					} else {
						existingRecord.setId(com.getId());
						String categoryFolder = Rutas.IMG_SUB_CATEGORIA;
						String fileName = x.generate(8) + ".png";

						Path folderPath = Paths.get(uploadPath, categoryFolder);
						Path filePath = folderPath.resolve(fileName);
						if (!Files.exists(folderPath)) {
							servicefile.init();
						}
						try (InputStream inputStream = file.getInputStream()) {
							Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
						}
						existingRecord.setIdcategory(com.getIdcategory());

						existingRecord.setFoto_url(fileName);
						existingRecord.setName(com.getName());
						newRecord = repository.save(existingRecord);
					}
				} else {
					String categoryFolder = Rutas.IMG_SUB_CATEGORIA;
					String fileName = x.generate(8) + ".png";
					Path folderPath = Paths.get(uploadPath, categoryFolder);
					Path filePath = folderPath.resolve(fileName);
					if (!Files.exists(folderPath)) {
						servicefile.init();
					}
					try (InputStream inputStream = file.getInputStream()) {
						Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
					}
					existingRecord.setFoto_url(fileName);
					existingRecord.setIdcategory(com.getIdcategory());

					existingRecord.setName(com.getName());
					newRecord = repository.save(existingRecord);
				}
			}
			return newRecord;
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
			Subcategory existeRegistro = repository.findById(id)
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
