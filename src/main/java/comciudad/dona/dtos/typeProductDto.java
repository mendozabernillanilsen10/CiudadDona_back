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
public class typeProductDto {
	private UUID id;
    private String typeProduc; // Cambiado a typeProduc para que coincida con el JSON
}
