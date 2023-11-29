package comciudad.dona.converters;
import java.util.UUID;

import comciudad.dona.dtos.descripcionAguaDto;
import comciudad.dona.entity.ContainerType;
import comciudad.dona.entity.DescripcionAgua;
import comciudad.dona.entity.MedidasProducto;
import comciudad.dona.entity.Product;

public class DescripcionAguaConvertes extends AbstractConverter<DescripcionAgua,descripcionAguaDto> {
	
	
	
	
	
	@Override
	public descripcionAguaDto fromEntity(DescripcionAgua entity) {
		if (entity == null) return null;
		
		UUID  idProducto = 
	    		(entity.getProduct()!= null
	    		&& entity.getProduct().getId() != null)
	            ? entity.getProduct().getId()
	            : null;
		
		
		UUID  idEnbase = 
	    		(entity.getContainerType()!= null
	    		&& entity.getContainerType().getId() != null)
	            ? entity.getContainerType().getId()
	            : null;
		
		String Nombre_Envase = 
	    		(entity.getContainerType()!= null
	    		&& entity.getContainerType().getId() != null)
	            ? entity.getContainerType().getName()
	            : null;
		
		
		UUID  idMedidaEnbase = 
	    		(entity.getMedidasProducto()!= null
	    		&& entity.getMedidasProducto().getId() != null)
	            ? entity.getMedidasProducto().getId()
	            : null;
		
		
		String   nombrMedida = 
	    		(entity.getMedidasProducto()!= null
	    		&& entity.getMedidasProducto().getId() != null)
	            ? entity.getMedidasProducto().getNombre()
	            : null;
		return descripcionAguaDto.builder()
				.id(entity.getId())
				.stok(entity.getStock())
				.id_Envase(idEnbase)
				.tipo_ensabase(Nombre_Envase)
				.idProducto(idProducto)
				.idmedidaProducto(idMedidaEnbase)
				.NombreMedida(nombrMedida)
				.unidadPaquete(entity.getUnidadPaquete())
				.price(entity.getPrice())
				.activo(entity.getActivo())
				.unidadMedida(entity.getUnidadMedida())
				.detalleenvase(entity.getDetalleEnbase())
				.build();
	}
	@Override
	public DescripcionAgua fromDTO(descripcionAguaDto dto) {

		if (dto==null) return null;
		DescripcionAgua objet=new DescripcionAgua();
		objet.setId(dto.getId());
		objet.setStock(dto.getStok());
		objet.setUnidadMedida(dto.getUnidadMedida());
		objet.setUnidadPaquete(dto.getUnidadPaquete());
		objet.setPrice(dto.getPrice());
		objet.setActivo(dto.getActivo());
		objet.setDetalleEnbase(dto.getDetalleenvase());
		Product product = new Product();
		product.setId(dto.getIdProducto());
		ContainerType containerType = new ContainerType();
		containerType.setId(dto.getId_Envase());
		MedidasProducto medidasProducto = new MedidasProducto();
		medidasProducto.setId(dto.getIdmedidaProducto());
		objet.setMedidasProducto(medidasProducto);
		objet.setContainerType(containerType);
		objet.setProduct(product);
		return objet;

	}

}
