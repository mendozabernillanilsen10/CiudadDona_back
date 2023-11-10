package comciudad.dona.converters;
import comciudad.dona.dtos.RolDTO;
import comciudad.dona.entity.Role;
public class RolCoverters extends AbstractConverter<Role, RolDTO> {
	@Override
	public RolDTO fromEntity(Role entity) {
		if(entity==null) return null; 
        return RolDTO.builder()
                .id(entity.getId())
                .nombre(entity.getName())
                .build(); 
	}
	@Override
	public Role fromDTO(RolDTO dto) {
		if(dto==null) return null; 
		Role cat=new Role();
		cat.setId(dto.getId());
		cat.setName(dto.getNombre());
		return cat;
	}

}
