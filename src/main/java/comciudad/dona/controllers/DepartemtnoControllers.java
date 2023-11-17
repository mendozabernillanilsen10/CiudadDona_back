package comciudad.dona.controllers;
import java.util.List;        
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import comciudad.dona.converters.DepartementoConverters;
import comciudad.dona.dtos.UbDepartamentoDTO;
import comciudad.dona.entity.Pais;
import comciudad.dona.entity.ubdepartamento;
import comciudad.dona.service.UbDepartamentoService;
import comciudad.dona.utils.WrapperResponse;

@RestController
@RequestMapping("/v1/departamento")
public class DepartemtnoControllers {
	@Autowired
	private UbDepartamentoService service;
	private DepartementoConverters converter=new DepartementoConverters();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping
	public ResponseEntity<List<UbDepartamentoDTO>> findAll(
			@RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "limit", required = false, defaultValue = "100") int pageSize
			){
		Pageable page = PageRequest.of(pageNumber, pageSize);
		List<ubdepartamento> articulos = service.findAll(page);
		List<UbDepartamentoDTO> articulosDTO =converter.fromEntity(articulos);
		return new WrapperResponse(true, "success", articulosDTO).createResponse(HttpStatus.OK);		
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/bydepartamento/{departamentoId}")
    public ResponseEntity<List<UbDepartamentoDTO>> getAlojamientosByCliente(@PathVariable 
    		int departamentoId) {
        Pais p = new Pais();
        p.setId(departamentoId);
        List<ubdepartamento> lista = service.findBypaisId(p);
    	List<UbDepartamentoDTO> articulosDTO =converter.fromEntity(lista);
		return new WrapperResponse(true, "success", articulosDTO).createResponse(HttpStatus.OK);		
    }
	@GetMapping(value = "/{id}")
	public ResponseEntity<WrapperResponse<UbDepartamentoDTO>> 
	findById(@PathVariable("id") Long id) {
		ubdepartamento compani = service.findById(id);
		UbDepartamentoDTO compDTO=converter.fromEntity(compani);
		return new WrapperResponse<UbDepartamentoDTO>(true,"succes",compDTO).createResponse(HttpStatus.OK);
		
	}
	
}
