package comciudad.dona.dtos;

import java.sql.Date;
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
public class PesonDTO {
	private UUID PersonID;
	private String nombre ;
	private String apellido;
	private String DNI; 
	private Boolean state;
	private String Date_of_Birth;
	
	
}
