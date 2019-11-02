package pl.java.equipy.components.assets;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AssetRepository extends JpaRepository<Asset, Long> {

	@Query("select a from Asset a where lower(a.name) like lower(concat('%',:search,'%'))"+ 
			"or lower(a.serialNumber) like lower(concat('%',:search,'%'))")
	List<Asset> findAllByNameOrSerialNumber(@Param("search")String search);
	
	Optional<Asset> findBySerialNumber(String serialNumber);
}
