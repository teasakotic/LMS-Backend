package backend.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import backend.app.model.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
	@Query("SELECT f FROM File f WHERE f.nastavniMaterijal.realizacijaPredmeta.predmet.id = ?1")
	Iterable<Optional<File>> getAllByPredmet(Long id);
}
