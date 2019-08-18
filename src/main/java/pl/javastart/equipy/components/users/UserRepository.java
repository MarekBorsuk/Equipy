package pl.javastart.equipy.components.users;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findAllByLastNameContainingIgnoreCase(String lastName);
	Optional<User> findByPesel(String pesel);
}
