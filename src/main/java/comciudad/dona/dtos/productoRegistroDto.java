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

public class productoRegistroDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UUID id;
    private String Short_Description;
	private String cualidad;
	private UUID id_tipoproducto;
	private String  nombreTipoProd;
    private UUID idMarca;
    private String nombreMarca;
    private String fotoPrincipalBase64;
    private UUID id_tienda;
    private Boolean activo;
    private List<UnidadMedidaDto> unidadMedida;
    
    
    
    
    
}
