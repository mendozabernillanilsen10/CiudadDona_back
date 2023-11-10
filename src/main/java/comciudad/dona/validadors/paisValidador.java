package comciudad.dona.validadors;

import comciudad.dona.entity.Pais;
import comciudad.dona.exceptions.ValidateServiceException;

public class paisValidador {
	public static void save(Pais usuario) {
		if(usuario.getNombre()==null || usuario.getNombre().trim().isEmpty()) {
			throw new ValidateServiceException("El email es requerido");
		}
		
	}
}
