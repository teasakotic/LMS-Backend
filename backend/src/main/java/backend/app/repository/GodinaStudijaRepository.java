package backend.app.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend.app.model.GodinaStudija;

@Repository
public interface GodinaStudijaRepository extends JpaRepository<GodinaStudija, Long> {
	ArrayList<GodinaStudija> findByStudijskiProgramIdEquals(Long studijskiProgramId);
	@Query("SELECT y from GodinaStudija y WHERE y.godina=?1 AND y.studijskiProgram.id=?2")
	Optional<GodinaStudija> getNarednaGodinaStudija(int godina, Long id);
}