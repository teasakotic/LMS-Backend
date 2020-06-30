package backend.app.repository;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend.app.model.PohadjanjePredmeta;
import backend.app.model.Predmet;
import backend.app.model.Student;

@Repository
public interface PohadjanjePredmetaRepository extends JpaRepository<PohadjanjePredmeta, Long> {
	@Query("SELECT AVG(sa.konacnaOcena) FROM PohadjanjePredmeta sa WHERE sa.student.id = ?1")
	Double findProsecnaOcena(Long studentId);
	
	@Query("SELECT sa.student FROM PohadjanjePredmeta sa WHERE sa.konacnaOcena < 6 AND sa.realizacijaPredmeta.predmet.id = ?1")
	Iterable<Student> findStudentiKojiNisuPoloziliIspit(Long predmetId);
	
	@Query("SELECT DISTINCT sa.realizacijaPredmeta.predmet FROM PohadjanjePredmeta sa WHERE sa.student.registrovaniKorisnik.username = ?1 AND sa.konacnaOcena IS NULL")
	ArrayList<Predmet> findTrenutniPredmeti(String username);
	
	@Query("SELECT sa.konacnaOcena, sa.realizacijaPredmeta.predmet.naziv, sa.realizacijaPredmeta.godinaStudija.godina, "
			+ "sa.realizacijaPredmeta.godinaStudija.studijskiProgram.naziv, er.bodovi, er.evaluacijaZnanja.vremePocetka, sa.realizacijaPredmeta.predmet.espb \n" + 
			"FROM Polaganje er, PohadjanjePredmeta sa \n" + 
			"WHERE sa.student.registrovaniKorisnik.username = ?1 \n" + 
			"AND sa.realizacijaPredmeta.id = er.evaluzacijaZnanja.realizacijaPredmeta.id "
			+ "AND sa.konacnaOcena IS NOT NULL")
	ArrayList<Object> findPolozenePredmete(String username);
	
	@Query("SELECT sa.student FROM PohadjanjePredmeta sa, NastavnikNaRealizaciji tr "
			+ "WHERE sa.realizacijaPredmeta.predmet.id = ?1 "
			+ "AND sa.realizacijaPredmeta.godinaStudija.datumPocetka <= ?2 "
			+ "AND sa.realizacijaPredmeta.godinaStudija.datumKraja >= ?2 "
			+ "AND sa.realizacijaPredmeta.predmet = tr.realizacijaPredmeta.predmet "
			+ "AND tr.nastavnik.registrovaniKorisnik.username = ?3")
	ArrayList<Student> findStudentByPredmet(Long predmetId, Date danas, String nastavnikUsername);
	
}