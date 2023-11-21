package comciudad.dona.controllers;

import org.springframework.beans.factory.annotation.Autowired;    

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import comciudad.dona.utils.WrapperResponse;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import comciudad.dona.dtos.CategoriaDTO;

import comciudad.dona.entity.Store;

import comciudad.dona.service.StoreService;
import comciudad.dona.service.fileService;
import comciudad.dona.utils.Rutas;


@SuppressWarnings({ "rawtypes", "unchecked" })

@RestController
@RequestMapping("/v1/Store")
public class StoreControllers {

	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;
	@Autowired
	private fileService servicefile;
	@Autowired
	private StoreService storeservice;

	
	  @GetMapping("/por-distrito-cat-sub/{pIdDistrito}/{pIdCategoria}/{pIdSubcategoria}")
		public ResponseEntity<List<CategoriaDTO>> obtenerTiendasPorDistrito(
				@PathVariable Long pIdDistrito,
				@PathVariable UUID pIdCategoria,
				@PathVariable UUID pIdSubcategoria

		) {
	        List<Store> cats = storeservice.obtenerTiendasPorDistrito(
	        		pIdDistrito,
	    			pIdCategoria , pIdSubcategoria);

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
	
	@GetMapping("/StoreSinSubCategoria/{idDistrito}/{idCategoria}")
	public ResponseEntity<List<CategoriaDTO>> 
	obtenerSubcategoriasPorTiendaDistritoYCategoria(
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

	
	@GetMapping(value = "download")
	public ResponseEntity<Resource> serveFile(@RequestParam(value = "filename") String filename) {
		String filePath = Paths.get(uploadPath, Rutas.IMG_STORE, filename).toString();
		Resource file = (Resource) servicefile.loadAsResource(filePath);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

}
