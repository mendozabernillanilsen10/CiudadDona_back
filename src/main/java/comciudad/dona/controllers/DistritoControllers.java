package comciudad.dona.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comciudad.dona.converters.DistritoConverters;
import comciudad.dona.dtos.DistritoDto;
import comciudad.dona.dtos.UbDepartamentoDTO;
import comciudad.dona.entity.ubdistrito;
import comciudad.dona.entity.ubprovincia;
import comciudad.dona.service.DistritoService;
import comciudad.dona.utils.WrapperResponse;

@RestController
@RequestMapping("/v1/Distrito")
public class DistritoControllers {
	@Autowired
	DistritoService service;
	DistritoConverters converter = new DistritoConverters();
	@GetMapping("/byDistrito/{id}")
    public ResponseEntity<List<UbDepartamentoDTO>>
	getAlojamientosByCliente(@PathVariable 
     long id) {
		ubprovincia p = new ubprovincia();
        p.setId(id);
        List<ubdistrito> lista = service.findByidProv(p);
    	List<DistritoDto> articulosDTO =converter.fromEntity(lista);
		return new WrapperResponse(true, "success", articulosDTO).createResponse(HttpStatus.OK);		
    }

}
