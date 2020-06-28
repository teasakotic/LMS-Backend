package backend.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend.app.model.TerminNastave;

@Repository
public interface TerminNastaveRepository extends JpaRepository<TerminNastave, Long> {
	@Query("SELECT tt FROM  TerminNastave tt WHERE tt.realizacijaPredmeta.godinaStudija.id = ?1")
	Iterable<Optional<TerminNastave>> getByGodinaStudija(Long godinaStudijaId);
}
