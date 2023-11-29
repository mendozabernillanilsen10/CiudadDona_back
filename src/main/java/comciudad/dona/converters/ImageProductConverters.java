package comciudad.dona.converters;

import comciudad.dona.dtos.imgDesdcripcionDto;
import comciudad.dona.entity.DescripcionAgua;
import comciudad.dona.entity.ImagesProduct;

public class ImageProductConverters extends AbstractConverter<ImagesProduct, imgDesdcripcionDto> {
	@Override
	public imgDesdcripcionDto fromEntity(ImagesProduct entity) {
		if (entity == null)
			return null;
		return imgDesdcripcionDto.builder().id(entity.getId())
				.fotoBase64(entity.getFoto_url()).build();
	}

	@Override
	public ImagesProduct fromDTO(imgDesdcripcionDto dto) {
		if (dto == null)
			return null;
		ImagesProduct objet = new ImagesProduct();
		objet.setId(dto.getId());
		objet.setFoto_url(dto.getFotoBase64());
		DescripcionAgua des = new DescripcionAgua();
		des.setId(dto.getIddetalle());
		objet.setDescripcionAgua(des);
		return objet;
	}

}
