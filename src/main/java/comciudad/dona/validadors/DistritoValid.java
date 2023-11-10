package comciudad.dona.validadors;

import comciudad.dona.entity.ubdistrito;
import comciudad.dona.exceptions.ValidateServiceException;

public class DistritoValid {
	public static void save(ubdistrito d) {
		if(d.getNombre()==null || d.getNombre().trim().isEmpty()) {
			throw new ValidateServiceException("El email es requerido");
		}
		
	}
}
