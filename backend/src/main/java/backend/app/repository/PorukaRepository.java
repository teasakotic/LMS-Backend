package backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import backend.app.model.Poruka;

@Repository
public interface PorukaRepository extends JpaRepository<Poruka, Long> {
	Iterable<Poruka> findByPrimalacOrPosiljalac(String primalac, String posiljalac);
}
