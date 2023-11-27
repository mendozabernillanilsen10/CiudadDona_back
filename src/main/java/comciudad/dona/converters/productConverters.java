package comciudad.dona.converters;
import comciudad.dona.dtos.productDto;
import comciudad.dona.entity.Brand;
import comciudad.dona.entity.Product;
public class productConverters extends AbstractConverter<Product, productDto> {

	@Override
	public productDto fromEntity(Product entity) {
		if (entity == null)
			return null;
		return productDto.builder()
				.id(entity.getId())
				.activo(entity.getActivo())
				.Cualidad(entity.getCualidad())
				.idMarca(entity.getBrand().getId())
				.nombreMarca(entity.getBrand().getName())
				.fotoUrlPrincipal(entity.getFotoUrlPrincipal())
				.Short_Description(entity.getShortDescription())
				.build();
	}
	@Override
	public Product fromDTO(productDto dto) {
		if (dto == null)return null;
		Product objet = new Product();
		objet.setId(dto.getId());
		objet.setActivo(dto.getActivo());
		objet.setFotoUrlPrincipal(dto.getFotoUrlPrincipal());
		objet.setShortDescription(dto.getShort_Description());
		Brand brand = new Brand();
		brand.setId(dto.getId());
		objet.setBrand(brand);
		return objet;
	}
	
	
	
}
