package comciudad.dona.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import comciudad.dona.entity.Person;
import comciudad.dona.entity.User;

public interface personRepository  extends JpaRepository<Person ,UUID>{
	
	public Person findByidUser(User p);
	public Person findByDNI(String DNI);
	

}
