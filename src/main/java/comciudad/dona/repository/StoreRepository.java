package comciudad.dona.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import comciudad.dona.entity.Store;
import comciudad.dona.entity.Subcategory;

public interface StoreRepository extends JpaRepository<Store, UUID> {

	List<Store> findByidDistritoId(Long idDistrito);

	  @Query("SELECT s FROM Store s " +
	            "JOIN CategoriStore cs ON s.id = cs.store.id " +
	            "JOIN SubCategoriStore scs ON cs.id = scs.idcategorystore.id " +
	            "WHERE s.idDistrito.id = :p_id_distrito " +
	            "AND cs.category.id = :p_id_categoria " +
	            "AND scs.subcategory.id = :p_id_subcategoria")
	    List<Store> obtenerTiendasPorDistritoYCategoria(
	            @Param("p_id_distrito") Long pIdDistrito,
	            @Param("p_id_categoria") UUID pIdCategoria,
	            @Param("p_id_subcategoria") UUID pIdSubcategoria);
	
	  @Query("SELECT DISTINCT sc FROM Store s " +
	            "JOIN CategoriStore cs ON s.id = cs.store.id " +
	            "JOIN SubCategoriStore scs ON cs.id = scs.idcategorystore.id " +
	            "JOIN Subcategory sc ON scs.subcategory.id = sc.id " +
	            "WHERE s.idDistrito.id = :p_id_distrito " +
	            "AND cs.category.id = :p_id_categoria")
	    List<Subcategory> obtenerSubcategoriasPorTiendaDistritoYCategoria(
	            @Param("p_id_distrito") Long pIdDistrito,
	            @Param("p_id_categoria") UUID pIdCategoria);
	  
	  @Query("SELECT s FROM Store s " +
	            "JOIN CategoriStore cs ON s.id = cs.store.id " +
	            "LEFT JOIN SubCategoriStore scs ON cs.id = scs.idcategorystore.id " +
	            "WHERE s.idDistrito.id = :p_id_distrito " +
	            "AND cs.category.id = :p_id_categoria " +
	            "AND scs.id IS NULL")
	    List<Store> obtenerTiendasPorDistritoYCategoria(
	            @Param("p_id_distrito") Long pIdDistrito,
	            @Param("p_id_categoria") UUID pIdCategoria);

}
