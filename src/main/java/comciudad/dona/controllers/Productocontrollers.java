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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import comciudad.dona.converters.DescripcionAguaConvertes;
import comciudad.dona.converters.ImageProductConverters;
import comciudad.dona.converters.OfertaConverters;
import comciudad.dona.converters.productConverters;

import comciudad.dona.dtos.OfertaDto;
import comciudad.dona.dtos.descripcionAguaDto;
import comciudad.dona.dtos.imgDesdcripcionDto;
import comciudad.dona.dtos.productoRegistroDto;
import comciudad.dona.entity.Brand;
import comciudad.dona.entity.DescripcionAgua;
import comciudad.dona.entity.ImagesProduct;
import comciudad.dona.entity.Oferta;
import comciudad.dona.entity.Product;
import comciudad.dona.entity.Store;
import comciudad.dona.entity.typeProduct;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.service.BrandService;
import comciudad.dona.service.DescripcionAguaService;
import comciudad.dona.service.ImagesProductService;
import comciudad.dona.service.OfertaService;
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
	@Autowired
	private DescripcionAguaService serviceDescripcion;
	private DescripcionAguaConvertes converterDes = new DescripcionAguaConvertes();
	@Autowired
	private OfertaService ofertaService;
	private OfertaConverters converteroferta = new OfertaConverters();
	@Autowired
	ImagesProductService serviceimgP;

	ImageProductConverters converterimgP = new ImageProductConverters();

	@PostMapping()
	public ResponseEntity<WrapperResponse<productoRegistroDto>> create(@RequestBody productoRegistroDto ingresoDTO) {
		try {
			typeProduct tipo = serviceP.findById(ingresoDTO.getId_tipoproducto());
			switch (tipo.getTipeProducName()) {
			case "Agua Mineral":
			case "Agua de Mesa":
				Brand marca = new Brand();
				Brand nuevaMarca = new Brand();
				typeProduct typeProduct = new typeProduct();

				if (ingresoDTO.getIdMarca() != null) {
					marca = serviceMarca.findById(ingresoDTO.getIdMarca());
				} else {

					typeProduct.setId(ingresoDTO.getId_tipoproducto());
					nuevaMarca.setTypeProduct(typeProduct);
					nuevaMarca.setName(ingresoDTO.getNombreMarca());
					marca = serviceMarca.save(nuevaMarca);

				}

				if (marca != null) {
					ingresoDTO.setIdMarca(marca.getId());
					ingresoDTO.setNombreMarca(marca.getName());
				}
				Product producto = service.save(converter.fromDTO(ingresoDTO));

				// DESCRIPCION
				if (ingresoDTO.getDescripcion().size() > 0) {
					for (descripcionAguaDto detalle : ingresoDTO.getDescripcion()) {
						detalle.setIdProducto(producto.getId());
						DescripcionAgua des = serviceDescripcion.save(converterDes.fromDTO(detalle));

						for (OfertaDto descripçion : detalle.getOferta()) {
							descripçion.setId_des(des.getId());
							Oferta ofer = ofertaService.save(converteroferta.fromDTO(descripçion));
						}

						for (imgDesdcripcionDto img_des : detalle.getImgDesdcripcion()) {
							img_des.setIddetalle(des.getId());
							ImagesProduct img = serviceimgP.save(converterimgP.fromDTO(img_des));
						}
          
					}
				}
				break;
			default:
				break;
			}
			return new WrapperResponse<>(true, "success", ingresoDTO).createResponse(HttpStatus.OK);
		} catch (ValidateServiceException e) {
			throw new GeneralServiceException(e.getMessage(), e);
		} catch (NoDataFoundException e) {
			throw new GeneralServiceException(e.getMessage(), e);
		} catch (Exception e) {
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@GetMapping(value = "/listar/{id_tienda}")
	public ResponseEntity<WrapperResponse<List<productoRegistroDto>>> findByCategory(
			@PathVariable("id_tienda") UUID id_tienda,
			@RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize) {
		Store store = new Store();
		store.setId(id_tienda);
		List<Product> productos = service.listaProductosTienda(store);
		List<productoRegistroDto> productosDTO = new ArrayList<>();

		for (Product producto : productos) {
			productoRegistroDto dto = converter.fromEntity(producto);
			String fotoPrincipalUrl = MvcUriComponentsBuilder
					.fromMethodName(Productocontrollers.class, "serveFile", producto.getFotoUrlPrincipal()).build()
					.toString();
			dto.setFotoPrincipalBase64(fotoPrincipalUrl);
			List<DescripcionAgua> listaDescripcion = serviceDescripcion.listaDescripcionProducto(producto);
			List<descripcionAguaDto> descripcionDto = converterDes.fromEntity(listaDescripcion);

			for(descripcionAguaDto descripcionagua : descripcionDto  ) {
				DescripcionAgua des = new DescripcionAgua();
				des.setId(descripcionagua.getId());
				List<Oferta> ofer = ofertaService.listaDescripcionProducto(des);
			    List<OfertaDto> ofertasDTO = converteroferta.fromEntity(ofer);
	            descripcionagua.setOferta(ofertasDTO);
	            
	            List<ImagesProduct> cats = serviceimgP.listaDescripcionProducto(des);
	    		List<imgDesdcripcionDto> dtos = new ArrayList<>();
	    		for (ImagesProduct c : cats) {
	    			imgDesdcripcionDto dtoss = new imgDesdcripcionDto();
	    			dtoss.setId(c.getId());
	    			dtoss.setFotoBase64(MvcUriComponentsBuilder
	    					.fromMethodName(Productocontrollers.class, "serveFile", c.getFoto_url()).build().toString());
	    			dtos.add(dtoss);
	    		}
	            
	    		descripcionagua.setImgDesdcripcion(dtos);
	            
	            
			}
			dto.setDescripcion(descripcionDto);
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
