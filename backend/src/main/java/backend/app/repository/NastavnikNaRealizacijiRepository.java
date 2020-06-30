package backend.app.repository;


import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import backend.app.model.Nastavnik;
import backend.app.model.NastavnikNaRealizaciji;

@Repository
public interface NastavnikNaRealizacijiRepository extends JpaRepository<NastavnikNaRealizaciji, Long> {
	@Query("SELECT tr.nastavnik FROM NastavnikNaRealizaciji tr WHERE tr.realizacijaPredmeta.predmet.id = ?1")
	Iterable<Nastavnik> findNastavniciKojiDrzePredmete(Long predmetId);
	@Query("SELECT tr FROM NastavnikNaRealizaciji tr WHERE tr.realizacijaPredmeta.godinaStudija.id = ?1")
	Iterable<Optional<NastavnikNaRealizaciji>> getByGodinaStudija(Long godinaStudijaId);
	
	}