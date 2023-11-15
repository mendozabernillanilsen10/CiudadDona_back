package comciudad.dona.dtos;
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
public class paisDTO {
		private int id;
		private String nombre ;
		private String foto_url; 

}
