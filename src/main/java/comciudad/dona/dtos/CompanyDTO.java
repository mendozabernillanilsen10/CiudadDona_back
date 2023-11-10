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
public class CompanyDTO {
	private UUID id;
	private String Razonocial ;
	private String Ruc;
	private String Sucursal;
	private int personaId;
	
	
	

}
