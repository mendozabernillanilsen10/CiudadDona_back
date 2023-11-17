package comciudad.dona.controllers;
 
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comciudad.dona.converters.provinciaConverters;
import comciudad.dona.dtos.UbDepartamentoDTO;
import comciudad.dona.dtos.provinciaDTO;
import comciudad.dona.entity.ubdepartamento;
import comciudad.dona.entity.ubprovincia;
import comciudad.dona.service.provinciaService;
import comciudad.dona.utils.WrapperResponse;
@SuppressWarnings({ "rawtypes", "unchecked" })
@RestController
@RequestMapping("/v1/provincia")
public class provinciaControllers {

	@Autowired
	private provinciaService service;
	private provinciaConverters converter=new provinciaConverters();
	
	
	@GetMapping("/byprovincia/{proId}")
    public ResponseEntity<List<UbDepartamentoDTO>>
	getAlojamientosByCliente(@PathVariable 
     long proId) {
		ubdepartamento p = new ubdepartamento();
        p.setId(proId);
        List<ubprovincia> lista = service.findByidDepa(p);
    	List<provinciaDTO> articulosDTO =converter.fromEntity(lista);
		return new WrapperResponse(true, "success", articulosDTO).createResponse(HttpStatus.OK);		
    }	
}
