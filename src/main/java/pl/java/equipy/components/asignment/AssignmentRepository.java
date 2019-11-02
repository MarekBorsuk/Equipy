package pl.java.equipy.components.asignment;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository  extends JpaRepository<Assignment, Long>{
	Optional<Assignment> findByAsset_IdAndEndIsNull(Long assedId);
}
