package comciudad.dona.validadors;
import comciudad.dona.entity.Subcategory;
import comciudad.dona.exceptions.ValidateServiceException;
public class SubCategoriavalidad {
	public static void save(Subcategory sub) {
		if(sub.getName()==null || sub.getName().trim().isEmpty()) {
			throw new ValidateServiceException("nombre requerido");
		}
		
	}
}
