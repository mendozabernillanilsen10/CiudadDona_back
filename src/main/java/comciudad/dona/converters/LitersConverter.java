package comciudad.dona.converters;
import comciudad.dona.entity.liters;
import comciudad.dona.dtos.LitersDTo;

public class LitersConverter extends AbstractConverter<liters,LitersDTo>{
	@Override
	public LitersDTo fromEntity(liters entity) {
		if (entity == null) return null;
		return LitersDTo.builder()
				.id(entity.getId())
				.cantidad(entity.getCantidad())
				.build();
	}
	
	 @Override
	    public liters fromDTO(LitersDTo dto) {
	        if (dto == null) return null;
	        liters objet = new liters();
	        objet.setCantidad(dto.getCantidad()); // Usar dto.getCantidad() en lugar de objet.getCantidad()
	        objet.setId(dto.getId()); // Similar para el ID
	        return objet;
	    }
	

}
