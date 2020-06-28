package backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend.app.model.Nastavnik;
import backend.app.model.RealizacijaPredmeta;

@Repository
public interface RealizacijaPredmetaRepository extends JpaRepository<RealizacijaPredmeta, Long> {
	
	@Query("SELECT tr.nastavnik FROM NastavnikNaRealizaciji tr WHERE tr.tipNatave.name='Vezbe' AND tr.realizacijaPredmeta.predmet.id = ?1")
	Iterable<Nastavnik> findNastavnikeKojiDrzeVezbe(Long predmetId);
	@Query("SELECT sr FROM RealizacijaPredmeta sr JOIN sr.nastavnikNaRealizaciji tr WHERE tr.nastavnik.LicniPodacni.username= ?1")
	Iterable<RealizacijaPredmeta> findByNastavnikUsername(String username);
	Iterable<RealizacijaPredmeta> findByGodinaStudijaId(Long id);
}