package backend.app.repository;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend.app.model.EvaluacijaZnanja;

@Repository
public interface EvaluacijaZnanjaRepository extends JpaRepository<EvaluacijaZnanja, Long> {
	@Query("SELECT sa.konacnaOcena, sa.realizacijaPredmeta.predmet.naziv, sa.realizacijaPredmeta.godinaStudija.year, sa.realizacijaPredmeta.godinaStudija.studijskiProgram.naziv, er.bodovi, er.evaluacijaZnanja.vremePocetka, sa.realizacijaPredmeta.predmet.ects "
			+ "FROM Polaganje er, PohadjanjePredmeta sa "
			+ "WHERE sa.student.id = ?1 AND sa.konacnaOcena IS NOT NULL AND er.bodovi IS NOT NULL AND er.evaluacijaZnanja.tipEvaluacije.naziv = 'FINAL' "
			+ "AND sa.realizacijaPredmeta.id = er.evaluacijaZnanja.realizacijaPredmeta.id")
	ArrayList<Object[]> getEvaluacijaZnanjaByStudent(Long studentId);
	
	@Query("SELECT e.id, e.realizacijaPredmeta.id, e.realizacijaPredmeta.predmet.naziv, e.vremePocetka, e.trajanjeUMinutima, e.tipEvaluacije.naziv, "
			+ "e.realizacijaPredmeta.godinaStudija.year, e.realizacijaPredmeta.godinaStudija.studijskiProgram.name "
			+ "FROM EvaluacijaZnanja e, PohadjanjePremdeta sa "
			+ "WHERE e.realizacijaPredmeta = sa.realizacijaPredmeta "
			+ "AND sa.konacnaOcena IS NULL "
			+ "AND sa.student.registrovaniKorisnik.username = ?1 "
			+ "AND e.vremePocetka BETWEEN ?2 AND ?3 \n"
			+ "AND e.tipEvaluacije.name = 'FINAL' "
			+ "AND e NOT IN (SELECT er.exam FROM RealizacijaPredmeta er WHERE er.studentNaGodini.student.registrovaniKorisnik.username = ?1)")
	ArrayList<Object[]> getDostupniIspitiZaRegistraciju(String studentUsername, Date plusTri, Date plusCetrnaest);
	
	@Query("SELECT e FROM EvaluacijaZnanja e, NastavnikNaRealizaciji tr WHERE e.realizacijaPredmeta.predmet.id = ?1 "
			+ "AND e.tipEvaluacije.naziv = 'NEKAEVALUACIJA'"
			+ "AND tr.nastavnik.registrovaniKorisnik.username = ?2 "
			+ "AND e.realizacijaPredmeta = tr.realizacijaPredmeta")
	EvaluacijaZnanja getNekaEvaluacijaByPredmet(Long predmetId, String nastavnikUsername);
	
	@Query("SELECT e FROM EvaluacijaZnanja e, NastavnikNaRealizaciji tr WHERE e.realizacijaPredmeta.predmet.id = ?1 "
			+ "AND e.tipEvaluacije.naziv = 'NEKAEVALUACIJA2'"
			+ "AND tr.nastavnik.registrovaniKorisnik.username = ?2 "
			+ "AND e.realizacijaPredmeta = tr.realizacijaPredmeta")
	EvaluacijaZnanja getNekaEvaluacija2ByPredmet(Long predmetId, String nastavnikUsername);
	
	@Query("SELECT e FROM EvaluacijaZnanja e, NastavnikNaRealizaciji tr WHERE e.realizacijaPredmeta.predmet.id = ?1 "
			+ "AND e.tipEvaluacije.naziv = 'FINAL'"
			+ "AND tr.nastavnik.registrovaniKorisnik.username = ?2 "
			+ "AND e.realizacijaPredmeta = tr.realizacijaPredmeta")
	EvaluacijaZnanja getFinalEvaluacijaZnanjaByPredmet(Long predmetId, String nastavnikUsername);

}
