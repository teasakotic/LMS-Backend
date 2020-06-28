package backend.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend.app.model.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
	@Query("SELECT a FROM Administrator a WHERE a.registrovaniKorisnik.username = ?1")
	Optional<Administrator> getByUsername(String username);
}
