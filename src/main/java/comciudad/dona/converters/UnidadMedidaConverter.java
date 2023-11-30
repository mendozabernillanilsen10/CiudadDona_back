package comciudad.dona.converters;

import java.util.UUID;
import comciudad.dona.dtos.UnidadMedidaDto;
import comciudad.dona.entity.Product;
import comciudad.dona.entity.UnidadMedida;

public class UnidadMedidaConverter extends AbstractConverter<UnidadMedida, UnidadMedidaDto> {

	@Override
	public UnidadMedidaDto fromEntity(UnidadMedida entity) {
		if (entity == null) {
			return null;
		}

		return UnidadMedidaDto.builder()
				.id(entity.getId())
				.medida(entity.getMedida())
				.build();
	}
	@Override
	public UnidadMedida fromDTO(UnidadMedidaDto dto) {
		if (dto == null)
			return null;
		UnidadMedida cat = new UnidadMedida();
		cat.setId(dto.getId());
		cat.setMedida(dto.getMedida());
		Product product = new Product();
		product.setId(dto.getId());
		return cat;
	}

}
