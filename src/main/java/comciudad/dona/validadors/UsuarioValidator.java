package comciudad.dona.validadors;

import comciudad.dona.entity.User;  
import comciudad.dona.exceptions.ValidateServiceException;

public class UsuarioValidator {
	public static void save(User usuario) {
		if(usuario.getUsername()==null || usuario.getUsername().trim().isEmpty()) {
			throw new ValidateServiceException("El email es requerido");
		}
		if(usuario.getPassword()==null || usuario.getPassword().trim().isEmpty()) {
			throw new ValidateServiceException("El password es requerido");
		}
	}
}
