package comciudad.dona.validadors;

import comciudad.dona.entity.Responsible;
import comciudad.dona.exceptions.ValidateServiceException;

public class ResponsibleValid {
	public static void save(Responsible cate) {
		
		if( cate.getName()==null  ||  cate.getName().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre es requerido");
		}
		
		
	}
}
