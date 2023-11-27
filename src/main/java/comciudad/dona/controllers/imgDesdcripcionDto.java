package comciudad.dona.controllers;
import java.io.Serializable;
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
public class imgDesdcripcionDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UUID id;
    private String fotoBase64;
	private UUID iddetalle;

}
