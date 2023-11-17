package comciudad.dona.converters;
import comciudad.dona.dtos.SubCategoryDTO; 
import comciudad.dona.entity.Subcategory;
public class subCategoriaConverters extends AbstractConverter<Subcategory,SubCategoryDTO> {
    @Override
    public SubCategoryDTO fromEntity(Subcategory entity) {
        if (entity == null) return null;
        return SubCategoryDTO.builder()
                .id(entity.getId())
                .categoriaId(entity.getIdcategory().getId())
                .nombre(entity.getName())
                .build();   
       
    }
	@Override
	public Subcategory fromDTO(SubCategoryDTO dto) {
		if(dto==null) return null; 
		Subcategory subcat=new Subcategory();
		subcat.setId(dto.getId());
		subcat.setName(dto.getNombre());
		return subcat;
	}

}
