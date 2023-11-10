package comciudad.dona.converters;
import comciudad.dona.dtos.provinciaDTO;
import comciudad.dona.entity.ubprovincia;

public class provinciaConverters extends AbstractConverter<ubprovincia,provinciaDTO> {

	@Override
	public provinciaDTO fromEntity(ubprovincia entity) {
		if (entity==null) return null;
		return provinciaDTO.builder()
				.id(entity.getId())
				.nombre(entity.getNombre())
				.build();
	}

	@Override
	public ubprovincia fromDTO(provinciaDTO dto) {
		if(dto==null) return null; 
		ubprovincia p=new ubprovincia();
		p.setId(dto.getId());
		p.setNombre(dto.getNombre());
		return p;
	}

}
