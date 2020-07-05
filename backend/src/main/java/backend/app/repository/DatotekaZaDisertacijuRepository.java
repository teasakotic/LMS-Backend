package backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.app.model.DatotekaZaDisertaciju;



@Repository 
public interface DatotekaZaDisertacijuRepository extends JpaRepository<DatotekaZaDisertaciju, Long> {

} 
