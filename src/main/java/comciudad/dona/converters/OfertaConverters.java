package comciudad.dona.converters;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import comciudad.dona.dtos.OfertaDto;
import comciudad.dona.entity.DescripcionAgua;
import comciudad.dona.entity.Oferta;
public class OfertaConverters  extends AbstractConverter<Oferta,OfertaDto>{
    private static final DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	@Override
	public OfertaDto fromEntity(Oferta entity) {
		if (entity == null) return null;
		return OfertaDto.builder()
				 	.id(entity.getId())
	                .fechaIncio(String.valueOf(entity.getFechaIncio()))
	                .fechafin(String.valueOf(entity.getFechafin()))
	                .cantidad(entity.getCantidad())
	                .price(entity.getPrice())
	                .nombre(entity.getNombre())
	               // .idDescripcion(entity.getDescripcionAgua().getId())
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
        descripcionAgua.setId(dto.getIdDescripcion());
        oferta.setFechaIncio(LocalDateTime.parse(dto.getFechaIncio(), dateTimeFormat));
        oferta.setFechafin(LocalDateTime.parse(dto.getFechafin(), dateTimeFormat));
		return oferta;
	}
}
