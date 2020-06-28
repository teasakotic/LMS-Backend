package backend.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.app.model.Dozvola;

public interface DozvolaRepository extends JpaRepository <Dozvola, Long> {

	Optional<Dozvola> getByNaziv(String string);
	
}

