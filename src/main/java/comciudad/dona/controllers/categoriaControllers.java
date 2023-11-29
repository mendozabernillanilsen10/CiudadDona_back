package comciudad.dona.controllers;

import java.nio.file.Paths;  
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import comciudad.dona.converters.categoriaConverters;
import comciudad.dona.dtos.CategoriaDTO;
import comciudad.dona.entity.Category;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.service.StoreService;
import comciudad.dona.service.categoriaService;
import comciudad.dona.service.fileService;
import comciudad.dona.utils.Rutas;
import comciudad.dona.utils.WrapperResponse;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings({ "rawtypes", "unchecked" })
@Slf4j
@RestController
@RequestMapping("/v1/categorias")
public class categoriaControllers {
	@Autowired
	private categoriaService service;

	@Autowired
	private StoreService storeService;
	@Autowired
	private fileService servicefile;

	private categoriaConverters converter = new categoriaConverters();
	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;

	
	@GetMapping("/por-distrito/{idDistrito}")
	public ResponseEntity<List<CategoriaDTO>> sssfindAll(@PathVariable Long idDistrito) {
		List<Category> cats = storeService.obtenerCategoriasPorDistrito(idDistrito);
		List<CategoriaDTO> dtos = new ArrayList<>();
		for (Category c : cats) {
			CategoriaDTO dto = new CategoriaDTO();
			dto.setId(c.getId());
			dto.setNombre(c.getName());
			dto.setFoto_url(MvcUriComponentsBuilder
					.fromMethodName(categoriaControllers.class, "serveFile", c.getFoto_url()).build().toString());
			dtos.add(dto);
		}
		return new WrapperResponse(true, "success", dtos).createResponse(HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll(
			@RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "limit", required = false, defaultValue = "10") int pageSize) {
		//Pageable page = PageRequest.of(pageNumber, pageSize);
		List<Category> cats = service.findAll();
		List<CategoriaDTO> dtos = new ArrayList<>();
		for (Category c : cats) {
			CategoriaDTO dto = new CategoriaDTO();
			dto.setId(c.getId());
			dto.setNombre(c.getName());
			dto.setFoto_url(MvcUriComponentsBuilder
					.fromMethodName(categoriaControllers.class, "serveFile", c.getFoto_url()).build().toString());
			dtos.add(dto);
		}
		return new WrapperResponse(true, "success", dtos).createResponse(HttpStatus.OK);
	}

	@GetMapping(value = "download")
	public ResponseEntity<Resource> serveFile(@RequestParam(value = "filename") String filename) {
		String filePath = Paths.get(uploadPath, Rutas.IMG_CATEGORIA, filename).toString();
		Resource file = (Resource) servicefile.loadAsResource(filePath);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<WrapperResponse<CategoriaDTO>> findById(@PathVariable("id") UUID id) {
		Category compani = service.findById(id);
		CategoriaDTO compDTO = converter.fromEntity(compani);
		return new WrapperResponse<CategoriaDTO>(true, "succes", compDTO).createResponse(HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<CategoriaDTO> create(
			@RequestParam("nombre") String nombre,
			@RequestParam("foto") MultipartFile foto) {
		try {
			Category categoria = new Category();
			categoria.setName(nombre);
			Category categoriaGuardada = service.save(categoria, foto);
			CategoriaDTO categoriaGuardadaDTO = converter.fromEntity(categoriaGuardada);
			return new WrapperResponse(true, "success", categoriaGuardadaDTO).createResponse(HttpStatus.OK);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Maneja el error de validación
		} catch (GeneralServiceException e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Maneja errores generales del servicio
		}

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable("id") UUID id, @RequestParam("nombre") String nombre,
			@RequestParam("foto") MultipartFile foto) {
		try {
			Category categoria = new Category();
			// Actualiza los campos
			categoria.setName(nombre);
			categoria.setId(id);
			Category categoriaGuardada = service.save(categoria, foto);
			CategoriaDTO categoriaGuardadaDTO = converter.fromEntity(categoriaGuardada);
			if (id == null) {
				return new WrapperResponse(true, "success", categoriaGuardadaDTO).createResponse(HttpStatus.CREATED);
			} else {
				return new WrapperResponse(true, "success", categoriaGuardadaDTO).createResponse(HttpStatus.OK);
			}
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (GeneralServiceException e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") UUID id) {
		service.delete(id);
		return new WrapperResponse(true, "success", null).createResponse(HttpStatus.OK);
	}

}
