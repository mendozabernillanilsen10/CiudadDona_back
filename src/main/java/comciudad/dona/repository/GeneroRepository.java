package comciudad.dona.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import comciudad.dona.entity.Genero;
public interface GeneroRepository extends  JpaRepository<Genero, UUID>{


}
