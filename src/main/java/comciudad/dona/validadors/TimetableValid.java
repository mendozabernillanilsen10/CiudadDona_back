package comciudad.dona.validadors;
import comciudad.dona.entity.Timetable;
import comciudad.dona.exceptions.ValidateServiceException;
public class TimetableValid {
	public static void save(Timetable horario) {
		if(horario.getApertura()==null ) {
			throw new ValidateServiceException("Ingrese horas de entrada ");
		}
		if(horario.getCierre()==null ) {
			throw new ValidateServiceException("Ingrese horas de cierre ");
		}
	}
}
