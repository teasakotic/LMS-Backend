package backend.app.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.app.model.Ishod;

@Repository
public interface IshodRepository extends JpaRepository<Ishod, Long> {
	ArrayList<Ishod> findByPredmetIdEquals(Long predmetId);
	Iterable<Optional<Ishod>> findByPredmetId(Long id);
}