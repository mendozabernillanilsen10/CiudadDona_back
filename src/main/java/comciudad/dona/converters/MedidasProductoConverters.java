package comciudad.dona.converters;
import comciudad.dona.dtos.MedidasProductoDTO; 
import comciudad.dona.entity.MedidasProducto;


public class MedidasProductoConverters extends AbstractConverter<MedidasProducto, MedidasProductoDTO> {

	@Override
	public MedidasProductoDTO fromEntity(MedidasProducto entity) {
		if (entity == null)
			return null;
		return MedidasProductoDTO.builder().id(entity.getId()).nombre(entity.getNombre()).build();
	}

	@Override
	public MedidasProducto fromDTO(MedidasProductoDTO dto) {
		if (dto == null)
			return null;
		MedidasProducto objet = new MedidasProducto();
		objet.setNombre(dto.getNombre());
		objet.setId(dto.getId());

		return objet;
	}

}
