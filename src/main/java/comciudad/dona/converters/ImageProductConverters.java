package comciudad.dona.converters;

import comciudad.dona.dtos.ImagesProductDto;
import comciudad.dona.entity.DescripcionAgua;
import comciudad.dona.entity.ImagesProduct;

public class ImageProductConverters extends AbstractConverter<ImagesProduct, ImagesProductDto> {
	@Override
	public ImagesProductDto fromEntity(ImagesProduct entity) {
		if (entity == null)
			return null;
		return ImagesProductDto.builder().id(entity.getId()).foto_url(entity.getFoto_url()).build();
	}
	
	@Override
	public ImagesProduct fromDTO(ImagesProductDto dto) {
		if (dto == null)
			return null;
		ImagesProduct objet = new ImagesProduct();
		objet.setId(dto.getId());
		objet.setFoto_url(dto.getFoto_url());
		DescripcionAgua product = new DescripcionAgua();
		product.setId(dto.getProducto());
		objet.setDescripcionAgua(product);
		return objet;
	}

}
