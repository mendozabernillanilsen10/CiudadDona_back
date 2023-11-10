package comciudad.dona.controllers;

import java.util.List; 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import comciudad.dona.converters.RolCoverters;
import comciudad.dona.dtos.CompanyDTO;
import comciudad.dona.dtos.RolDTO;
import comciudad.dona.entity.Company;
import comciudad.dona.entity.Role;
import comciudad.dona.service.RolService;
import comciudad.dona.utils.WrapperResponse;
@RestController
@RequestMapping("/v1/Role")
public class RoleControllers {
	@Autowired
	RolService service;
	
	RolCoverters converter = new RolCoverters ();
	
	
	@GetMapping
	public ResponseEntity<List<RolDTO>> findAll(
			@RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize
			){
		Pageable page = PageRequest.of(pageNumber, pageSize);
		List<Role> articulos = service.findAll(page);
		
		List<RolDTO> articulosDTO =converter.fromEntity(articulos);
		
		
		return new WrapperResponse(true, "success", articulosDTO).createResponse(HttpStatus.OK);		
	}
	
	@PostMapping()
	public ResponseEntity<RolDTO> create(@RequestBody RolDTO articuloDTO) {		
		Role compani = service.save(converter.fromDTO(articuloDTO));
		RolDTO compDTO=converter.fromEntity(compani);
		return new WrapperResponse(true, "success", compDTO).createResponse(HttpStatus.CREATED);
	}
	
	
	
	
}
