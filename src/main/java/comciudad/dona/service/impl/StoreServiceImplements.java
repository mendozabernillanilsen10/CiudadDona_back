package comciudad.dona.service.impl;

import java.io.InputStream;
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
import comciudad.dona.entity.Company;
import comciudad.dona.entity.Store;
import comciudad.dona.entity.Subcategory;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.CategoriStoreRepository;
import comciudad.dona.repository.StoreRepository;
import comciudad.dona.repository.categoriaRepository;
import comciudad.dona.service.StoreService;
import comciudad.dona.service.fileService;
import comciudad.dona.utils.RandomStringGenerator;
import comciudad.dona.utils.Rutas;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StoreServiceImplements implements StoreService {
	@Autowired
	StoreRepository repository;
	@Autowired
	categoriaRepository categoryRepository;
	@Autowired
	CategoriStoreRepository repository1w;

	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;
	@Autowired
	private fileService servicefile;
	RandomStringGenerator x = new RandomStringGenerator();

	@Override
	public List<Subcategory> obtenerSubcategoriasPorTiendaDistritoYCategoria(Long idDistrito, UUID idCategoria) {
		return repository.obtenerSubcategoriasPorTiendaDistritoYCategoria(idDistrito, idCategoria);

	}

	@Override
	public List<Store> obtenerTiendasPorDistritoYCategoria(Long idDistrito, UUID idCategoria) {
		return repository.obtenerTiendasPorDistritoYCategoria(idDistrito, idCategoria);

	}

	@Override
	public List<Store> obtenerTiendasPorDistrito(Long pIdDistrito, UUID pIdCategoria, UUID pIdSubcategoria) {
		return repository.obtenerTiendasPorDistritoYCategoria(pIdDistrito, pIdCategoria, pIdSubcategoria);
	}
	@Override
	public List<Category> obtenerCategoriasPorDistrito(Long idDistrito) {

		return repository1w.findDistinctCategoriesByDistrito(idDistrito);
	}

	
	
	@Override
	public List<Store> lisByIdcompany(Company company) {
		try {
			List<Store> catego = repository.findBycompany(company);
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
	public List<Store> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Store findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Store save(Store com, MultipartFile file) {
		try {
			if (file.isEmpty()) {
				throw new Exception("ERROR: no se pudo crear la carpeta ");
			}
			Store existingRecord = new Store();
			Store newRecord = new Store();
			if (file != null && !file.isEmpty()) {
				if (com.getId() != null) {
					existingRecord = repository.findById(com.getId())
							.orElseThrow(() -> new NoDataFoundException("No Existe el Registro"));
					String previousPhotoUrl = existingRecord.getFoto_url();
					if (previousPhotoUrl != null) {
						servicefile.deleteFoto(previousPhotoUrl,Rutas.IMG_STORE);
						String categoryFolder = Rutas.IMG_STORE;
						Path folderPath = Paths.get(uploadPath, categoryFolder);
						Path filePath = folderPath.resolve(previousPhotoUrl);
						if (!Files.exists(folderPath)) {
							servicefile.init();
						}
						try (InputStream inputStream = file.getInputStream()) {
							Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
						}

						existingRecord.setIdDistrito(com.getIdDistrito());
						existingRecord.setName(com.getName());
						existingRecord.setId(com.getId());
						existingRecord.setFoto_url(previousPhotoUrl);
						existingRecord.setActivo(true);
						// existingRecord.setCategory(com.getCategory());
						existingRecord.setCompany(com.getCompany());
						// existingRecord.setSubcategory(com.getSubcategory());
						newRecord = repository.save(existingRecord);
					} else {
						existingRecord.setId(com.getId());
						String categoryFolder = Rutas.IMG_STORE;
						String fileName = x.generate(8) + ".png";
						Path folderPath = Paths.get(uploadPath, categoryFolder);
						Path filePath = folderPath.resolve(fileName);
						if (!Files.exists(folderPath)) {
							servicefile.init();
						}
						try (InputStream inputStream = file.getInputStream()) {
							Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
						}
						existingRecord.setIdDistrito(com.getIdDistrito());

						existingRecord.setFoto_url(fileName);
						existingRecord.setActivo(true);
						// existingRecord.setCategory(com.getCategory());
						existingRecord.setCompany(com.getCompany());
						// existingRecord.setSubcategory(com.getSubcategory());
						existingRecord.setName(com.getName());
						newRecord = repository.save(existingRecord);
					}
				} else {
					String categoryFolder = Rutas.IMG_STORE;
					String fileName = x.generate(8) + ".png";
					Path folderPath = Paths.get(uploadPath, categoryFolder);
					Path filePath = folderPath.resolve(fileName);
					if (!Files.exists(folderPath)) {
						servicefile.init();
					}
					try (InputStream inputStream = file.getInputStream()) {
						Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
					}

					existingRecord.setName(com.getName());
					existingRecord.setFoto_url(fileName);
					existingRecord.setActivo(true);
					// existingRecord.setCategory(com.getCategory());
					existingRecord.setCompany(com.getCompany());
					// existingRecord.setSubcategory(com.getSubcategory());
					existingRecord.setIdDistrito(com.getIdDistrito());

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
		// TODO Auto-generated method stub

	}

	@Override
	public Store listarCategorias(Category categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Store listarSubCategorias(Subcategory subcategoria) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
