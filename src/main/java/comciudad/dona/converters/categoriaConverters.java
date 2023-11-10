package comciudad.dona.converters;
 
import comciudad.dona.dtos.CategoriaDTO;
import comciudad.dona.entity.Category;

public class categoriaConverters extends AbstractConverter<Category,CategoriaDTO>  {

	@Override
	public CategoriaDTO fromEntity(Category entity) {
		if(entity==null) return null; 
        return CategoriaDTO.builder()
                .id(entity.getId())
                .nombre(entity.getName())
                .foto_url(entity.getFoto_url()) // Cambiado de "Nombre" a "nombre"
                .activo(entity.getActivo())
                .build(); 
	}

	@Override
	public Category fromDTO(CategoriaDTO dto) {
		if(dto==null) return null; 
		Category cat=new Category();
		cat.setId(dto.getId());
		cat.setName(dto.getNombre());
		cat.setFoto_url(dto.getFoto_url());
		return cat;
	}
	

}
