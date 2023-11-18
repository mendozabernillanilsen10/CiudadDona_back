package comciudad.dona.controllers;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import comciudad.dona.dtos.CategoriaDTO;
import comciudad.dona.dtos.ResponseSuces;
import comciudad.dona.entity.Category;
import comciudad.dona.entity.Company;
import comciudad.dona.entity.Store;
import comciudad.dona.entity.Subcategory;
import comciudad.dona.entity.ubdistrito;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.service.DistritoService;
import comciudad.dona.service.StoreService;
import comciudad.dona.service.SubCategoriaService;
import comciudad.dona.service.categoriaService;
import comciudad.dona.service.companiaService;
import comciudad.dona.service.fileService;
import comciudad.dona.utils.Rutas;
import comciudad.dona.utils.WrapperResponse;
import lombok.extern.slf4j.Slf4j;
@SuppressWarnings({ "rawtypes", "unchecked" })
@Slf4j
@RestController
@RequestMapping("/v1/Store")
public class StoreControllers {

	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;
	@Autowired
	private fileService servicefile;
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
	
	
	  @GetMapping("/por-distrito/{idDistrito}")
		public ResponseEntity<List<CategoriaDTO>> obtenerTiendasPorDistrito(
				@PathVariable Long idDistrito

		) {
	        List<Store> cats = storeservice.obtenerTiendasPorDistrito(idDistrito);

			List<CategoriaDTO> dtos = new ArrayList<>();
			for (Store c : cats) {
				CategoriaDTO dto = new CategoriaDTO();
				dto.setId(c.getId());
				dto.setNombre(c.getName());
				dto.setFoto_url(MvcUriComponentsBuilder
						.fromMethodName(StoreControllers.class, "serveFile", c.getFoto_url()).build().toString());
				dtos.add(dto);
			}
			return new WrapperResponse(true, "success", dtos).createResponse(HttpStatus.OK);
		}

	@GetMapping("/StoreSubCategoria/{idDistrito}/{idCategoria}")
	public ResponseEntity<List<CategoriaDTO>> obtenerSubcategoriasPorTiendaDistritoYCategoria(
			@PathVariable Long idDistrito, @PathVariable UUID idCategoria

	) {
		List<Store> cats = storeservice.obtenerTiendasPorDistritoYCategoria(idDistrito, idCategoria);

		List<CategoriaDTO> dtos = new ArrayList<>();
		for (Store c : cats) {
			CategoriaDTO dto = new CategoriaDTO();
			dto.setId(c.getId());
			dto.setNombre(c.getName());
			dto.setFoto_url(MvcUriComponentsBuilder
					.fromMethodName(StoreControllers.class, "serveFile", c.getFoto_url()).build().toString());
			dtos.add(dto);
		}
		return new WrapperResponse(true, "success", dtos).createResponse(HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ResponseSuces> create(
		        @RequestParam(value = "nombre", required = false) String nombre,
		        @RequestParam(value = "foto", required = false) MultipartFile foto,
		        @RequestParam(value = "categorId", required = false) UUID categorId,
		        @RequestParam(value = "SubcatId", required = false) UUID SubcatId,
		        @RequestParam(value = "CompanId", required = false) UUID CompanId,
		        @RequestParam(value = "id_distrito", required = false) Long id_distrito
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
		        if( storeRegister != null) {
		        	categoriaGuardadaDTO.setMensaje("Registro Exitoso");
		        }else {
		        	categoriaGuardadaDTO.setMensaje("fallo al registro ");
		        }
			return new WrapperResponse(true, "success", categoriaGuardadaDTO).createResponse(HttpStatus.OK);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Maneja el error de validación
		} catch (GeneralServiceException e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Maneja errores generales del servicio
		}
	}
	
	@GetMapping(value = "download")
	public ResponseEntity<Resource> serveFile(@RequestParam(value = "filename") String filename) {
		String filePath = Paths.get(uploadPath, Rutas.IMG_STORE, filename).toString();
		Resource file = (Resource) servicefile.loadAsResource(filePath);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

}
