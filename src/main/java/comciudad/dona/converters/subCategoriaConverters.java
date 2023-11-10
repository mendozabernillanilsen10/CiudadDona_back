package comciudad.dona.converters;
import comciudad.dona.dtos.SubCategoryDTO;
import comciudad.dona.entity.Category;
import comciudad.dona.entity.Subcategory;
public class subCategoriaConverters extends AbstractConverter<Subcategory,SubCategoryDTO> {
    @Override
    public SubCategoryDTO fromEntity(Subcategory entity) {
        if (entity == null) return null;
        return SubCategoryDTO.builder()
                .id(entity.getId())
                .nombre(entity.getName())
                .categoriaId(entity.getCategory().getId())
                .build();         
    }
	@Override
	public Subcategory fromDTO(SubCategoryDTO dto) {
		if(dto==null) return null; 
		Subcategory subcat=new Subcategory();
		Category cat = new Category() ;
		cat.setId(dto.getCategoriaId());
		subcat.setCategory(cat);
		subcat.setId(dto.getId());
		subcat.setName(dto.getNombre());
		return subcat;
	}

}
