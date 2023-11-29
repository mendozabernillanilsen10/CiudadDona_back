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
import comciudad.dona.converters.ImageProductConverters;
import comciudad.dona.dtos.CategoriaDTO;
import comciudad.dona.dtos.ImagesProductDto;
import comciudad.dona.entity.ImagesProduct;
import comciudad.dona.service.ImagesProductService;
import comciudad.dona.service.fileService;
import comciudad.dona.utils.Rutas;
import comciudad.dona.utils.WrapperResponse;

@SuppressWarnings({ "rawtypes", "unchecked" })
@RestController
@RequestMapping("/v1/ImagenProducto")
public class ImageProductControllers {

	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;
	@Autowired
	private fileService servicefile;

	@Autowired
	ImagesProductService service;

	ImageProductConverters converter = new ImageProductConverters();
/*
	@PostMapping("/AgregarImg")
	public ResponseEntity<ImagesProductDto> create(
			@RequestParam(value = "productId", required = false) UUID productId,
			@RequestPart("ListaImg") List<MultipartFile> foto) {
		try {
			ImagesProductDto ImgProduc = new ImagesProductDto();
			ImgProduc.setIddetalle(productId);

			ImagesProduct createIngreso = service.save(converter.fromDTO(ImgProduc), foto);
			ImagesProductDto ingresoReturn = converter.fromEntity(createIngreso);

			return new WrapperResponse(true, "success", ingresoReturn).createResponse(HttpStatus.OK);
		} catch (ValidateServiceException | NoDataFoundException e) {
			throw new GeneralServiceException(e.getMessage(), e);

			// return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Maneja el error de
			// validación
		} catch (GeneralServiceException e) {
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	
	*/

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> optenelistaProducto() {
		List<ImagesProduct> cats = service.findAll();
		List<ImagesProductDto> dtos = new ArrayList<>();
		for (ImagesProduct c : cats) {
			ImagesProductDto dto = new ImagesProductDto();
			dto.setId(c.getId());
			dto.setFoto_url(MvcUriComponentsBuilder
					.fromMethodName(ImageProductControllers.class, "serveFile", c.getFoto_url()).build().toString());
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
