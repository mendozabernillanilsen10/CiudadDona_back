package comciudad.dona.converters;
import comciudad.dona.dtos.UbDepartamentoDTO; 
import comciudad.dona.entity.ubdepartamento;
public class DepartementoConverters extends 
    AbstractConverter<ubdepartamento,UbDepartamentoDTO>  {

	@Override
	public UbDepartamentoDTO fromEntity(ubdepartamento entity) {
		if (entity==null) return null;
		return UbDepartamentoDTO.builder()
				.id(entity.getId())
				.nombre(entity.getNombre())
				.build();
	}

	@Override
	public ubdepartamento fromDTO(UbDepartamentoDTO dto) {
		if(dto==null) return null; 
		ubdepartamento p=new ubdepartamento();
		p.setId(dto.getId());
		p.setNombre(dto.getNombre());
		return p;
	}

}
