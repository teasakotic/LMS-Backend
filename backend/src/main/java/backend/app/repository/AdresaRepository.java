package backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.app.model.Adresa;

@Repository 
public interface AdresaRepository extends JpaRepository<Adresa, Long> {

} 

