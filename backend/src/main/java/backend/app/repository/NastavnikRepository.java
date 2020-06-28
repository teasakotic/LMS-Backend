package backend.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend.app.model.Nastavnik;

@Repository
public interface NastavnikRepository extends JpaRepository<Nastavnik, Long> {
	@Query("SELECT t FROM Nastavnik t WHERE t.licniPodaci.ime LIKE ?1")
	Iterable<Optional<Nastavnik>> findNastavnikByIme(String ime);
	
	@Query("SELECT t FROM Nastavnik t WHERE t.licniPodaci.brTelefona = ?1")
	Optional<Nastavnik> findNastavnikByJmbg(String jmbg);
	
	@Query("SELECT t FROM Nastavnik t WHERE t.registrovaniKorisnik.username = ?1")
	Optional<Nastavnik> getByUsername(String username);
	
	@Query("SELECT DISTINCT tr.nastavnik FROM NastavnikNaRealizaciji tr WHERE tr.realizacijaPredmeta.godinaStudija.studijskiProgram.fakultet.id = ?1")
	Iterable<Optional<Nastavnik>> getAllByFakultet(Long fakultetId);
}