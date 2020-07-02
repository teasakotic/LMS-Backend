package backend.app.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import backend.app.model.Predmet;

@Repository
public interface PredmetRepository extends JpaRepository<Predmet, Long> {
	Iterable<Optional<Predmet>> findByNazivLike(String naziv);
	ArrayList<Predmet> findByGodinaStudijaIdEquals(Long godinaStudijaId);
//	@Query("SELECT p FROM Predmet s JOIN s.preduslovi p WHERE s.obavezan = True AND s.godinaStudija.id = ?1")
	//Iterable<Predmet> getPredusloviZaObaveznePredmeteByGodinaStudija(Long godinaStudijaId);
}