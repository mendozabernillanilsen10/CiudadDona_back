package comciudad.dona.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import comciudad.dona.controllers.imgDesdcripcionDto;
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
    private UUID id_Envase;
    private int stok;
    private int unidadPaquete;
    private UUID tipoenbase;// containertype
    private UUID idmedidaProducto;
    private Double price;
    private String  unidadMedida;
    private String detalleenvase;
    private List<OfertaDto>oferta;
    private List<imgDesdcripcionDto> imgDesdcripcion;
}
