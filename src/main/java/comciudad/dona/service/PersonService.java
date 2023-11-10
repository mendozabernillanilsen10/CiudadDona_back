package comciudad.dona.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;

import comciudad.dona.entity.Pais;
import comciudad.dona.entity.Person;
import comciudad.dona.entity.User;
import comciudad.dona.entity.ubdepartamento;
import comciudad.dona.entity.ubprovincia;

public interface PersonService {
	public List<Person > findAll(Pageable page);
	public List<Person> finByNombre(String nombre,Pageable page);
	public Person findById(UUID id);
	public Person save(Person articulo);
	public void delete(UUID id);
	public Person findByidUser(User p);


}
