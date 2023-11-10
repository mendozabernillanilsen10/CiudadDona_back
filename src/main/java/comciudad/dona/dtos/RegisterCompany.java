package comciudad.dona.dtos;
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
public class RegisterCompany {
	private UsuarioDTO usuario;
	private String token;
	private CompanyDTO Empresa;
	private RolDTO role;
	private PhoneDTO phone;
	private  AddressDTO Addres;
	private ResponsibleDTO responsable;
}