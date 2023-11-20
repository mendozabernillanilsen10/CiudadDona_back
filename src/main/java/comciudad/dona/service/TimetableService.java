package comciudad.dona.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import comciudad.dona.entity.Timetable;
import comciudad.dona.entity.User;
@Service
public interface TimetableService {
	public List<Timetable> findAll();
	public Timetable findById(UUID id); 
	public Timetable save(Timetable horario); 
	public void delete(UUID id); 
	public Timetable finByIdUser(User idUser); 

}
