package comciudad.dona.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import comciudad.dona.converters.paisConverters;
import comciudad.dona.dtos.CompanyDTO;
import comciudad.dona.dtos.paisDTO;
import comciudad.dona.entity.Pais;
import comciudad.dona.service.PaisService;
import comciudad.dona.utils.WrapperResponse;

@RestController
@RequestMapping("/v1/pais")
public class PaisControllers {

	@Autowired
	private PaisService service;
	private paisConverters converter = new paisConverters();

	@GetMapping
	public ResponseEntity<List<paisDTO>> findAll(
			@RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		List<Pais> articulos = service.findAll(page);
		List<paisDTO> articulosDTO = converter.fromEntity(articulos);
		return new WrapperResponse(true, "success", articulosDTO).createResponse(HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<CompanyDTO> create(@RequestBody paisDTO paisDTO) {
		Pais compani = service.save(converter.fromDTO(paisDTO));
		paisDTO compDTO = converter.fromEntity(compani);
		return new WrapperResponse(true, "success", compDTO).createResponse(HttpStatus.CREATED);
	}

}
