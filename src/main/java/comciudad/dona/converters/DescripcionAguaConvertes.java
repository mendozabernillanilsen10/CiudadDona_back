package comciudad.dona.converters;
import java.util.UUID; 

import comciudad.dona.dtos.descripcionAguaDto;
import comciudad.dona.entity.ContainerType;
import comciudad.dona.entity.DescripcionAgua;
import comciudad.dona.entity.MedidasProducto;
import comciudad.dona.entity.Product;
import comciudad.dona.entity.UnidadMedida;

public class DescripcionAguaConvertes extends AbstractConverter<DescripcionAgua,descripcionAguaDto> {

	@Override
	public descripcionAguaDto fromEntity(DescripcionAgua entity) {
		if (entity == null) return null;
		UUID  id_producto = 
	    		(entity.getProduct()!= null
	    		&& entity.getProduct().getId() != null)
	            ? entity.getProduct().getId()
	            : null;
		UUID unidadMendida = 
	    		(entity.getUnidadMedida()!= null
	    		&& entity.getUnidadMedida().getId() != null)
	            ? entity.getUnidadMedida().getId()
	            : null;

		
		UUID  idMedidaEnbase = 
	    		(entity.getMedidasProducto()!= null
	    		&& entity.getMedidasProducto().getId() != null)
	            ? entity.getMedidasProducto().getId()
	            : null;
		UUID   id_contariner = 
	    		(entity.getContainerType()!= null
	    		&& entity.getContainerType().getId() != null)
	            ? entity.getContainerType().getId()
	            : null;
		return descripcionAguaDto.builder()
				.id(entity.getId())
				.activo(entity.getActivo())
				.price(entity.getPrice())
				.DetalleEnbase(entity.getDetalleEnbase())
				.id_product(id_producto)
				.id_unidadMedida(unidadMendida)
				.id_medidasProducto(idMedidaEnbase)
				.idcontainerType(id_contariner)
				.build();
	}
	@Override
	public DescripcionAgua fromDTO(descripcionAguaDto dto) {
		if (dto==null) return null;
		DescripcionAgua objet=new DescripcionAgua();
		
		ContainerType containerType  = new ContainerType();
		containerType.setId(dto.getIdcontainerType());
		MedidasProducto medidasProducto= new MedidasProducto();
		medidasProducto.setId(dto.getId_medidasProducto());
		UnidadMedida unidadMedida = new UnidadMedida();
		unidadMedida.setId(dto.getId_unidadMedida());
		
		
		Product Product =new  Product();
		Product.setId(dto.getId_product());
		
		objet.setActivo(dto.getActivo());
		objet.setPrice(dto.getPrice());
		objet.setStock(dto.getStock());
		objet.setUnidadPaquete(dto.getUnidadPaquete());
		
		objet.setDetalleEnbase(dto.getDetalleEnbase());	
		objet.setProduct(Product);
		objet.setUnidadMedida(unidadMedida);
		objet.setMedidasProducto(medidasProducto);
		objet.setContainerType(containerType);
		return objet;
		
		
	}

}
