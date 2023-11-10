package comciudad.dona.validadors;

import comciudad.dona.entity.Company;    
import comciudad.dona.exceptions.ValidateServiceException;

public class CompanyValidador {
	public static void save(Company c) {
		
		if(c.getBusinessName() == null ||  c.getBusinessName().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre es requerido");

		}
		
		if(c.getBusinessName().length()>150) {
			throw new ValidateServiceException("El Razon Social  es muy largo (máximo 150)");
		}
		
		if(c.getRuc()==null) {
			throw new ValidateServiceException("El RUC  es requerido");
		}
		if(c.getRuc().length()>11) {
			throw new ValidateServiceException("RUC es muy largo (máximo 12)");
		}
	}
}
