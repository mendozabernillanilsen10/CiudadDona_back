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
import comciudad.dona.converters.ContainerTypeConverter;
import comciudad.dona.dtos.BrandDTO;
import comciudad.dona.dtos.ContainerTypeDTO;
import comciudad.dona.entity.ContainerType;
import comciudad.dona.entity.typeProduct;
import comciudad.dona.service.ContainerTypeService;
import comciudad.dona.service.categoriaService;
import comciudad.dona.utils.WrapperResponse;
@SuppressWarnings({ "rawtypes", "unchecked" })
@RestController
@RequestMapping("/v1/TipoEnvase")
public class ContainerTypeControllers {
	@Autowired
	ContainerTypeService service;
	ContainerTypeConverter converter = new ContainerTypeConverter();
	@Autowired
	public categoriaService serviC;
	@GetMapping(value = "/listar")
	public ResponseEntity<List<BrandDTO>> findByCategory(
			@RequestParam(value = "nombre", required = false, defaultValue = "0") String nombre,
			@RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize) {
		//Pageable page = PageRequest.of(pageNumber, pageSize);
		List<ContainerType> ingresos = service.findAll();
		List<ContainerTypeDTO> ingresosDTO = converter.fromEntity(ingresos);
		return new WrapperResponse(true, "success", ingresosDTO).createResponse(HttpStatus.OK);
	}
	@GetMapping(value = "/listarPorCategoria/{idCategoria}")
	public ResponseEntity<List<BrandDTO>> findAll(
			@PathVariable("idCategoria") UUID idCategoria) {
		typeProduct typeProduct = new typeProduct();
		typeProduct.setId(idCategoria);
		List<ContainerType> ingresos = service.finByIdUser(typeProduct);
		List<ContainerTypeDTO> ingresosDTO = converter.fromEntity(ingresos);
		return new WrapperResponse(true, "success", ingresosDTO).createResponse(HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<WrapperResponse<ContainerTypeDTO>> findById(@PathVariable("id") UUID id) {
		ContainerType ingreso = service.findById(id);
		if (ingreso == null) {
			return ResponseEntity.notFound().build();
		}
		ContainerTypeDTO ingresoDTO = converter.fromEntity(ingreso);
		return new WrapperResponse<ContainerTypeDTO>(true, "succes", ingresoDTO).createResponse(HttpStatus.OK);
	}
	@PostMapping()
	public ResponseEntity<ContainerTypeDTO> create(
			@RequestBody ContainerTypeDTO ingresoDTO) {
		ContainerType createIngreso = service.save(converter.fromDTO(ingresoDTO));
		ContainerTypeDTO ingresoReturn=converter.fromEntity(createIngreso);
		return new WrapperResponse(true, "success", ingresoReturn).createResponse(HttpStatus.CREATED);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(
			@PathVariable("id") UUID id) {
		service.delete(id);
		return new WrapperResponse(true, "success", null).createResponse(HttpStatus.OK);
	}
}
