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
public class AddressDTO {
	private UUID id;
    private String Reference;
    private String  street; 
    private String distrito;
    private Long Id_Distrito;
}
