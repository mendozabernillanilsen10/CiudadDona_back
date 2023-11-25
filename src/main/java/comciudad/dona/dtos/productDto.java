package comciudad.dona.dtos;

import java.util.UUID; 

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
public class productDto  {
	private UUID id;
    private String Short_Description;
	private Boolean activo;
	private String Cualidad;
	private String fotoUrlPrincipal;
    private UUID idMarca;
    private String nombreMarca;

}
