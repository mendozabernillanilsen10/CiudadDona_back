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
public class CategoriaStoreDTO  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UUID Id_categoria;
    private List<SubCategoriatoreDTO> subCategorias;
}
