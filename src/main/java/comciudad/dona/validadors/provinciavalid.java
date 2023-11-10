package comciudad.dona.validadors;
import comciudad.dona.entity.ubprovincia;
import comciudad.dona.exceptions.ValidateServiceException;


public class provinciavalid {
	public static void save(ubprovincia usuario) {
		if(usuario.getNombre()==null || usuario.getNombre().trim().isEmpty()) {
			throw new ValidateServiceException("El email es requerido");
		}
		
	}
}
