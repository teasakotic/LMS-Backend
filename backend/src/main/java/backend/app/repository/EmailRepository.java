package backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.app.model.Email;



@Repository 
public interface EmailRepository extends JpaRepository<Email, Long> {

} 
