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
public class ContainerTypeDTO {
	private UUID id;
	private String nombre ;
	private UUID idCategoria;
}
