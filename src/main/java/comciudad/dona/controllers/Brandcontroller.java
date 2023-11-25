package comciudad.dona.controllers;

import java.util.ArrayList; 
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
import comciudad.dona.converters.BrandConverters;
import comciudad.dona.dtos.BrandDTO;
import comciudad.dona.entity.Brand;
import comciudad.dona.service.BrandService;
import comciudad.dona.service.categoriaService;
import comciudad.dona.utils.WrapperResponse;
import comciudad.dona.entity.typeProduct;

@RestController
@SuppressWarnings({ "rawtypes", "unchecked" })
@RequestMapping("/v1/marcas")
public class Brandcontroller {
	@Autowired
	public BrandService service;
	BrandConverters converter = new BrandConverters();
	@Autowired
	public categoriaService serviC;

	@GetMapping(value = "/listar")
	public ResponseEntity<List<BrandDTO>> findByCategory(
			@RequestParam(value = "nombre", required = false, defaultValue = "0") String nombre,
			@RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize) {
		// Pageable page = PageRequest.of(pageNumber, pageSize);
		List<Brand> ingresos = service.findAll();
		List<BrandDTO> ingresosDTO = converter.fromEntity(ingresos);
		return new WrapperResponse(true, "success", ingresosDTO).createResponse(HttpStatus.OK);
	}

	@GetMapping(value = "/listartypeProducto/{idTypeProduct}")
	public ResponseEntity<List<BrandDTO>> findAll(@PathVariable("idTypeProduct") UUID idTypeProduct) {
		typeProduct objet = new typeProduct(); 
		objet.setId(idTypeProduct);
		List<Brand> ingresos = service.finByIdUser(objet);
		List<BrandDTO> ingresosDTO = converter.fromEntity(ingresos);
		return new WrapperResponse(true, "success", ingresosDTO).createResponse(HttpStatus.OK);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<WrapperResponse<BrandDTO>> findById(@PathVariable("id") UUID id) {
		Brand ingreso = service.findById(id);
		if (ingreso == null) {
			return ResponseEntity.notFound().build();
		}
		BrandDTO ingresoDTO = converter.fromEntity(ingreso);
		return new WrapperResponse<BrandDTO>(true, "succes", ingresoDTO).createResponse(HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<BrandDTO> create(@RequestBody BrandDTO ingresoDTO) {
		Brand createIngreso = service.save(converter.fromDTO(ingresoDTO));
		BrandDTO ingresoReturn = converter.fromEntity(createIngreso);
		return new WrapperResponse(true, "success", ingresoReturn).createResponse(HttpStatus.CREATED);
	}
	@PostMapping("/createLista")
	public ResponseEntity<WrapperResponse<List<BrandDTO>>> createlista(@RequestBody List<BrandDTO> ingresoDTO) {
		List<BrandDTO> ingresoReturnList = new ArrayList<>();

		for (BrandDTO categoria : ingresoDTO) {
			Brand createIngreso = service.save(converter.fromDTO(categoria));
			BrandDTO ingresoReturn = converter.fromEntity(createIngreso);
			ingresoReturnList.add(ingresoReturn);
		}
		return new WrapperResponse<>(true, "success", ingresoReturnList).createResponse(HttpStatus.CREATED);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") UUID id) {
		service.delete(id);
		return new WrapperResponse(true, "success", null).createResponse(HttpStatus.OK);
	}

}
