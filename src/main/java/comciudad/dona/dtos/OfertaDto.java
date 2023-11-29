package comciudad.dona.dtos;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
public class OfertaDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UUID id;
	private UUID id_des;
    private String nombre;
    private Double price;
    private BigDecimal cantidad;
    private Date fechaIncio;
    private Date fechafin;
    private Boolean activo;
 
}
