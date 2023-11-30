package comciudad.dona.dtos;

import java.io.Serializable; 
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

public class descripcionAguaDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UUID  id;
	int stock;
	int unidadPaquete;
	private UUID idcontainerType;
	private UUID id_medidasProducto;
	private UUID id_unidadMedida;
	private UUID id_product ;
	private Double price; 
	private String DetalleEnbase; 
	private List<OfertaDto>oferta;
	private Boolean activo;
    private List<imgDesdcripcionDto> imgDesdcripcion;
}
