package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.TipEvaluacije;

@Repository
public interface TipEvaluacijeRepository extends JpaRepository<TipEvaluacije, Long> {
	
}
