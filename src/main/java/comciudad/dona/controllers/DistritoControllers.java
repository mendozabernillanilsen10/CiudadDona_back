package comciudad.dona.controllers;

import java.nio.file.Paths; 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import comciudad.dona.converters.DistritoConverters;
import comciudad.dona.dtos.CategoriaDTO;
import comciudad.dona.dtos.DistritoDto;
import comciudad.dona.dtos.UbDepartamentoDTO;
import comciudad.dona.entity.ubdistrito;
import comciudad.dona.entity.ubprovincia;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.service.DistritoService;
import comciudad.dona.service.fileService;
import comciudad.dona.utils.Rutas;
import comciudad.dona.utils.WrapperResponse;
@SuppressWarnings({ "rawtypes", "unchecked" })
@RestController
@RequestMapping("/v1/Distrito")
public class DistritoControllers {
	@Autowired
	DistritoService service;
	DistritoConverters converter = new DistritoConverters();
	@Autowired
	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;
	@Autowired
	private fileService servicefile;
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> update(
			@PathVariable("id") Long id,
			@RequestParam("nombre") String nombre,
			@RequestParam("foto") MultipartFile foto) {
		try {
			ubdistrito categoria = new ubdistrito();
			categoria.setNombre(nombre);
			categoria.setId(id);
			ubdistrito categoriaGuardada = service.save(categoria, foto);
			DistritoDto categoriaGuardadaDTO = converter.fromEntity(categoriaGuardada);
			if (id == null) {
				return new WrapperResponse(true, "success", categoriaGuardadaDTO).createResponse(HttpStatus.CREATED);
			} else {
				return new WrapperResponse(true, "success", categoriaGuardadaDTO).createResponse(HttpStatus.OK);
			}
		} catch (ValidateServiceException | NoDataFoundException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (GeneralServiceException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/byDistrito/{id}")
	public ResponseEntity<List<UbDepartamentoDTO>> getAlojamientosByCliente(@PathVariable long id) {
		ubprovincia p = new ubprovincia();
		p.setId(id);
		List<ubdistrito> cats = service.findByidProv(p);
	
		List<DistritoDto> dtos = new ArrayList<>();
		for (ubdistrito c : cats) {
			DistritoDto dto = new DistritoDto();

			dto.setId(c.getId());
			dto.setNombre(c.getNombre());

			dto.setFoto_url(MvcUriComponentsBuilder
					.fromMethodName(DistritoControllers.class, "serveFile", c.getFotoUrl()).build().toString());
			dtos.add(dto);
		}
		return new WrapperResponse(true, "success", dtos).createResponse(HttpStatus.OK);
	}
	
	@GetMapping(value = "download")
	public ResponseEntity<Resource> serveFile(@RequestParam(value = "filename") String filename) {
		String filePath = Paths.get(uploadPath, Rutas.IMG_DISTRITO, filename).toString();
		Resource file = (Resource) servicefile.loadAsResource(filePath);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

}
