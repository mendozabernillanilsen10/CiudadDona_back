package comciudad.dona.controllers;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import comciudad.dona.converters.LitersConverter;
import comciudad.dona.dtos.LitersDTo;
import comciudad.dona.entity.liters;
import comciudad.dona.service.LitersService;
import comciudad.dona.utils.WrapperResponse;

@SuppressWarnings({ "rawtypes", "unchecked" })
@RestController
@RequestMapping("/v1/litros")
public class LitersControllers {
	@Autowired
	private LitersService service;
	private LitersConverter converter = new LitersConverter();
	@GetMapping(value = "/listar")
	public ResponseEntity<List<LitersDTo>> findByCategory(
			@RequestParam(value = "nombre", required = false, defaultValue = "0") String nombre,
			@RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize) {
		// Pageable page = PageRequest.of(pageNumber, pageSize);
		List<liters> ingresos = service.findAll();
		List<LitersDTo> ingresosDTO = converter.fromEntity(ingresos);
		return new WrapperResponse(true, "success", ingresosDTO).createResponse(HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<WrapperResponse<LitersDTo>> findById(@PathVariable("id") UUID id) {
		liters ingreso = service.findById(id);
		if (ingreso == null) {
			return ResponseEntity.notFound().build();
		} 
		LitersDTo ingresoDTO = converter.fromEntity(ingreso);
		return new WrapperResponse<LitersDTo>(true, "succes", ingresoDTO).createResponse(HttpStatus.OK);
	}
	
	
	@PostMapping()
	public ResponseEntity<LitersDTo> create(@RequestBody LitersDTo ingresoDTO) {
		liters createIngreso = service.save(converter.fromDTO(ingresoDTO));
		LitersDTo ingresoReturn = converter.fromEntity(createIngreso);
		return new WrapperResponse(true, "success", ingresoReturn).createResponse(HttpStatus.CREATED);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") UUID id) {
		service.delete(id);
		return new WrapperResponse(true, "success", null).createResponse(HttpStatus.OK);
	}

}
