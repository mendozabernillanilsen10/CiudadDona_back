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
import comciudad.dona.converters.MedidasProductoConverters;
import comciudad.dona.dtos.MedidasProductoDTO;
import comciudad.dona.entity.MedidasProducto;
import comciudad.dona.service.MedidasProductoService;
import comciudad.dona.utils.WrapperResponse;

@RestController
@SuppressWarnings({ "rawtypes", "unchecked" })
@RequestMapping("/v1/MedidasProducto")
public class MedidasProductoConrollers {

	@Autowired
	private MedidasProductoService service;
	private MedidasProductoConverters converter = new MedidasProductoConverters();

	@GetMapping(value = "/listar")
	public ResponseEntity<List<MedidasProductoDTO>> findByCategory(
			@RequestParam(value = "nombre", required = false, defaultValue = "0") String nombre,
			@RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize) {
		List<MedidasProducto> ingresos = service.findAll();
		List<MedidasProductoDTO> ingresosDTO = converter.fromEntity(ingresos);
		return new WrapperResponse(true, "success", ingresosDTO).createResponse(HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<WrapperResponse<MedidasProductoDTO>> findById(@PathVariable("id") UUID id) {
		MedidasProducto ingreso = service.findById(id);
		if (ingreso == null) {
			return ResponseEntity.notFound().build();
		}
		MedidasProductoDTO ingresoDTO = converter.fromEntity(ingreso);
		return new WrapperResponse<MedidasProductoDTO>(true, "succes", ingresoDTO).createResponse(HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<MedidasProductoDTO> create(@RequestBody MedidasProductoDTO ingresoDTO) {
		MedidasProducto createIngreso = service.save(converter.fromDTO(ingresoDTO));
		MedidasProductoDTO ingresoReturn = converter.fromEntity(createIngreso);
		return new WrapperResponse(true, "success", ingresoReturn).createResponse(HttpStatus.CREATED);
	}

	@PostMapping("/createLista")
	public ResponseEntity<WrapperResponse<List<MedidasProductoDTO>>> createlista(
			@RequestBody List<MedidasProductoDTO> ingresoDTO) {
		List<MedidasProductoDTO> ingresoReturnList = new ArrayList<>();

		for (MedidasProductoDTO categoria : ingresoDTO) {
			MedidasProducto createIngreso = service.save(converter.fromDTO(categoria));
			MedidasProductoDTO ingresoReturn = converter.fromEntity(createIngreso);
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
