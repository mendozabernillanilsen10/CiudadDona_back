package comciudad.dona.dtos;
import java.math.BigDecimal; 
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
public class OfertaDto {
	private UUID id;
	private UUID idDescripcion;

    private String nombre;
    private Double price;
    private BigDecimal cantidad;
    private String fechaIncio;
    private String fechafin;
    private Boolean activo;
}
