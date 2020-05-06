package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.EvaluacijaZnanjaIshod;

@Repository
public interface EvaluacijaZnanjaIshodRepository extends JpaRepository<EvaluacijaZnanjaIshod, Long> {

}
