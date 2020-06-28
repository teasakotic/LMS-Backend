package backend.app.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend.app.model.Predmet;
import backend.app.model.StudijskiProgram;

@Repository
public interface StudijskiProgramRepository extends JpaRepository<StudijskiProgram, Long> {
	
	@Query("SELECT sp FROM StudijskiProgram sp, PohadjanjePredmeta sa WHERE AVG(sa.konacnaOcena) <= 7")
	Iterable<Predmet> findPredmetniKandidatZaUklanjanje(Long studijskiProgramId);
	ArrayList<StudijskiProgram> findByFakultetIdEquals(Long id);
}