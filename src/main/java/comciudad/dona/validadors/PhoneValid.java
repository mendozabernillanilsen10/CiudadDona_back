package comciudad.dona.validadors;
import comciudad.dona.entity.Phone;
import comciudad.dona.exceptions.ValidateServiceException;
public class PhoneValid {
	public static void save(Phone phone) {
		if(phone.getCelular()==null || phone.getCelular().trim().isEmpty()) {
			throw new ValidateServiceException("El email es requerido");
		}
		
		
		
	}
}
