package comciudad.dona.converters;
import comciudad.dona.dtos.AddressDTO;
import comciudad.dona.entity.Address;
import comciudad.dona.entity.ubdistrito;
public class AddressConverters extends AbstractConverter<Address,AddressDTO>  {
	@Override
	public AddressDTO fromEntity(Address entity) {
		if(entity==null) return null; 
        return AddressDTO.builder()
                .id(entity.getId())
                .Reference(entity.getReference())
                .street(entity.getStreet())
                .distrito(entity.getUbdistrito_Id().getNombre())
                .Id_Distrito(entity.getUbdistrito_Id().getId())
                .build(); 
	}

	@Override
	public Address fromDTO(AddressDTO dto) {
		if(dto==null) return null; 
		Address cat=new Address();
		ubdistrito d = new ubdistrito();
		d.setNombre(dto.getDistrito());
		cat.setId(dto.getId());
		cat.setReference(dto.getReference());
		cat.setStreet(dto.getStreet());
		cat.setUbdistrito_Id(d);

		return cat;
	}

}
