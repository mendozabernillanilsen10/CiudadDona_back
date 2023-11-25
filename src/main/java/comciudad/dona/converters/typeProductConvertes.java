package comciudad.dona.converters;

import comciudad.dona.dtos.typeProductDto;
import comciudad.dona.entity.typeProduct;

public class typeProductConvertes  extends AbstractConverter <typeProduct,typeProductDto> {

	@Override
	public typeProductDto fromEntity(typeProduct entity) {
		if(entity==null) return null; 
        return typeProductDto.builder()
                .id(entity.getId())
                .typeProduc(entity.getTipeProducName() )
                .build(); 
	}
	@Override
	public typeProduct fromDTO(typeProductDto dto) {
		if(dto==null) return null; 
		typeProduct cat=new typeProduct();
		cat.setTipeProducName(dto.getTypeProduc());
		cat.setId(dto.getId());
		return cat;
	}

}
