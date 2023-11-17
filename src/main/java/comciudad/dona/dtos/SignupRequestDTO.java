package comciudad.dona.dtos;

import comciudad.dona.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequestDTO {
	private String email;
	private String password;
	private Role role;

}
