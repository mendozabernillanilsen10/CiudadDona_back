package comciudad.dona.service.impl;

import java.util.List; 
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import comciudad.dona.entity.Timetable;
import comciudad.dona.entity.User;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.TimetableRepository;
import comciudad.dona.service.TimetableService;
import comciudad.dona.validadors.TimetableValid;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TimetableServiceImplements implements TimetableService {
	@Autowired
	TimetableRepository repository;

	@Override
	public List<Timetable> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Timetable findById(UUID id) {

		return null;
	}

	@Override
	public Timetable save(Timetable horario) {
		try {
			TimetableValid.save(horario); 
			if(horario.getId()==null) {
				Timetable nuevoRegistro= repository.save(horario); 
				return nuevoRegistro;
		}
			Timetable existeRegistro= repository.findById(horario.getId())
					.orElseThrow(()->new NoDataFoundException("No Existe el Registro phpne"));
			existeRegistro.setApertura(horario.getApertura());
			existeRegistro.setCierre(horario.getApertura());
			existeRegistro.setId(horario.getId());
			repository.save(existeRegistro); 
			return existeRegistro;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	public void delete(UUID id) {

	}

	@Override
	public Timetable finByIdUser(User idUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
