package backend.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend.app.model.AdministrativnoOsoblje;
import backend.app.model.Student;

@Repository
public interface AdministrativnoOsobljeRepository extends JpaRepository<AdministrativnoOsoblje, Long> {

	@Query("SELECT DISTINCT s, sy.godinStudija.godina FROM Student s JOIN s.studentNaGodini sy JOIN s.pohadjanjePredmeta sa JOIN sa.realizacijaPredmeta sr WHERE sy.godinaStudija.id=?1 AND sa.konacnaOcena IS NOT NULL GROUP BY s.id HAVING (SUM(sr.predmet.espb))>=(48*(sy.godinaStudija.godina))")
	Iterable<Student> findStudentiZaUpisUNarednuGodinu(Long godinaStudijaId);
	@Query("SELECT a FROM AdministrativnoOsoblje a WHERE a.RegistrovaniKorisnik.username = ?1")
	Optional<AdministrativnoOsoblje> getByUsername(String username);
}