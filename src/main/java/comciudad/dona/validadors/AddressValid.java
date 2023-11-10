package comciudad.dona.validadors;

import comciudad.dona.entity.Address;  
import comciudad.dona.exceptions.ValidateServiceException;

public class AddressValid {

	public static void save(Address a) {
		
		
		if( a.getIdUser() == null) {
			throw new ValidateServiceException("Error  ");

		}
		
		if(a.getReference() ==null ) {
			throw new ValidateServiceException("Capo reqerido ");

		}
		
		if( a.getStreet() == null ) {
			throw new ValidateServiceException("Capo reqerido ");

		}
		
	}
	
}
