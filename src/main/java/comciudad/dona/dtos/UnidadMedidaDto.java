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

public class UnidadMedidaDto {
	private UUID id;
	private String medida;
	private UUID idProducto;
	private List<MedidasProductoDTO> MedidadProducto;
}
