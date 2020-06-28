package backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.app.model.TipEvaluacije;

@Repository
public interface TipEvaluacijeRepository extends JpaRepository<TipEvaluacije, Long> {
	
}
