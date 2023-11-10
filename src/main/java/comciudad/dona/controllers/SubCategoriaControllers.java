package comciudad.dona.controllers;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import comciudad.dona.converters.IngresosResponse;
import comciudad.dona.converters.subCategoriaConverters;
import comciudad.dona.dtos.AddressDTO;
import comciudad.dona.dtos.AuthResponse;
import comciudad.dona.dtos.PesonDTO;
import comciudad.dona.dtos.PhoneDTO;
import comciudad.dona.dtos.RegisterRequest;
import comciudad.dona.dtos.RolDTO;
import comciudad.dona.dtos.SubCategoryDTO;
import comciudad.dona.dtos.UsuarioDTO;
import comciudad.dona.entity.Address;
import comciudad.dona.entity.Person;
import comciudad.dona.entity.Phone;
import comciudad.dona.entity.Role;
import comciudad.dona.entity.Subcategory;
import comciudad.dona.entity.User;
import comciudad.dona.entity.ubdistrito;
import comciudad.dona.service.SubCategoriaService;
import comciudad.dona.utils.WrapperResponse;

@RestController
@RequestMapping("/v1/SubCategoria")
public class SubCategoriaControllers {
	@Autowired
	SubCategoriaService servive;
	subCategoriaConverters con = new subCategoriaConverters();

	@GetMapping
	public ResponseEntity<List<SubCategoryDTO>> findAll(
			@RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "limit", required = false, defaultValue = "100") int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		List<Subcategory> articulos = servive.findAll(page);
		List<SubCategoryDTO> articulosDTO = con.fromEntity(articulos);
		return new WrapperResponse(true, "success", articulosDTO).createResponse(HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<WrapperResponse<IngresosResponse>> register(@RequestBody SubCategoryDTO articuloDTO) {
		try {
			Subcategory createArticulo = servive.save(con.fromDTO(articuloDTO));
			SubCategoryDTO articuloReturn = con.fromEntity(createArticulo);

			return new WrapperResponse(true, "success", articuloReturn).createResponse(HttpStatus.CREATED);
		} catch (Exception e) {
			String errorMessage = "Error: " + e.getMessage(); // Add the specific error message here
			return new ResponseEntity<>(new WrapperResponse<>(false, errorMessage, null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
