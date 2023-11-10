package comciudad.dona.converters;

import comciudad.dona.dtos.SignupRequestDTO;
import comciudad.dona.dtos.UsuarioDTO; 
import comciudad.dona.entity.User;
 
public class UsuarioConverter extends AbstractConverter<User, UsuarioDTO> {

	@Override
	public UsuarioDTO fromEntity(User entity) {
		if (entity==null) return null;
		return UsuarioDTO.builder()
				.id(entity.getId())
				.email(entity.getUsername())
				.activo(entity.getActivo())
				.build();
	}

	@Override
	public User fromDTO(UsuarioDTO dto) {
		if (dto==null) return null;
		return User.builder()
				.id(dto.getId())
				.username(dto.getEmail())
				.activo(dto.getActivo())
				.build();
	}
	
	public User signup(SignupRequestDTO dto) {
		return User.builder()
				.username(dto.getEmail())
				.password(dto.getPassword())
				.role(dto.getRole())
				.build();
	}
}
