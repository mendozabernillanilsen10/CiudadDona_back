package comciudad.dona.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import comciudad.dona.entity.Category;
import comciudad.dona.entity.ubdistrito;
import comciudad.dona.entity.ubprovincia;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.DistritoRepository;
import comciudad.dona.service.DistritoService;
import comciudad.dona.service.fileService;
import comciudad.dona.utils.RandomStringGenerator;
import comciudad.dona.validadors.DistritoValid;
import comciudad.dona.validadors.categoriaValidador;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DistritoServiceImplements implements DistritoService {
	@Autowired
	DistritoRepository repository;
	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;
	RandomStringGenerator x = new RandomStringGenerator();
	@Autowired
	private fileService servicefile;
	@Override
	public List<ubdistrito> findAll(Pageable page) {
		try {
			List<ubdistrito> compani = repository.findAll(page).toList();
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
	public List<ubdistrito> finByNombre(String nombre, Pageable page) {
		try {
			List<ubdistrito> articulo = repository.findBynombreContaining(nombre, page);
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
	public ubdistrito findById(Long id) {
		try {
			ubdistrito existeRegistro = repository.findById(id)
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

	public void deleteFoto(String fotoUrl) {
		if (fotoUrl != null) {

			Path filePath = Paths.get(uploadPath, "Img_distrito", fotoUrl);
			try {
				Files.deleteIfExists(filePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public ubdistrito save(ubdistrito objet, MultipartFile file) {
		try {
			DistritoValid.save(objet);
			ubdistrito existingRecord = new ubdistrito();
			ubdistrito newRecord = new ubdistrito();
			if (file != null && !file.isEmpty()) {
				if (objet.getId() != null) {
					ubdistrito existeRegistro = repository.findById(objet.getId())
							.orElseThrow(() -> new NoDataFoundException("No Existe el Registro"));
					String previousPhotoUrl = existingRecord.getFotoUrl();

					if (previousPhotoUrl != null) {
						deleteFoto(previousPhotoUrl);
						String categoryFolder = "Img_distrito";
						Path folderPath = Paths.get(uploadPath, categoryFolder);
						Path filePath = folderPath.resolve(previousPhotoUrl);
						if (!Files.exists(folderPath)) {
							servicefile.init();
						}
						try (InputStream inputStream = file.getInputStream()) {
							Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
						}
						existeRegistro.setNombre(objet.getNombre());
						existingRecord.setFotoUrl(previousPhotoUrl);
						existingRecord.setNombre(objet.getNombre());
						newRecord = repository.save(existingRecord);
					}else {
						String categoryFolder = "Img_distrito";
						String fileName = x.generate(8) + ".png";
						Path folderPath = Paths.get(uploadPath, categoryFolder);
						Path filePath = folderPath.resolve(fileName);
						if (!Files.exists(folderPath)) {
							servicefile.init();
						}
						try (InputStream inputStream = file.getInputStream()) {
							Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
						}
						existingRecord.setFotoUrl(fileName);
						existingRecord.setNombre(objet.getNombre());
						newRecord = repository.save(existingRecord);
					}
				}else {
					String categoryFolder = "Img_distrito";
					String fileName = x.generate(8) + ".png";
					Path folderPath = Paths.get(uploadPath, categoryFolder);
					Path filePath   = folderPath.resolve(fileName);
					if (!Files.exists(folderPath)) {
						servicefile.init();
					}
					try (InputStream inputStream = file.getInputStream()) {
						Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
					}
					objet.setFotoUrl(fileName);
					newRecord = repository.save(objet);
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
	public ubdistrito save(ubdistrito com) {
		try {
			DistritoValid.save(com);
			if (com.getId() == 0) {
				ubdistrito nuevoRegistro = repository.save(com);
				return nuevoRegistro;
			}
			ubdistrito existeRegistro = repository.findById(com.getId())
					.orElseThrow(() -> new NoDataFoundException("No Existe el Registro"));
			existeRegistro.setNombre(com.getNombre());
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
	public void delete(Long id) {
		try {
			ubdistrito existeRegistro = repository.findById(id)
					.orElseThrow(() -> new NoDataFoundException("No Existe el Registro"));
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
	@Transactional(readOnly = true)
	public List<ubdistrito> findByidProv(ubprovincia p) {
		return repository.findByidProv(p);

	}

}
