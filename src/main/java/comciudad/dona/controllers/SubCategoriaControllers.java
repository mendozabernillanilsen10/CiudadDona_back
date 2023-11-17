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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import comciudad.dona.converters.subCategoriaConverters;
import comciudad.dona.dtos.CategoriaDTO;
import comciudad.dona.dtos.SubCategoryDTO;
import comciudad.dona.entity.Category;
import comciudad.dona.entity.Subcategory;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.service.SubCategoriaService;
import comciudad.dona.service.categoriaService;
import comciudad.dona.service.fileService;
import comciudad.dona.utils.Rutas;
import comciudad.dona.utils.WrapperResponse;
import lombok.extern.slf4j.Slf4j;
@SuppressWarnings({ "rawtypes", "unchecked" })
@Slf4j
@RestController
@RequestMapping("/v1/SubCategoria")
public class SubCategoriaControllers {
	@Autowired
	SubCategoriaService service;
	subCategoriaConverters converter = new subCategoriaConverters();
	@Autowired
	categoriaService subservice;
	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;
	@Autowired
	private fileService servicefile;
	
	@PostMapping
	public ResponseEntity<SubCategoryDTO> create(@RequestParam("nombre") String nombre,
			@RequestParam("foto") MultipartFile foto, @RequestParam("catId") UUID catId
	) {
		try {
			Subcategory subcategoria = new Subcategory();
			subcategoria.setName(nombre);
			Category cat = subservice.findById(catId);
			SubCategoryDTO categoriaGuardadaDTO = new SubCategoryDTO();
			subcategoria.setIdcategory(cat);
			Subcategory categoriaGuardada1 = service.save(subcategoria, foto);
			categoriaGuardadaDTO = converter.fromEntity(categoriaGuardada1);
			return new WrapperResponse(true, "success", categoriaGuardadaDTO).createResponse(HttpStatus.OK);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Maneja el error de validación
		} catch (GeneralServiceException e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Maneja errores generales del servicio
		}
	}
	
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<WrapperResponse<CategoriaDTO>> 
	findById(@PathVariable("id") UUID id) {
        List<Subcategory> cats = service.findAll();
		List<CategoriaDTO> dtos = new ArrayList<>();
		for (Subcategory c : cats) {
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
		String filePath = Paths.get(uploadPath, Rutas.IMG_SUB_CATEGORIA, filename).toString();
		Resource file = (Resource) servicefile.loadAsResource(filePath);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
