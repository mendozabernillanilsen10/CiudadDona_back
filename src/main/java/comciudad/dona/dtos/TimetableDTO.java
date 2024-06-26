package comciudad.dona.dtos;

import java.io.Serializable;   
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
public class TimetableDTO implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String apertura;
	private String cierre;

}
