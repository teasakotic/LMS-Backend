package backend.app.repository;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend.app.model.Polaganje;

@Repository
public interface PolaganjeRepository extends JpaRepository<Polaganje, Long> {

	@Query("SELECT er.id, er.evaluacijaZnanja.tipEvaluacije.naziv, er.evaluacijaZnanja.vremePocetka, er.evaluacijaZnanja.vremeZavrsetka, er.evaluacijaZnanja.realizacijaPredmeta.predmet.naziv "
			+ "FROM Polaganje er " 
			+ "WHERE er.bodovis IS NULL AND er.studentNaGodini.student.id = ?1 AND er.evaluacijaZnanja.tipEvaluacije.naziv = 'FINAL' ")
	ArrayList<Polaganje> findRegisterovaneEvaluacijeZnanjaByStudentId(Long studentId);

	@Query("SELECT er.studentNaGodini.student.licniPodaci.ime, er.studentNaGodini.student.licniPodaci.prezime, "
			+ "er.studentNaGodini.brojIndeksa, er.studentNaGodini.student.id,  sr.id, er.id, sa.id, er.studentNaGodini.id "
			+ "FROM Polaganje er, RealizacijaPredmeta sr, NastavnikNaRealizaciji tr, PohadjanjePredmeta sa "
			+ "WHERE er.bodovi = NULL AND er.evaluacijaZnanja.tipEvaluacije.naziv = 'FINAL' AND (er.evaluacijaZnanja.vremeZavrsteka BETWEEN ?3 AND ?4) "
			+ "AND er.evaluacijaZnanja MEMBER OF sr.evaluacijeZnanja AND sr.predmet.id = ?1 "
			+ "AND tr.nastavnik.registrovaniKorisnik.username = ?2 "
			+ "AND tr.realizacijaPredmeta = sr AND sa.realizacijaPredmeta = sr "
			+ "AND sa.student = er.studentNaGodini.student")
	ArrayList<Object[]> findRegisterovaneEvaluacijeZnanjaByPredmet(Long predmetId, String nastavnikUsername, Date prePetnaest,
			Date danas);

}
