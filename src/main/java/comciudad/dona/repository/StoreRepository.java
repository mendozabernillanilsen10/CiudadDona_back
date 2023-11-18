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

	@Query("SELECT s FROM Store s " + "WHERE s.idDistrito.id = :p_id_distrito " + "AND s.category.id = :p_id_categoria "
			+ "AND s.subcategory.id = :p_id_subcategoria")
	List<Store> obtenerTiendasPorDistritoYCategoria(@Param("p_id_distrito") Long pIdDistrito,
			@Param("p_id_categoria") UUID pIdCategoria, @Param("p_id_subcategoria") UUID pIdSubcategoria);

	@Query("SELECT DISTINCT sc FROM Store s " + "JOIN s.subcategory sc " + "WHERE s.idDistrito.id = :p_id_distrito "
			+ "AND s.category.id = :p_id_categoria")
	List<Subcategory> obtenerSubcategoriasPorTiendaDistritoYCategoria(@Param("p_id_distrito") Long pIdDistrito,
			@Param("p_id_categoria") UUID pIdCategoria);

	@Query("SELECT s FROM Store s " + "WHERE s.idDistrito.id = :p_id_distrito " + "AND s.category.id = :p_id_categoria "
			+ "AND (s.subcategory IS NULL OR s.subcategory.id IS NULL)")
	List<Store> obtenerTiendasPorDistritoYCategoria(@Param("p_id_distrito") Long pIdDistrito,
			@Param("p_id_categoria") UUID pIdCategoria);

}
