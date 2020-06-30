package backend.app.repository;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend.app.model.EvaluacijaZnanja;

@Repository
public interface EvaluacijaZnanjaRepository extends JpaRepository<EvaluacijaZnanja, Long> {
	@Query("SELECT sa.konacnaOcena, sa.realizacijaPredmeta.predmet.naziv, sa.realizacijaPredmeta.godinaStudija.godina, sa.realizacijaPredmeta.godinaStudija.studijskiProgram.naziv, er.bodovi, er.evaluacijaZnanja.vremePocetka, sa.realizacijaPredmeta.predmet.espb "
			+ "FROM Polaganje er, PohadjanjePredmeta sa "
			+ "WHERE sa.student.id = ?1 AND sa.konacnaOcena IS NOT NULL AND er.bodovi IS NOT NULL AND er.evaluacijaZnanja.tipEvaluacije.naziv = 'FINAL' "
			+ "AND sa.realizacijaPredmeta.id = er.evaluacijaZnanja.realizacijaPredmeta.id")
	ArrayList<Object[]> getEvaluacijaZnanjaByStudent(Long studentId);
	
}
