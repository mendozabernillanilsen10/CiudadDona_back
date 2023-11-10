package comciudad.dona.converters;
import org.springframework.stereotype.Component; 

import comciudad.dona.dtos.CompanyDTO;
import comciudad.dona.entity.Company;
import comciudad.dona.entity.Person; 

@Component
public class companyConverters 
extends AbstractConverter<Company,CompanyDTO> {

	@Override
	public CompanyDTO fromEntity(Company entity) {
		if(entity==null) return null; 
		return CompanyDTO.builder()
				.id(entity.getId())
				.Razonocial(entity.getBusinessName())
				.Ruc(entity.getRuc())
				.Sucursal(entity.getBranch())
				.build(); 
	}
	@Override
	public Company fromDTO(CompanyDTO dto) {
		if(dto==null) return null; 
		Company compani=new Company();

		compani.setBusinessName(dto.getRazonocial());
		compani.setRuc(dto.getRuc());
		compani.setBranch(dto.getSucursal());
		return compani;
	}

}
