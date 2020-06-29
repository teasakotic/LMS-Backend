package backend.app.repository;

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

}
