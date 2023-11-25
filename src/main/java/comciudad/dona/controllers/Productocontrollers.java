package comciudad.dona.controllers;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import comciudad.dona.converters.productConverters;
import comciudad.dona.dtos.productDto;
import comciudad.dona.entity.Product;
import comciudad.dona.service.fileService;
import comciudad.dona.service.productService;
import comciudad.dona.utils.Rutas;
import comciudad.dona.utils.WrapperResponse;
import lombok.RequiredArgsConstructor;

@SuppressWarnings({ "rawtypes", "unchecked" })
@RestController
@RequestMapping("/v1/producto")
@RequiredArgsConstructor
public class Productocontrollers {
	productConverters converter = new productConverters();
	@Autowired
	productService service;
	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;
	@Autowired
	private fileService servicefile;
	
	@GetMapping(value = "/listar")
	public ResponseEntity<WrapperResponse<List<productDto>>> findByCategory(
	        @RequestParam(value = "nombre", required = false, defaultValue = "0") String nombre,
	        @RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
	        @RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize) {
	    List<Product> productos = service.findAll();
	    List<productDto> productosDTO = new ArrayList<>();

	    for (Product producto : productos) {
	        productDto dto = converter.fromEntity(producto);
	        // Construir la URL de descarga para la foto principal
	        String fotoPrincipalUrl = MvcUriComponentsBuilder
	                .fromMethodName(Productocontrollers.class, "serveFile", producto.getFotoUrlPrincipal()).build().toString();
	        dto.setFotoUrlPrincipal(fotoPrincipalUrl);
	        productosDTO.add(dto);
	    }
	    return new WrapperResponse<>(true, "success", productosDTO).createResponse(HttpStatus.OK);
	}
	@GetMapping(value = "download")
	public ResponseEntity<Resource> serveFile(@RequestParam(value = "filename") String filename) {
		String filePath = Paths.get(uploadPath, Rutas.IMG_PRODUCT, filename).toString();
		Resource file = (Resource) servicefile.loadAsResource(filePath);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
			
}
