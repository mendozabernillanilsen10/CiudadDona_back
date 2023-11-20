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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import comciudad.dona.converters.StoreRequestConverterts;
import comciudad.dona.dtos.LoginRequest;
import comciudad.dona.dtos.ResponseEmailDto;
import comciudad.dona.dtos.ResponseSuces;
import comciudad.dona.dtos.TimetableDTO;
import comciudad.dona.entity.Category;
import comciudad.dona.entity.Company;
import comciudad.dona.entity.Store;
import comciudad.dona.entity.Subcategory;
import comciudad.dona.entity.Timetable;
import comciudad.dona.entity.ubdistrito;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.service.AuthService;
import comciudad.dona.service.DistritoService;
import comciudad.dona.service.StoreService;
import comciudad.dona.service.SubCategoriaService;
import comciudad.dona.service.TimetableService;
import comciudad.dona.service.categoriaService;
import comciudad.dona.service.companiaService;
import comciudad.dona.utils.WrapperResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@SuppressWarnings({ "rawtypes", "unchecked" })
@RestController
@RequestMapping("/api/private")
@RequiredArgsConstructor
public class AdminController {
	//private static final DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
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
	StoreRequestConverterts converter = new StoreRequestConverterts();
	@Autowired
	TimetableService serviceTime;
	@PostMapping("/AgregarTienda")
	public ResponseEntity<ResponseSuces> create(
		        @RequestParam(value = "nombre", required = false) String nombre,
		        @RequestParam(value = "foto", required = false) MultipartFile foto,
		        @RequestParam(value = "categorId", required = false) UUID categorId,
		        @RequestParam(value = "SubcatId", required = false) UUID SubcatId,
		        @RequestParam(value = "CompanId", required = false) UUID CompanId,
		        @RequestParam(value = "id_distrito", required = false) Long id_distrito,
		        @RequestPart("horarios") List<TimetableDTO> horarios
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
			if( categorId !=null && !categorId.toString().isEmpty()) {
				Category categoria = Categoriaservice.findById(categorId);
				if(categoria != null) {
				store.setCategory(categoria != null ? categoria :null );
				}
			}
			if(SubcatId != null && !SubcatId.toString().isEmpty() ) {
				Subcategory subCategoria =SubCategoriaservice.findById(SubcatId);
				if(subCategoria !=null ) {
					store.setSubcategory(subCategoria != null ? subCategoria :null);
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
		      if( storeRegister != null) {
		        	categoriaGuardadaDTO.setMensaje("Registro Exitoso");
		        }else {
		        	categoriaGuardadaDTO.setMensaje("fallo al registro ");
		        }  
			return new WrapperResponse(true, "success", categoriaGuardadaDTO).createResponse(HttpStatus.OK);
		} catch (ValidateServiceException | NoDataFoundException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Maneja el error de validación
		} catch (GeneralServiceException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Maneja errores generales del servicio
		}
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
