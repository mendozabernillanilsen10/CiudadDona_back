package comciudad.dona.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comciudad.dona.entity.Role;

@Repository

public interface RolRepository extends JpaRepository<Role,UUID> {
	List<Role> findByNameContaining(String razonSocial, Pageable page);
	
	
	
}

