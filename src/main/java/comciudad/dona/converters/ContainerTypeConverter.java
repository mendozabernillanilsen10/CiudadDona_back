package comciudad.dona.converters;
import comciudad.dona.dtos.ContainerTypeDTO; 
import comciudad.dona.entity.ContainerType;
import comciudad.dona.entity.typeProduct;

public class ContainerTypeConverter  extends  AbstractConverter<ContainerType , ContainerTypeDTO>{
	@Override
	public ContainerTypeDTO fromEntity(ContainerType entity) {
		if (entity == null) return null;
		return ContainerTypeDTO.builder()
				.id(entity.getId())
				.idtype(entity.getTypeProduct().getId())
				.nombre(entity.getName())
				.build();
	}
	@Override
	public ContainerType fromDTO(ContainerTypeDTO dto) {
		if (dto==null) return null;
		ContainerType objet=new ContainerType();
		objet.setName(dto.getNombre());
		objet.setId(dto.getId());
		typeProduct typeProduct = new typeProduct();
		typeProduct.setId(dto.getIdtype());
		objet.setTypeProduct(typeProduct);
		return objet;
	}

}
