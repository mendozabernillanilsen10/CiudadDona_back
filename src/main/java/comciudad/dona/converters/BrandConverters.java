package comciudad.dona.converters;

import comciudad.dona.dtos.BrandDTO;  
import comciudad.dona.entity.Brand;
import comciudad.dona.entity.typeProduct;

public class BrandConverters extends AbstractConverter<Brand,BrandDTO>{

	@Override
	public BrandDTO fromEntity(Brand entity) {
		if (entity == null) return null;
		return BrandDTO.builder()
				.id(entity.getId())
				.nombre(entity.getName())
				.build();
	}
	@Override
	public Brand fromDTO(BrandDTO dto) {
		if (dto==null) return null;
		Brand objet=new Brand();
		objet.setName(dto.getNombre());
		objet.setId(dto.getId());
		typeProduct type = new typeProduct();
		type.setId(dto.getIdtype());
		objet.setTypeProduct(type);
		return objet;
		
	}

}
