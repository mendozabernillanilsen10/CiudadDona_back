package comciudad.dona.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comciudad.dona.entity.*;
import org.springframework.data.domain.Pageable; 

@Repository
public interface companyrespository  extends JpaRepository<Company,UUID>   {
	List<Company> findByBusinessNameContaining(String  nombre, Pageable page);
	Company findByidUser(User idUser);
	
}
