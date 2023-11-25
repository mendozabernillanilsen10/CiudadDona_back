package comciudad.dona.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import comciudad.dona.entity.DescripcionAgua;

public interface MineralWaterRepository extends JpaRepository<DescripcionAgua, UUID> {

}
