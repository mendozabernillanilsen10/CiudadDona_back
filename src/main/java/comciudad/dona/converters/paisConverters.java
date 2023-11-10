package comciudad.dona.converters;
import comciudad.dona.dtos.paisDTO;
import comciudad.dona.entity.Pais;

public class paisConverters extends AbstractConverter<Pais,paisDTO> {

	@Override
	public paisDTO fromEntity(Pais entity) {
		if (entity==null) return null;
		return paisDTO.builder()
				.id(entity.getId())
				.nombre(entity.getNombre())
				.build();
	}

	@Override
	public Pais fromDTO(paisDTO dto) {
		if(dto==null) return null; 
		Pais p=new Pais();
		p.setId(dto.getId());
		p.setNombre(dto.getNombre());
		return p;
	}

}
