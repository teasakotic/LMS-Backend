package backend.app.repository;

import java.sql.Date;
import java.util.Optional;

import javax.security.auth.Subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import backend.app.model.Nastavnik;
import backend.app.model.NastavnikNaRealizaciji;

@Repository
public interface NastavnikNaRealizacijiRepository extends JpaRepository<NastavnikNaRealizaciji, Long> {
	@Query("SELECT tr.nastavnik FROM NastavnikNaRealizaciji tr WHERE tr.realizacijaPredmeta.predmet.id = ?1")
	Iterable<Nastavnik> findNastavniciKojiDrzePredmete(Long predmetId);
	@Query("SELECT tr FROM NastavnikNaRealizaciji tr WHERE tr.realizacijaPredmeta.godinaStudija.id = ?1")
	Iterable<Optional<NastavnikNaRealizaciji>> getByGodinaStudija(Long yearGodinaStudijaId);
	
	@Query(
	"SELECT tr.realizacijaPredmeta.predmet FROM NastavnikNaRealizaciji tr \n"
			+ "WHERE tr.nastavnik.registrovaniKorisnik.username = :username \n"
			+ "AND tr.realizacijaPredmeta.godinaStudija.datumPocetka <= :danas \n"
			+ " AND tr.realizacijaPredmeta.godinaStudija.datumKraja >= :danas")
	Iterable<Subject> getNastavnickiPredmeti(@Param("username") String username, @Param("danas") Date danas);
	}
