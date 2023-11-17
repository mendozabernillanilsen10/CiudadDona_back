package comciudad.dona.converters;
import comciudad.dona.dtos.AddressDTO; 
import comciudad.dona.dtos.CompanyDTO;
import comciudad.dona.dtos.PesonDTO;
import comciudad.dona.dtos.PhoneDTO;
import comciudad.dona.dtos.RolDTO;
import comciudad.dona.dtos.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngresosResponse {
	private UsuarioDTO usuario;
	private String token;
	private PesonDTO persona;
	private RolDTO role;
	private PhoneDTO phone  ;
	private  AddressDTO Addres;
	private CompanyDTO Empresa;
	

	
}
