package comciudad.dona.repository;

import java.util.List; 
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import comciudad.dona.entity.Category;

import comciudad.dona.entity.CategoriStore;
@Repository
public interface CategoriStoreRepository extends  JpaRepository<CategoriStore,UUID> {
   
    @Query("SELECT DISTINCT c.category FROM CategoriStore c " +
            "JOIN c.store s " +
            "WHERE s.idDistrito.id = :idDistrito " +
            "AND s.activo = true")
    List<Category> findDistinctCategoriesByDistrito(@Param("idDistrito") Long idDistrito);
	
}