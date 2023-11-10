package comciudad.dona.converters;
import comciudad.dona.dtos.PhoneDTO;  
import comciudad.dona.entity.Phone;
import comciudad.dona.entity.User;
public class PhoneConverters extends AbstractConverter<Phone , PhoneDTO>{

	@Override
	public PhoneDTO fromEntity(Phone entity) {
		if(entity==null) return null; 
		return PhoneDTO.builder()
				.id(entity.getId())
				.numero_celular(entity.getCelular())
				.numero_whatsapp(entity.getWhatsapp())
				.build();
	}
	
	@Override
	public Phone fromDTO(PhoneDTO dto) {
		if(dto==null) return null; 
		Phone p=new Phone();
		User per = new User();

		
		p.setId(dto.getId());
		p.setIdUser(per);
		p.setCelular(dto.getNumero_celular());
		p.setWhatsapp(dto.getNumero_whatsapp());
		return p;
	}

	

}
