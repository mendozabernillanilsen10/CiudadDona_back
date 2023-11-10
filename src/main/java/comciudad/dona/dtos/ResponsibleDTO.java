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
public class ResponsibleDTO {
	private UUID id;
	private String nombre ;
	private String apellido;
	private String celular;
	private String whatsapp;
}
