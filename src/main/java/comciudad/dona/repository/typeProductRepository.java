package comciudad.dona.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import comciudad.dona.entity.typeProduct;

public interface typeProductRepository extends JpaRepository<typeProduct, UUID >{

}
