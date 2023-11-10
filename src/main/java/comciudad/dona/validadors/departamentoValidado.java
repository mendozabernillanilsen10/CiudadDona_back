package comciudad.dona.validadors;
import comciudad.dona.entity.ubdepartamento;
import comciudad.dona.exceptions.ValidateServiceException;

public class departamentoValidado {
	public static void save(ubdepartamento de) {
		if(de.getNombre()==null || de.getNombre().trim().isEmpty()) {
			throw new ValidateServiceException("El email es requerido");
		}
		
	}
}
