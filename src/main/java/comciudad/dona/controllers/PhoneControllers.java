package comciudad.dona.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import comciudad.dona.converters.PersonaConverters;
import comciudad.dona.converters.PhoneConverters;
import comciudad.dona.dtos.PhoneDTO;
import comciudad.dona.dtos.RolDTO;
import comciudad.dona.entity.Phone;
import comciudad.dona.repository.personRepository;
import comciudad.dona.service.PersonService;
import comciudad.dona.service.PhoneService;
import comciudad.dona.utils.WrapperResponse;
@SuppressWarnings({ "rawtypes", "unchecked" })
@RestController
@RequestMapping("/v1/Phone")
public class PhoneControllers {
	@Autowired
	PhoneService service;
	PhoneConverters converter = new PhoneConverters();
	@Autowired
	personRepository prepository;
	@Autowired
	PersonService ser;

	PersonaConverters convert = new PersonaConverters();

	@GetMapping
	public ResponseEntity<List<RolDTO>> findAll(
			@RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize) {

		Pageable page = PageRequest.of(pageNumber, pageSize);
		List<Phone> articulos = service.findAll(page);

		List<PhoneDTO> articulosDTO = converter.fromEntity(articulos);
		return new WrapperResponse(true, "success", articulosDTO).createResponse(HttpStatus.OK);
	}
	
	

	/*
	 * F
	 * 
	 * @PostMapping(value = "/registers") public ResponseEntity<PhoneDTO> create(
	 * 
	 * @RequestParam("IdPersona") UUID idPersona,
	 * 
	 * @RequestParam("celular") String celular,
	 * 
	 * @RequestParam("whatsapp") String whatsapp ) { Person person =
	 * ser.findById(idPersona); Phone phone = new Phone();
	 * phone.setCelular(celular); phone.setWhatsapp(whatsapp);
	 * phone.setPerson(person); // Asocia el teléfono con la persona obtenida. Phone
	 * newPhone = service.save(phone); PhoneDTO phoneDTO =
	 * converter.fromEntity(newPhone); return new WrapperResponse(true, "Éxito",
	 * phoneDTO).createResponse(HttpStatus.CREATED); }
	 */

}
