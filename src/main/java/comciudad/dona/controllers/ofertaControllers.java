package comciudad.dona.controllers;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import comciudad.dona.converters.OfertaConverters;
import comciudad.dona.dtos.OfertaDto;
import comciudad.dona.entity.Oferta;
import comciudad.dona.service.OfertaService;
import comciudad.dona.utils.WrapperResponse;
import lombok.RequiredArgsConstructor;

@SuppressWarnings({ "rawtypes", "unchecked" })
@RestController
@RequestMapping("/v1/ofertas")
@RequiredArgsConstructor
public class ofertaControllers {
	@Autowired
	private OfertaService service;
	OfertaConverters converter = new OfertaConverters();
	

	@GetMapping(value = "/listar")
	public ResponseEntity<List<OfertaDto>> findByCategory(
			@RequestParam(value = "nombre", required = false, defaultValue = "0") String nombre,
			@RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize) {
		List<Oferta> ingresos = service.findAll();
		List<OfertaDto> ingresosDTO = converter.fromEntity(ingresos);
		return new WrapperResponse(true, "success", ingresosDTO).createResponse(HttpStatus.OK);
	}
}


