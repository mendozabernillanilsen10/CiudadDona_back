package comciudad.dona.dtos;
import java.util.UUID;
import comciudad.dona.entity.Category;
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
public class SubCategoryDTO {
	private UUID id;
	private String nombre ;
	private UUID categoriaId;
}
