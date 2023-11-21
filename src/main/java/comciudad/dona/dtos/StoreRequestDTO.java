package comciudad.dona.dtos;

import java.util.List; 
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
public class StoreRequestDTO {
	    private UUID id;
	    private String nombre;
	    private UUID categorId;
	    private UUID subcatId;
	    private UUID companId;
	    private Long idDistrito;
	    private List<TimetableDTO> horarios;
	    private List<CategoriaStoreDTO> categorias;

	    
}
