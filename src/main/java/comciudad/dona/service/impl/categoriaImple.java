package comciudad.dona.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import comciudad.dona.entity.Category;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.categoriaRepository;
import comciudad.dona.service.categoriaService;
import comciudad.dona.service.fileService;
import comciudad.dona.utils.RandomStringGenerator;
import comciudad.dona.validadors.categoriaValidador;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class categoriaImple implements categoriaService {
	@Autowired
	categoriaRepository repository;

	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;
	@Autowired
	private fileService servicefile;
	RandomStringGenerator x = new RandomStringGenerator();
	String otp = x.generate(6);

	public void deleteFoto(String fotoUrl) {
		if (fotoUrl != null) {

			Path filePath = Paths.get(uploadPath, "categoria", fotoUrl);
			try {
				Files.deleteIfExists(filePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Category save(Category com, MultipartFile file) {
		try {
			if (file.isEmpty()) {
				throw new Exception("ERROR: no se pudo crear la carpeta ");
			}
			Category existingRecord = new Category();
			Category newRecord = new Category();
			if (file != null && !file.isEmpty()) {

				if (com.getId() != null) {
					existingRecord = repository.findById(com.getId())
							.orElseThrow(() -> new NoDataFoundException("No Existe el Registro"));
					String previousPhotoUrl = existingRecord.getFoto_url();

					if (previousPhotoUrl != null) {
						deleteFoto(previousPhotoUrl);
						String categoryFolder = "categorias";
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
						categoriaValidador.save(existingRecord);
						newRecord = repository.save(existingRecord);
					} else {
						existingRecord.setId(com.getId());
						String categoryFolder = "categorias";
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
						existingRecord.setActivo(true);
						existingRecord.setName(com.getName());
						newRecord = repository.save(existingRecord);
					}
				} else {
					String categoryFolder = "categorias";
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
					existingRecord.setActivo(true);
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
	public List<Category> findAll(Pageable page) {
		try {
			List<Category> catego = repository.findAll(page).toList();
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
	public List<Category> finByNombre(String nombre, Pageable page) {
		try {
			List<Category> articulo = repository.findByNameContaining(nombre, page);

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
	public Category findById(UUID id) {
		try {
			Category existeRegistro = repository.findById(id)
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
	public void delete(UUID id) {
		try {
			Category existeRegistro = repository.findById(id)
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