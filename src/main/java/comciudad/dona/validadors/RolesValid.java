package comciudad.dona.validadors;

import comciudad.dona.entity.Role;
import comciudad.dona.exceptions.ValidateServiceException;

public class RolesValid {
	public static void save(Role usuario) {
		if(usuario.getName()==null || usuario.getName().trim().isEmpty()) {
			throw new ValidateServiceException("El email es requerido");
		}
		
	}
	
	
}
