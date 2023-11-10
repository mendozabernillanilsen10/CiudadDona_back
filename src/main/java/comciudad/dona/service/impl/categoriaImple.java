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
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import comciudad.dona.entity.Category;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.categoriaRepository;
import comciudad.dona.service.categoriaService;
import comciudad.dona.validadors.categoriaValidador;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class categoriaImple implements categoriaService {
	@Autowired
	categoriaRepository repository;

	
	 @Value("${spring.servlet.multipart.location}")
	 private String uploadPath;
	
	
	 
	 @Override
	 public void init() {
	        try {
	            Files.createDirectories(Paths.get(uploadPath));
	        } catch (IOException e) {
	            throw new RuntimeException("¡No se pudo crear la carpeta de carga!");
	        }
	 }
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
	            // Construir la ruta completa a la carpeta específica
	            String categoryFolder = "categorias";
	            String fileName = com.getName() + ".png";
	            Path folderPath = Paths.get(uploadPath, categoryFolder);
	            Path filePath = folderPath.resolve(fileName);
	            // Verificar si la carpeta existe, si no, crearla
	            if (!Files.exists(folderPath)) {
	                init();
	            }
	            
	            
	            
	            // Eliminar la foto anterior si existe
	            if (com.getId() != null) {
	                Category existingRecord = repository.findById(com.getId())
	                    .orElseThrow(() -> new NoDataFoundException("No Existe el Registro"));
	                String previousPhotoUrl = existingRecord.getFoto_url();
	                if (previousPhotoUrl != null) {
	                    deleteFoto(previousPhotoUrl);
	                }
	            }
	            try (InputStream inputStream = file.getInputStream()) {
	                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
	            }

	            // Establecer la URL de la foto en la entidad
	           // com.setFoto_url(Paths.get(categoryFolder, fileName).toString());
	            com.setFoto_url(fileName);
	            categoriaValidador.save(com);

	            if (com.getId() == null) {
	                com.setActivo(true);
	                Category newRecord = repository.save(com);
	                return newRecord;
	            }

	            UUID idToSearch = com.getId();
	            Category existingRecord = repository.findById(idToSearch)
	                .orElseThrow(() -> new NoDataFoundException("No Existe el Registro"));
	            existingRecord.setName(com.getName());
	            repository.save(existingRecord);

	            return existingRecord;
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
			List<Category> catego =repository.findAll(page).toList();
			return catego;
		}catch(ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		}catch(Exception e) {
			log.error(e.getMessage());
			
			throw new GeneralServiceException(e.getMessage(), e);
		
		}
	}
	@Override
	public List<Category> finByNombre(String nombre, Pageable page) {
		try {
			List<Category> articulo= repository.findByNameContaining(nombre, page);
		
			return articulo;
		}catch(ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		}catch(Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	public Category findById(UUID id) {
		try {
			Category existeRegistro= repository.findById(id)
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
		try {
			Category existeRegistro= repository.findById(id)
					.orElseThrow(()->new NoDataFoundException("No Existe el Registro"));
			//existeRegistro.setActivo(false);
			//repository.save(existeRegistro);
			
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
	 public Path load(String filename) {
	        return Paths.get(uploadPath).resolve(filename);
	 }
	    

	@Override
	public Resource loadAsResource(String filename) {
		try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            
            
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read file: " + filename);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Could not read file: " + filename, e);
        }
	}

	


}
