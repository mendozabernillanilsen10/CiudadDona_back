package comciudad.dona.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import comciudad.dona.converters.typeProductConvertes;
import comciudad.dona.dtos.typeProductDto;
import comciudad.dona.entity.typeProduct;
import comciudad.dona.service.typeProductService;
import comciudad.dona.utils.WrapperResponse;
import lombok.RequiredArgsConstructor;

@SuppressWarnings({ "rawtypes", "unchecked" })
@RestController
@RequestMapping("/v1/typeProduct")
@RequiredArgsConstructor
public class typeProductControllers {
	@Autowired
	private typeProductService service;
	typeProductConvertes converter= new typeProductConvertes();
	@GetMapping(value = "/listar")
	public ResponseEntity<List<typeProductDto>> findByCategory(
			@RequestParam(value = "nombre", required = false, defaultValue = "0") String nombre,
			@RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize) {
		//Pageable page = PageRequest.of(pageNumber, pageSize);
		List<typeProduct> ingresos = service.findAll();
		List<typeProductDto> ingresosDTO = converter.fromEntity(ingresos);
		return new WrapperResponse(true, "success", ingresosDTO).createResponse(HttpStatus.OK);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<WrapperResponse<typeProductDto>> 
	findById(@PathVariable("id") UUID id) {
		typeProduct ingreso = service.findById(id);
		if (ingreso == null) {
			return ResponseEntity.notFound().build();
		}
		typeProductDto ingresoDTO = converter.fromEntity(ingreso);
		return new WrapperResponse<typeProductDto>(true, "succes", ingresoDTO).createResponse(HttpStatus.OK);
	}
	@PostMapping("/agregar")
	public ResponseEntity<typeProductDto> create(
			@RequestBody typeProductDto ingresoDTO) {
		typeProduct createIngreso = service.save(converter.fromDTO(ingresoDTO));
		typeProductDto ingresoReturn=converter.fromEntity(createIngreso);
		return new WrapperResponse(true, "success", ingresoReturn).createResponse(HttpStatus.CREATED);
	}
	@PostMapping("/createLista")
	public ResponseEntity<WrapperResponse<List<typeProductDto>>> createlista(
			@RequestBody List<typeProductDto> ingresoDTO) {
	    List<typeProductDto> ingresoReturnList = new ArrayList<>();
	    for (typeProductDto categoria : ingresoDTO) {
	        typeProduct createIngreso = service.save(converter.fromDTO(categoria));
	        typeProductDto ingresoReturn = converter.fromEntity(createIngreso);
	        ingresoReturnList.add(ingresoReturn);
	    }
	    return new WrapperResponse<>(true, "success", ingresoReturnList).createResponse(HttpStatus.CREATED);
	}

	
}
