package comciudad.dona.converters;
import java.util.UUID;

import comciudad.dona.dtos.productoRegistroDto;
import comciudad.dona.entity.Brand;
import comciudad.dona.entity.Product;
import comciudad.dona.entity.Store;
import comciudad.dona.entity.typeProduct;
public class productConverters extends AbstractConverter<Product, productoRegistroDto> {

	@Override
	public productoRegistroDto fromEntity(Product entity) {
	    if (entity == null) {
	        return null;
	    }

	    UUID idTipoProducto = 
	    		(entity.getIdtypeProduct() != null
	    		&& entity.getIdtypeProduct().getId() != null)
	            ? entity.getIdtypeProduct().getId()
	            : null;
	    
	    String nombretipo = (entity.getIdtypeProduct() != null 
	    		&& entity.getIdtypeProduct().getId() != null)
	            ? entity.getIdtypeProduct().getTipeProducName()
	            : null;
	    
	    
	    UUID idMarca = 
	    		(entity.getBrand() != null
	    		&& entity.getBrand().getId() != null)
	            ? entity.getBrand().getId()
	            : null;
	    
	    String  NombreMarca = 
	    		(entity.getBrand() != null
	    		&& entity.getBrand().getId() != null)
	            ? entity.getBrand().getName()
	            : null;
	    
	    
	     UUID id_tienda= (entity.getStore() != null
		    		&& entity.getStore().getId() != null)
		            ? entity.getStore().getId()
		            : null;

	    
	    
	    return productoRegistroDto.builder()
	            .id(entity.getId())
	            .activo(entity.getActivo())
	            .cualidad(entity.getCualidad())
	            .id_tipoproducto(idTipoProducto)
	            .nombreTipoProd(nombretipo)
	            .idMarca(idMarca)
	            .id_tienda(id_tienda)
	            .nombreMarca(NombreMarca)
	            .fotoPrincipalBase64(entity.getFotoUrlPrincipal())
	            .Short_Description(entity.getShortDescription())
	            .build();
	}

	@Override
	public Product fromDTO(productoRegistroDto dto) {
		if (dto == null)return null;
		Product objet = new Product();
		objet.setId(dto.getId());
		objet.setActivo(dto.getActivo());
		objet.setCualidad(dto.getCualidad());
		objet.setFotoUrlPrincipal(dto.getFotoPrincipalBase64());
		objet.setShortDescription(dto.getShort_Description());
		Brand brand = new Brand();
		brand.setId(dto.getIdMarca());
		Store store = new Store();
		store.setId(dto.getId_tienda());
		
		typeProduct tipe= new typeProduct();
		tipe.setId(dto.getId_tipoproducto());
		objet.setIdtypeProduct(tipe);
		
		objet.setStore(store);
		objet.setBrand(brand);
		return objet;
	}
	
	
	
}
