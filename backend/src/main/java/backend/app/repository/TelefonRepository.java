package backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.app.model.Telefon;


@Repository 
public interface TelefonRepository extends JpaRepository<Telefon, Long> {

} 
