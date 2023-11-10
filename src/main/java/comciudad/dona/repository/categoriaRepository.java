package comciudad.dona.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import comciudad.dona.entity.Category;

public interface categoriaRepository extends JpaRepository<Category,UUID> {
	List<Category> findByNameContaining(String razonSocial, Pageable page);



}