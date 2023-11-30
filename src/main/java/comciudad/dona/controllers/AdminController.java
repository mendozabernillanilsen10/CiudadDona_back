package comciudad.dona.controllers;

import java.time.Instant; 
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import comciudad.dona.dtos.CategoriaDTO;
import comciudad.dona.dtos.CategoriaStoreDTO;
import comciudad.dona.dtos.LoginRequest;
import comciudad.dona.dtos.ResponseEmailDto;
import comciudad.dona.dtos.ResponseSuces;
import comciudad.dona.dtos.SubCategoriatoreDTO;
import comciudad.dona.dtos.TimetableDTO;
import comciudad.dona.entity.CategoriStore;
import comciudad.dona.entity.Category;
import comciudad.dona.entity.Company;
import comciudad.dona.entity.Store;
import comciudad.dona.entity.SubCategoriStore;
import comciudad.dona.entity.Subcategory;
import comciudad.dona.entity.Timetable;
import comciudad.dona.entity.ubdistrito;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.service.AuthService;
import comciudad.dona.service.CategoriStoreService;
import comciudad.dona.service.DistritoService;
import comciudad.dona.service.StoreService;
import comciudad.dona.service.SubCategoriStoreService;
import comciudad.dona.service.SubCategoriaService;
import comciudad.dona.service.TimetableService;
import comciudad.dona.service.categoriaService;
import comciudad.dona.service.companiaService;
import comciudad.dona.utils.WrapperResponse;
import lombok.RequiredArgsConstructor;
@SuppressWarnings({ "rawtypes", "unchecked" })
@RestController
@RequestMapping("/api/private")
@RequiredArgsConstructor
public class AdminController {
	// private static final DateTimeFormatter dateTimeFormat =
	// DateTimeFormatter.ofPattern("HH:mm:ss");
	DateTimeFormatter dateTimeFormatWithTimeZone = DateTimeFormatter.ofPattern("HH:mm:ss");

	private final AuthService authService;
	@Autowired
	private StoreService storeservice;
	@Autowired
	private categoriaService Categoriaservice;
	@Autowired
	private SubCategoriaService SubCategoriaservice;
	@Autowired
	private DistritoService Distritoservice;
	@Autowired
	private companiaService companiservice;
	@Autowired
	TimetableService serviceTime;
	@Autowired
	CategoriStoreService categoriaServicestory;
	@Autowired
	SubCategoriStoreService substoricate;
	
	
	@PostMapping("/AgregarTienda")
	public ResponseEntity<ResponseSuces> create(
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam("foto") MultipartFile foto,
			@RequestParam(value = "CompanId", required = false) UUID CompanId,
			@RequestParam(value = "id_distrito", required = false) Long id_distrito,
		
			@RequestPart("horarios") List<TimetableDTO> horarios,
			@RequestPart("categorias") List<CategoriaStoreDTO> Categorias
	) {
		try {

			ResponseSuces categoriaGuardadaDTO = new ResponseSuces();
			Store store = new Store();
			store.setName(nombre);

			if (id_distrito != null && !id_distrito.toString().isEmpty()) {
				ubdistrito distrito = Distritoservice.findById(id_distrito);
				if (distrito != null) {
					store.setIdDistrito(distrito);
				}
			}
			if (CompanId != null && !CompanId.toString().isEmpty()) {
				Company company = companiservice.findById(CompanId);
				if (company != null) {
					store.setCompany(company);
				}
			}
			Store storeRegister = storeservice.save(store, foto);
			if (horarios != null && !horarios.isEmpty()) {

				for (TimetableDTO timetable : horarios) {
					Timetable h = new Timetable();
					h.setApertura(parseTimeWithTimeZone(timetable.getApertura()));
					h.setCierre(parseTimeWithTimeZone(timetable.getCierre()));
					h.setStore(storeRegister);
					serviceTime.save(h);
				}
			}

			for (CategoriaStoreDTO categoria : Categorias) {
				Category category = Categoriaservice.findById(categoria.getId_categoria());
				if (categoria != null) {
					CategoriStore categoristori = new CategoriStore();
					CategoriStore categoristoriinsert = new CategoriStore();
					categoristori.setCategory(category);
					categoristori.setStore(storeRegister);
					categoristoriinsert = categoriaServicestory.save(categoristori);
					List<SubCategoriatoreDTO> subCategorias = categoria.getSubCategorias();
					if (subCategorias != null && !subCategorias.isEmpty()) {
						for (SubCategoriatoreDTO subCategoria : subCategorias) {
							
							Subcategory SubCategoriaStore =SubCategoriaservice.findById(subCategoria.getId_subCategoria());
							if(SubCategoriaStore !=null ) {
								SubCategoriStore sub = new SubCategoriStore();
								sub.setStore(storeRegister);
								sub.setSubcategory(SubCategoriaStore);
								sub.setIdcategorystore(categoristoriinsert);
								substoricate.save(sub);
							}
						}
					}
				}

			}
			if (foto != null) {
				categoriaGuardadaDTO.setMensaje("Registro Exitoso S");
			} else {
				categoriaGuardadaDTO.setMensaje("fallo al registro ");
			}
			
			return new WrapperResponse(true, "success", categoriaGuardadaDTO).createResponse(HttpStatus.OK);
		} catch (ValidateServiceException | NoDataFoundException e) {
			throw new GeneralServiceException(e.getMessage(), e);
			
			
			//return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Maneja el error de validación
		} catch (GeneralServiceException e) {
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	

	
	

	@GetMapping("/listaTiendaCompany/{idCompani}")
	public ResponseEntity<List<CategoriaDTO>> listatiendacompany(
			@PathVariable UUID idCompani) {
		Company comew = new Company();
		comew.setId(idCompani);
		List<Store> cats = storeservice.lisByIdcompany(comew);
		List<CategoriaDTO> dtos = new ArrayList<>();
		for (Store c : cats) {
			CategoriaDTO dto = new CategoriaDTO();
			dto.setId(c.getId());
			dto.setNombre(c.getName());
			dto.setFoto_url(MvcUriComponentsBuilder.fromMethodName(StoreControllers.class, "serveFile", c.getFoto_url())
					.build().toString());
			dtos.add(dto);
		}
		return new WrapperResponse(true, "success", dtos).createResponse(HttpStatus.OK);
	}
	
	
	
	
	
	
	private Date parseTimeWithTimeZone(String timeWithTimeZone) {
		if (timeWithTimeZone == null)
			return null;
		LocalTime localTime = LocalTime.parse(timeWithTimeZone, dateTimeFormatWithTimeZone);
		Instant instant = localTime.atDate(LocalDate.of(1970, 1, 1)).atZone(ZoneId.of("UTC")).toInstant();
		return Date.from(instant);
	}

	@PutMapping(value = "/reset")
	public ResponseEntity<WrapperResponse<ResponseEmailDto>> reset(@RequestBody LoginRequest request) {
		try {
			ResponseEmailDto mensaje = authService.ResetPassword(request);
			return new WrapperResponse<>(true, "success", mensaje).createResponse(HttpStatus.OK);
		} catch (ValidateServiceException e) {
			throw new GeneralServiceException(e.getMessage(), e);
		} catch (NoDataFoundException e) {
			throw new GeneralServiceException(e.getMessage(), e);
		} catch (Exception e) {
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

}
