package backend.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import backend.app.model.Fajl;

@Repository
public interface FajlRepository extends JpaRepository<Fajl, Long> {
	@Query("SELECT f FROM Fajl f WHERE f.nastavniMaterijal.realizacijaPredmeta.predmet.id = ?1")
	Iterable<Optional<Fajl>> getAllByPredmet(Long id);
}
