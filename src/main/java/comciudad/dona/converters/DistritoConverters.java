package comciudad.dona.converters;

import comciudad.dona.dtos.DistritoDto;
import comciudad.dona.entity.ubdistrito;
public class DistritoConverters extends AbstractConverter<ubdistrito,DistritoDto>{

	@Override
	public DistritoDto fromEntity(ubdistrito entity) {
		if (entity==null) return null;
		return DistritoDto.builder()
				.id(entity.getId())
				.nombre(entity.getNombre())
				.build();
	}

	@Override
	public ubdistrito fromDTO(DistritoDto dto) {
		if(dto==null) return null; 
		ubdistrito p=new ubdistrito();
		p.setId(dto.getId());
		p.setNombre(dto.getNombre());
		return p;
	}


}
