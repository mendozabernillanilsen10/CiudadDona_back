package comciudad.dona.validadors;

import comciudad.dona.entity.Category;
import comciudad.dona.exceptions.ValidateServiceException;

public class categoriaValidador {

	public static void save(Category cate) {
		
		if( cate.getName()==null  ||  cate.getName().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre es requerido");
		}
		
		
	}
}
