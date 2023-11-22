package comciudad.dona.converters;
import comciudad.dona.dtos.ContainerTypeDTO;
import comciudad.dona.entity.Category;
import comciudad.dona.entity.ContainerType;

public class ContainerTypeConverter  extends  AbstractConverter<ContainerType , ContainerTypeDTO>{
	@Override
	public ContainerTypeDTO fromEntity(ContainerType entity) {
		if (entity == null) return null;
		return ContainerTypeDTO.builder()
				.id(entity.getId())
				.idCategoria(entity.getCategory().getId())
				.nombre(entity.getName())
				.build();
	}
	@Override
	public ContainerType fromDTO(ContainerTypeDTO dto) {
		if (dto==null) return null;
		ContainerType objet=new ContainerType();
		objet.setName(dto.getNombre());
		objet.setId(dto.getId());
		Category categori = new Category();
		categori.setId(dto.getIdCategoria());
		objet.setCategory(categori);
		return objet;
	}

}
