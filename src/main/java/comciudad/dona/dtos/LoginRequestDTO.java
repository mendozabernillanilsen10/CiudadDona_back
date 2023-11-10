package comciudad.dona.dtos;

import java.util.UUID; 

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {
	private String email;
	private String password;
	private UUID idRol;
}
