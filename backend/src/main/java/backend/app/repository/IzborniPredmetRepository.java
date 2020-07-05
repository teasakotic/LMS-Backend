package backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.app.model.IzborniPredmet;



@Repository 
public interface IzborniPredmetRepository extends JpaRepository<IzborniPredmet, Long> {

} 
