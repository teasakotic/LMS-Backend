package backend.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend.app.model.LicniPodaci;

@Repository
public interface LicniPodaciRepository extends JpaRepository<LicniPodaci, Long> {
	@Query("SELECT p FROM LicniPodaci p WHERE p.putanjaProfilneSlike LIKE ?1")
	Optional<LicniPodaci> getByUsername(String username);
}