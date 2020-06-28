package backend.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import backend.app.model.NastavniMaterijal;

@Repository
public interface NastavniMaterijalRepository extends JpaRepository<NastavniMaterijal, Long> {
	@Query("SELECT t FROM NastavniMaterijal t WHERE t.realizacijaPredmeta.predmet.id = ?1")
	Iterable<Optional<NastavniMaterijal>> getAllByPredmet(Long id);
}
