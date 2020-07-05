package backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.app.model.Preduslov;



@Repository 
public interface PreduslovRepository extends JpaRepository<Preduslov, Long> {

} 
