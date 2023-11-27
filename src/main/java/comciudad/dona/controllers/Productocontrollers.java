package comciudad.dona.controllers;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import comciudad.dona.converters.BrandConverters;
import comciudad.dona.converters.IngresosResponse;
import comciudad.dona.converters.productConverters;
import comciudad.dona.dtos.BrandDTO;
import comciudad.dona.dtos.LoginRequest;
import comciudad.dona.dtos.OtpRequest;
import comciudad.dona.dtos.ResponseEmailDto;
import comciudad.dona.dtos.productDto;
import comciudad.dona.dtos.productoRegistroDto;
import comciudad.dona.entity.Brand;
import comciudad.dona.entity.Product;
import comciudad.dona.entity.typeProduct;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.service.BrandService;
import comciudad.dona.service.categoriaService;
import comciudad.dona.service.fileService;
import comciudad.dona.service.productService;
import comciudad.dona.service.typeProductService;
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
	@Autowired
	public BrandService serviceMarca;
	@Autowired
	private typeProductService serviceP;
	
	@PostMapping()
	public ResponseEntity<WrapperResponse<productDto>> create(
			@RequestBody productoRegistroDto ingresoDTO) {
		try {
			productDto dto = new productDto();
			if (ingresoDTO.getIdMarca()!= null) {
				Brand marcaExistente = serviceMarca.findById(ingresoDTO.getIdMarca());
				if (marcaExistente != null) {
					dto.setIdMarca(marcaExistente.getId());
				}
			} else {
				Brand nuevaMarca = new Brand();
				typeProduct typeProduct = new typeProduct();
				typeProduct.setId(ingresoDTO.getId_tipoproducto());
				nuevaMarca.setTypeProduct(typeProduct);
				nuevaMarca.setName(ingresoDTO.getNombreMarca());
				Brand marcaGuardada = serviceMarca.save(nuevaMarca);
				dto.setIdMarca(marcaGuardada.getId());
			}
			dto.setCualidad(ingresoDTO.getCualidad());
			dto.setFotoUrlPrincipal(ingresoDTO.getFotoPrincipalBase64());
			dto.setShort_Description(ingresoDTO.getShort_Description());
			
			typeProduct tipo =serviceP.findById(ingresoDTO.getId_tipoproducto());
			 switch (tipo.getTipeProducName()) {
		        case "Agua Mineral": 
		        	Product  c = service.save(converter.fromDTO(dto));
		        	break;
		        case "agua de mesa":
		        	Product  c2 = service.save(converter.fromDTO(dto));

		        	break;
		        default:
		            break;
		    }

			return new WrapperResponse<>(true, "success", dto).createResponse(HttpStatus.OK);
		} catch (ValidateServiceException e) {
			throw new GeneralServiceException(e.getMessage(), e);
		} catch (NoDataFoundException e) {
			throw new GeneralServiceException(e.getMessage(), e);
		} catch (Exception e) {
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

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
					.fromMethodName(Productocontrollers.class, "serveFile", producto.getFotoUrlPrincipal()).build()
					.toString();
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
