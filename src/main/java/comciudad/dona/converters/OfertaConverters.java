package comciudad.dona.converters;

import java.util.UUID;

import comciudad.dona.dtos.OfertaDto;
import comciudad.dona.entity.DescripcionAgua;
import comciudad.dona.entity.Oferta;
public class OfertaConverters  extends AbstractConverter<Oferta,OfertaDto>{
	@Override
	public OfertaDto fromEntity(Oferta entity) {
		if (entity == null) return null;
		UUID  idMedides = 
	    		(entity.getDescripcionAgua()!= null
	    		&& entity.getDescripcionAgua().getId() != null)
	            ? entity.getDescripcionAgua().getId()
	            : null;
		return OfertaDto.builder()
				 	.id(entity.getId())
	                .cantidad(entity.getCantidad())
	                .price(entity.getPrice())
	                .nombre(entity.getNombre())
	                .id_des(idMedides)
	                .fechaIncio(entity.getFechaIncio())
	                .fechafin(entity.getFechafin())
	                .activo(entity.getActivo())
	                .build();
	}
	
	@Override
	public Oferta fromDTO(OfertaDto dto) {
		if (dto == null) return null;
        Oferta oferta = new Oferta();
        oferta.setId(dto.getId());
        oferta.setNombre(dto.getNombre());
        oferta.setPrice(dto.getPrice());
        oferta.setActivo(dto.getActivo());
        oferta.setCantidad(dto.getCantidad());
        DescripcionAgua descripcionAgua = new DescripcionAgua();
        descripcionAgua.setId(dto.getId_des());
        oferta.setFechaIncio(dto.getFechaIncio());
        oferta.setFechafin(dto.getFechafin());
        oferta.setDescripcionAgua(descripcionAgua);
		return oferta;
	}
}
