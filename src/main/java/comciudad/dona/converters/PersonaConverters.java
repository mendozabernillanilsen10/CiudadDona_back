package comciudad.dona.converters;
import comciudad.dona.dtos.PesonDTO;
import comciudad.dona.entity.Person;

public class PersonaConverters  extends AbstractConverter<Person , PesonDTO>{

	@Override
	public PesonDTO fromEntity(Person entity) {
		if(entity==null) return null; 
		return PesonDTO.builder()
				.PersonID(entity.getId())
				.nombre(entity.getName())
				.apellido(entity.getSurName())
				.Date_of_Birth(String.valueOf(entity.getDate_of_Birth()))
				.state(entity.getState())
				.DNI(entity.getDNI())
				.build();
	}

	@Override
	public Person fromDTO(PesonDTO dto) {
		if(dto==null) return null; 
		Person per = new Person();
		per.setId(dto.getPersonID());
		per.setName(dto.getNombre());
		per.setSurName(dto.getApellido());
		per.setDNI(dto.getDNI());
		return per;
	}

}
