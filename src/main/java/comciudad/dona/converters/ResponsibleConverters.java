package comciudad.dona.converters;
import comciudad.dona.dtos.ResponsibleDTO;
import comciudad.dona.entity.Responsible;

public class ResponsibleConverters extends AbstractConverter<Responsible,ResponsibleDTO> {

	@Override
	public ResponsibleDTO fromEntity(Responsible entity) {
		if (entity==null) return null;
		return ResponsibleDTO.builder()
				.id(entity.getId())
				.nombre(entity.getName())
				.whatsapp(entity.getWhatsapp())
				.apellido(entity.getSurName())
				.celular(entity.getCelular())
				.build();
	}

	@Override
	public Responsible fromDTO(ResponsibleDTO dto) {
		if(dto==null) return null; 
		Responsible p=new Responsible();
		p.setId(dto.getId());
		p.setCelular(dto.getCelular());
		p.setId(dto.getId());
		p.setName(dto.getNombre());
		p.setSurName(dto.getApellido());		
		return p;
	}
	
	
	
	
	
	
	
	
	
	
	

}
