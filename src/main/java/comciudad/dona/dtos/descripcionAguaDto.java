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
	private UUID id;
	private UUID idProducto;
    private UUID id_Envase;
    private String tipo_ensabase;
    private int stok;
    private int unidadPaquete;
    private UUID idmedidaProducto;
    private String NombreMedida;
    
    private Double price;
    private String  unidadMedida;
    private String detalleenvase;
    private List<OfertaDto>oferta;
	private Boolean activo;
    private List<imgDesdcripcionDto> imgDesdcripcion;
}
