package comciudad.dona.converters;


import comciudad.dona.dtos.UserDto;
import comciudad.dona.entity.User;

public class UserConvertes  extends AbstractConverter<User,UserDto>  {

	@Override
	public UserDto fromEntity(User entity) {
		if(entity==null) return null; 
		return UserDto.builder()
				.id(entity.getId())
				.Email(entity.getUsername())
				.build();
	}

	@Override
	public User fromDTO(UserDto dto) {
		if(dto==null) return null; 
		User p=new User();
		p.setId(dto.getId());
		p.setUsername(dto.getEmail());
		return p;
	}
}
