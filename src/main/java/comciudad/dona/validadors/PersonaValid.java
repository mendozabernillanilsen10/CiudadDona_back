package comciudad.dona.validadors;

import comciudad.dona.entity.Person;
import comciudad.dona.exceptions.ValidateServiceException;

public class PersonaValid {
	public static void save(Person persona) {
		if(persona.getName()==null || persona.getName().trim().isEmpty()) {
			throw new ValidateServiceException("Nombre requerido ");
		}

	/*	if(persona.getDNI().length()>0 && persona.getDNI().length()<8) {
			throw new ValidateServiceException("Verefique su Dni ");
		}*/
	}
}
